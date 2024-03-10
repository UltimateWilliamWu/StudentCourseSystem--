package Service;

import DAO.TeacherCourseDAO;
import Pojo.Course;
import Pojo.Curriculum;
import Pojo.TeacherSeeStudents;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Resource
    private TeacherCourseDAO teacherCourseDAO;//老师对学生以及课程操作

    @Override
    public List<Course> teacherCourse(int tid) {
        return teacherCourseDAO.selectTeacherCourse(tid);
    }

    @Override
    public List<TeacherSeeStudents> teacherStudent(int tid) {
        return teacherCourseDAO.TeacherStudents(tid);
    }

    @Override
    public List<TeacherSeeStudents> studentCourse(int cid) {
        return teacherCourseDAO.courseStudents(cid);
    }

    @Override
    public void giveGrades(int stu, String cname, float ggrads, float tgrades, float fgrades) {
        teacherCourseDAO.giveGrades(ggrads, tgrades, fgrades, stu, cname);
    }

    @Override
    public List<Curriculum> selectTeacherCurriculum(int tid,String smester) {
        return teacherCourseDAO.TeacherCurriculum(tid,smester);
    }
}
