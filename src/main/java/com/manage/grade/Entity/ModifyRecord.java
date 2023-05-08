package com.manage.grade.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRecord {
    private int id;
    private String StudentId;
    private String subject;
    private int ModifyMethod;
    private Date ModifyTime;

}
