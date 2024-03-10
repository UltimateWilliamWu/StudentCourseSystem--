package DAO;

import Pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminCourseDAO {
    @Insert("insert into course values(#{cid},#{tid},#{cname},#{ccredits},#{csemester},#{cyear},#{ccourseday},#{ccoursetime})")
    int insert(Course c);

    @Select("select * from course")
    @ResultType(Course.class)
    List<Course> selectAll();

    @Delete("delete from course where Cid=#{cid}")
    int delete(int cno);

    @Select("select count(*) from course")
    int getCount();

    @Select("select * from course limit #{startIndex},#{perPageSize}")
    @ResultType(Course.class)
    List<Course> selectPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
}
