package DAO;

import Pojo.Course;
import Pojo.Curriculum;
import Pojo.TeacherSeeStudents;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherCourseDAO {
    @Select("select * from course where Tid=#{tid} and cid in (select cid from schedule)")
    @ResultType(Course.class)
    List<Course> selectTeacherCourse(int tid);

    @Select("select sc.Sid,Sname,Sdept,Sclass,Ggrades,Tgrades,Fgrades,Cname from sc,course,student where sc.Sid=student.Sid and sc.Cid=course.Cid and sc.Tid=#{tid} and sc.cid in (select cid from schedule)")
    @ResultType(TeacherSeeStudents.class)
    List<TeacherSeeStudents> TeacherStudents(@Param("tid")int tid);

    @Select("select sc.Sid,sc.Cid,Sname,Sdept,Sclass,Ggrades,Tgrades,Fgrades,Cname from sc,course,student where sc.Sid=student.Sid and sc.Cid=course.Cid and sc.Cid=#{cid}")
    @ResultType(TeacherSeeStudents.class)
    List<TeacherSeeStudents> courseStudents(@Param("cid")int cid);

    @Update("update sc,course set Ggrades=#{ggrades},Tgrades=#{tgrades},Fgrades=#{fgrades} where Sid=#{sid} and sc.Cid=course.Cid and course.cname=#{cname};")
    void giveGrades(@Param("ggrades")float ggrades,@Param("tgrades")float tgrades,@Param("fgrades")float fgrades,@Param("sid")int sid,@Param("cname")String cname);

    @Select("select Cname,CcourseDay,Ccoursetime from course where course.Tid=#{teacherID} and course.Csemester=#{csemester};")
    List<Curriculum> TeacherSelectCourse(@Param("teacherID") int tid, @Param("csemester") String semester);

    @Select("select schedule.day,schedule.time,Cname,TName,location from schedule,course,teacher,classroom where course.Cid in (select Cid from course where tid=#{teacherID}) and schedule.cid=course.Cid and course.Tid=teacher.Tid and schedule.idclassroom=classroom.id and schedule.smester=#{smester};")
    List<Curriculum> TeacherCurriculum(@Param("teacherID")int tid,@Param("smester")String smester);

}
