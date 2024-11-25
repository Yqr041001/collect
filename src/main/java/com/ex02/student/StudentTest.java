package com.ex02.student;

import com.ex02.student.mapper.StudentMapper;
import com.ex02.student.po.Student;
import com.ex02.student.utils.StudentDBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    @Test
    public void studentTest() {
        SqlSession sqlSession = StudentDBUtil.getSession();
        int count = -1;

        // 生成Mapper的代理对象studentMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        // 精确查询测试
        Student student = studentMapper.selectStudentBySno("100000001");
        System.out.println(student);

        // 模糊查询测试
        List<Student> list = studentMapper.selectStudentBySname("小");
        for (Student stu : list) {
            System.out.println(stu);
        }

        // 插入记录测试
        student = new Student();
        student.setSno("100000008");
        student.setSname("刘伟");
        student.setSsex("男");
        student.setSnative("广东汕头");
        student.setMno(2);
        count = studentMapper.insertStudent(student);
        sqlSession.commit();
        System.out.println("成功插入了" + count + "条记录。");

        // 删除记录测试
        count = studentMapper.deleteStudent("100000004");
        sqlSession.commit();
        System.out.println("成功删除了" + count + "条记录。");

        // 更新记录测试
        student.setSno("100000002");
        student.setSname("廖凡");
        student.setSsex("男");
        student.setSnative("广东汕头");
        student.setMno(2);
        count = studentMapper.updateStudent(student);
        sqlSession.commit();
        System.out.println("成功更新了" + count + "条记录。");

        sqlSession.close();
    }
}
