package com.manage.grade.Service.Impls;

import com.manage.grade.Dao.StudentMapper;
import com.manage.grade.Entity.Student;
import com.manage.grade.Service.ExcelParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExcelParserServiceImplTest {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    private ExcelParserServiceImpl excelParserService;
    @Test
    public void testParseExcel(){
        excelParserService.ParseStudentExcel(new File("E:\\FIx\\grade\\src\\main\\resources\\static\\Excel\\1.xlsx"));
    }

}