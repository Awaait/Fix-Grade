package com.manage.grade.Controller;

import com.manage.grade.Entity.ResponseResult;
import com.manage.grade.Entity.User;
import com.manage.grade.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);

    }
    @RequestMapping("/logout")
    public ResponseResult Logout() {
        return loginService.logout();
    }
}
