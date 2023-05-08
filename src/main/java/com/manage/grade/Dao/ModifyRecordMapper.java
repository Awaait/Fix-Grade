package com.manage.grade.Dao;

import com.manage.grade.Entity.ModifyRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModifyRecordMapper {
    @Insert("INSERT into modify_record (id, student_id, modify_time, modify_method) values " +
            "(#{record.id},#{record.StudentId},#{record.modify_time},#{record.modify_method})")
    void AddNewRecord(ModifyRecord Record);

    @Delete("delete from modify_record where id=#{id}")
    void DeleteRecordById(Integer id);

    @Select("select id,student_id,modify_time,modify_method from modify_record where student_id=#{StuId}")
    List<ModifyRecord> SelectStudentModifyRecordByStuId(Integer StuId);
}
