package DAO;

import Pojo.Course;
import Pojo.StudentGrades;
import Pojo.Teacher;
import Pojo.student_value;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface StudentCourseDAO {
    @Select("select * from course")
    @ResultType(Course.class)
    List<Course> selectAllCourse();

    @Select("select * from course where Cname like CONCAT('%',#{cname},'%')")
    @ResultType(Course.class)
    List<Course> selectLikeCourse(Course course);

    @Select("select * from course where Cid like CONCAT('%',#{cid},'%')")
    @ResultType(Course.class)
    List<Course> selectLikeCourseCid(Course course);

    @Select("select count(*) from sc where sc.Cid=#{cid} and Fgrades between 90 and 100")
    String selectAPeople(int cid);

    @Select("select count(*) from sc where sc.Cid=#{cid} and Fgrades between 80 and 89")
    String selectBPeople(int cid);

    @Select("select count(*) from sc where sc.Cid=#{cid} and Fgrades between 70 and 79")
    String selectCPeople(int cid);

    @Select("select count(*) from sc where sc.Cid=#{cid} and Fgrades between 60 and 69")
    String selectDPeople(int cid);

    @Select("select count(*) from sc where sc.Cid=#{cid} and Fgrades between 0 and 59")
    String selectEPeople(int cid);

    @Select("select count(*) from sc where sc.Cid=#{cid}")
    String selectAllPeople(int cid);

    @Select("select * from course where Csemester like CONCAT('%',#{csemester},'%')")
    @ResultType(Course.class)
    List<Course> selectLikeCourseCSemester(Course course);

    @Select("select Cname,Ggrades,Tgrades,Fgrades from course,sc where sc.Cid=course.cid and sc.Sid=#{sid};")
    List<StudentGrades> selectGrades(int sid);

    @Select("{ call allValues(#{sno})}")
    @Options(statementType = StatementType.CALLABLE)
    @ResultType(student_value.class)
    List<student_value> getValues(int sno);
}
