package DAO;

import Pojo.Classroom;
import Pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminClassroomDAO {
    @Insert("insert into classroom values(#{id},#{location},#{capacity})")
    int insert(Classroom c);

    @Delete("delete from classroom where id=#{id}")
    int delete(int id);

    @Select("select count(*) from classroom")
    int getCount();

    @Select("select * from classroom limit #{startIndex},#{perPageSize}")
    @ResultType(Classroom.class)
    List<Classroom> selectPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
}
