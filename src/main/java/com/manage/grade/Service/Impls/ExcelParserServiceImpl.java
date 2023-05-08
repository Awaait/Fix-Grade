package com.manage.grade.Service.Impls;

import com.manage.grade.Entity.Student;
import com.manage.grade.Service.ExcelParserService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @className: ExcelParserServiceImpl
 * @author: YCJ
 * @date: 2023/05/08 下午3:41
 **/
@Service
public class ExcelParserServiceImpl implements ExcelParserService {
    @Override
    public List<Student> ParseStudentExcel(File file) {
        return null;
    }
}
