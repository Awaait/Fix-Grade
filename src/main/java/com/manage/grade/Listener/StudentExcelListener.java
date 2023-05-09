package com.manage.grade.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.manage.grade.Dao.StudentMapper;
import com.manage.grade.Dao.UserMapper;
import com.manage.grade.Entity.Student;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class StudentExcelListener extends AnalysisEventListener<Student> {

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 2;
    List<Student> list = new ArrayList<Student>(BATCH_COUNT);

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }
    private StudentMapper studentMapper;
    private void saveData() {
        log.info(String.format("{%d}条数据，开始存储数据库！", list.size()));
//        studentMapper.AddNewStudent();
        log.info("存储数据库成功！");
    }

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        log.info(String.format("解析到一条数据:{%s}", student.toString()));
        list.add(student);

        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }
}