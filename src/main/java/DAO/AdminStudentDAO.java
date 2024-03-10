package DAO;

import Pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminStudentDAO {
    @Insert("insert into student values(#{sid},#{sname},#{ssex},#{sdept},#{sphone},#{scollege},#{spassword},#{sclass})")
    int insert(Student s);

    @Select("select * from student")
    @ResultType(Student.class)
    List<Student> selectAll();

    @Select("select * from student group by Sclass")
    @ResultType(Student.class)
    List<Student> selectClass();

    @Delete("delete from student where Sid=#{sid}")
    int delete(int sno);

    @Select("select count(*) from student")
    int getCount();


    @Select("select * from student limit #{startIndex},#{perPageSize}")
    @ResultType(Student.class)
    List<Student> selectPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
}
