package com.manage.grade.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String StudentId;
    private String ClassName;
    private String name;
    private String subject;
    private int score;
}
