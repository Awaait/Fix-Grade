package com.manage.grade.Dao;

import com.manage.grade.Entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Insert("INSERT  into student (id, class_name, name, score) values " +
            "(#{student.id},#{student.ClassName},#{student.name},#{student.score})")
    int AddNewStudent(@Param("student") Student student);

    @Delete("delete from student where id=#{id}")
    int DeleteStudentById(@Param("id") Integer id);

    @Update("update student set score=#{score} where id=#{id}")
    int UpdateStudentScore(@Param("id") Integer id, @Param("score") Integer score);

    @Select("select id,class_name,name,score from student where class_name=#{ClassName}")
    List<Student> SelectStudentByClassName();
}
