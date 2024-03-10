package DAO;

import org.apache.ibatis.annotations.*;
import Pojo.Teacher;

import java.util.List;

public interface AdminTeacherDao {
    //添加学生
    @Insert("insert into student values(#{tid},#{tname},#{tsex},#{tsalary},#{tposition},#{tcollege},#{tphone},#{tpassword})")
    int insert(Teacher t);

    //查看所有老师
    @Select("select * from teacher")
    @ResultType(Teacher.class)
    List<Teacher> selectAll();

    //删除老师
    @Delete("delete from teacher where Tid=#{tid}")
    int delete(int tno);

    //获取老师总数（分页）
    @Select("select count(*) from teacher")
    int getCount();

    //获取显示集合（分页）
    @Select("select * from teacher limit #{startIndex},#{perPageSize}")
    @ResultType(Teacher.class)
    List<Teacher> selectPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
}
