package DAO;

import Pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminSchedulingDAO {
    @Select("select * from classroom")
    @ResultType(Classroom.class)
    List<Classroom> selectAllClassroom();

    @Select("select Cname,TName,location,schedule.day,schedule.time from course,schedule,teacher,classroom where schedule.cid=course.Cid and schedule.sclass=#{sclass} and course.Tid=teacher.Tid and schedule.idclassroom=classroom.id and schedule.smester=#{smester};")
    List<Curriculum> selectScheduleCourse(@Param("sclass") String sclass,@Param("smester")String smester);

    @Insert("insert into schedule values(#{id},#{sclass},#{day},#{time},#{cid},#{idclassroom},#{smester})")
    void insertSchedule(Schedule s);

    @Select("select id from classroom where classroom.location=#{location};")
    String classroom(String location);

    @Insert("insert into sc values(#{sid},#{cid},#{tid},0,0,0)")
    void addStudentGrades(@Param("sid") int sid,@Param("cid") int cid,@Param("tid") int tid);

    @Delete("delete from sc where sid=#{sid}")
    void delStudentGrades(int sid);

    @Select("select count(*) from schedule")
    int getCount();

    @Select("select schedule.id,schedule.sclass,schedule.day,schedule.time,cname,location,TName from schedule,course,classroom,teacher where schedule.cid=course.cid and schedule.idclassroom=classroom.id and course.Tid=teacher.Tid limit #{startIndex},#{perPageSize}")
    @ResultType(AllSchedule.class)
    List<AllSchedule> selectPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);

    @Delete("delete from schedule where id=#{sid}")
    int delete(int id);

    @Select("select sid from student where sclass=#{sclass};")
    List<Integer> selectSid(String sclass);

    @Select("select tid from course where cid=#{cid};")
    int selectTid(String cid);
}
