package com.ex02.student.mapper;

import com.ex02.student.po.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 根据学号精确查询学生信息
     * @param sno 学号
     * @return 学生对象
     */
    Student selectStudentBySno(@Param("sno") String sno);

    /**
     * 根据姓名模糊查询学生信息
     * @param sname 姓名
     * @return 学生列表
     */
    List<Student> selectStudentBySname(@Param("sname") String sname);

    /**
     * 插入学生信息
     * @param student 学生对象
     * @return 影响的行数
     */
    int insertStudent(Student student);

    /**
     * 删除学生信息
     * @param sno 学号
     * @return 影响的行数
     */
    int deleteStudent(@Param("sno") String sno);

    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 影响的行数
     */
    int updateStudent(Student student);
}
