package com.manage.grade.Service.Impls;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manage.grade.Dao.UserMapper;
import com.manage.grade.Entity.LoginUser;
import com.manage.grade.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);
        //查询是否存在该用户 如果无抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在或密码错误");
        }
        List<String> list = new ArrayList<>(Arrays.asList("stu", "teacher", "superAdmin"));
        int RoleIndex = userMapper.selectRoleByUsernameInt(username);
        List<String> FinalList = new ArrayList<>();
        for (int i = 0; i <= RoleIndex; i++) {
            FinalList.add(list.get(i));
        }
        return new LoginUser(user, FinalList);
    }
}
