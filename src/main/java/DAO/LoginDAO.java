package DAO;

import Pojo.Administer;
import Pojo.Student;
import Pojo.Teacher;
import org.apache.ibatis.annotations.Select;

public interface LoginDAO {
    @Select("select * from student where Sid=#{sid} and Spassword=#{spassword}")
    Student selectStudent(Student student);

    @Select("select * from teacher where Tid=#{tid} and Tpassword=#{tpassword}")
    Teacher selectTeacher(Teacher teacher);

    @Select("select * from administer where name=#{name} and password=#{password}")
    Administer selectAdminister(Administer administer);
}
