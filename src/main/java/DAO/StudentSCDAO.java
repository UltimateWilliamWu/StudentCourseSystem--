package DAO;

import Pojo.Curriculum;
import Pojo.SelectedCourses;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentSCDAO {
    @Insert("insert into sc values(${sid},${cid},${tid},null,null,null)")
    void selectCourses(@Param("sid") int sid,@Param("cid") int cid,@Param("tid") int tid);

    @Select("select Tid from course where Cid=${cid}")
    int selectTeacher(int cid);

    @Select("select sc.Cid,Cname,Csemester,Ccredits,Tname from sc,course,teacher,schedule where Sid=#{sid} and sc.Cid=course.Cid and sc.Tid=teacher.Tid and sc.cid=schedule.cid;")
    List<SelectedCourses> selectedCourses(int sid);

    @Delete("delete from sc where Sid=${sid} and Cid=${cid} and Tid=${tid}")
    void deleteCourses(@Param("sid") int sid,@Param("cid") int cid,@Param("tid") int tid);

    @Select("select Cname,CcourseDay,Ccoursetime from course,sc where sc.Sid=#{studentID} and course.Cid = sc.Cid and course.Csemester=#{csemester};")
    List<Curriculum> selectCourse(@Param("studentID") int sid,@Param("csemester") String semester);

    @Select("select schedule.day,schedule.time,Cname,TName,location from schedule,course,teacher,classroom,sc where sc.cid=course.Cid and course.Tid=teacher.Tid and schedule.idclassroom=classroom.id and schedule.smester=#{smester} and sc.sid=#{studentID} and sc.cid=schedule.cid;")
    List<Curriculum> selectCurriculum(@Param("studentID") int sid,@Param("smester") String smester);
}
