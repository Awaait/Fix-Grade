package com.manage.grade.Controller;

import com.manage.grade.Entity.ResponseResult;
import com.manage.grade.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('teacher')")
    public String Login() {
        return "hello";
    }
}
