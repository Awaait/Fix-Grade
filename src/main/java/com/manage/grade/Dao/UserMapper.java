package com.manage.grade.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manage.grade.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT role from user where username=#{username}")
    int selectRoleByUsernameInt(@Param("username") String username);
}
