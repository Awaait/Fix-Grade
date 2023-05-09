package com.manage.grade.Entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelIgnoreUnannotated
public class Student {
    private int id;
    @ExcelProperty(value = "学号")
    private String studentId;
    @ExcelProperty(value = "班级")
    private String className;
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "学科")
    private String subject;
    @ExcelProperty(value = "成绩")
    private int score;
}
