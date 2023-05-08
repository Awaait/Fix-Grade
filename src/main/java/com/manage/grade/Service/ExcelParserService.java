package com.manage.grade.Service;

import com.manage.grade.Entity.Student;

import java.io.File;
import java.util.List;

public interface ExcelParserService {
    List<Student> ParseStudentExcel(File file);
}
