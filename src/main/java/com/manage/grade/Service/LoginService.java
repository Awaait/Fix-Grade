package com.manage.grade.Service;

import com.manage.grade.Entity.ResponseResult;
import com.manage.grade.Entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
