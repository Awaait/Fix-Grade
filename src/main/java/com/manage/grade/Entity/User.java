package com.manage.grade.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")//指定表名
public class User {
    private int id;
    private String username;
    private String password;
    private String StuId;
    private String StuName;
    private int role;

    public Boolean CheckIsAdmin() {
        return this.role == 1;
    }

}
