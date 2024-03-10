package Service;

import Pojo.*;

import java.util.List;

public interface TeacherService {

    List<Course> teacherCourse(int tid);//查询当前老师所有课程

    List<TeacherSeeStudents> teacherStudent(int tid);//查询选择当前老师课程的所有学生

    List<TeacherSeeStudents> studentCourse(int cid);//根据课程号查询所有学生

    void giveGrades(int stu, String cname, float ggrads, float tgrades, float fgrades);//给学生打分

    List<Curriculum> selectTeacherCurriculum(int tid, String smester);//根据教师号查课表

}
