package Service;

import DAO.*;
import Pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentCourseDAO studentCourseDAO;//学生对课程操作
    @Resource
    private StudentSCDAO studentSCDAO;//针对选课操作
    @Resource
    private AdminCourseDAO adminCourseDAO;

    //获取可选课程总数
    @Override
    public  int getCourseCount(){
        return adminCourseDAO.getCount();
    }

    //获取可选课程页面
    @Override
    public List<Course> queryPageCourse(int startIndex, int perPageSize){
        return adminCourseDAO.selectPage(startIndex,perPageSize);
    }

    //获取学生课程成绩
    @Override
    public List<StudentGrades> selectGrades(int sid) {
        return studentCourseDAO.selectGrades(sid);
    }

    //模糊查询课程（课程名、课程号、课程学期）
    @Override
    public List<Course> selectCertainCourses(Course course) {
        return studentCourseDAO.selectLikeCourse(course);
    }

    @Override
    public List<Course> selectCertainCoursesCid(Course course) {
        return studentCourseDAO.selectLikeCourseCid(course);
    }

    @Override
    public List<Course> selectCertainCourseCSemester(Course course) {
        return studentCourseDAO.selectLikeCourseCSemester(course);
    }

    //获取学生学分
    @Override
    public List<student_value> getValues(int sno) {
        return studentCourseDAO.getValues(sno);
    }

    //统计学生课程成绩（根据课程——查询各个分数段的学生）
    @Override
    public String selectAllStudents(int cid) {
        return studentCourseDAO.selectAllPeople(cid);
    }

    @Override
    public String selectAStudents(int cid) {
        return studentCourseDAO.selectAPeople(cid);
    }

    @Override
    public String selectBStudents(int cid) {
        return studentCourseDAO.selectBPeople(cid);
    }

    @Override
    public String selectCStudents(int cid) {
        return studentCourseDAO.selectCPeople(cid);
    }

    @Override
    public String selectDStudents(int cid) {
        return studentCourseDAO.selectDPeople(cid);
    }

    @Override
    public String selectEStudents(int cid) {
        return studentCourseDAO.selectEPeople(cid);
    }

    //学生选课
    @Override
    public void selectCourses(String[] selectCourses,String sid,int[] tid) {
        for (int i=0;i<selectCourses.length;i++) {
            studentSCDAO.selectCourses(Integer.parseInt(sid),Integer.parseInt(selectCourses[i]),tid[i]);
        }
    }

    //查询课程老师
    @Override
    public int selectTeacher(String cid) {
        return studentSCDAO.selectTeacher(Integer.parseInt(cid));
    }

    //已选课程
    @Override
    public List<SelectedCourses> selectedCourses(String sid) {
        List<SelectedCourses> selectedCourses=new ArrayList<>();
        selectedCourses= studentSCDAO.selectedCourses(Integer.parseInt(sid));
        return selectedCourses;
    }

    //退课
    @Override
    public void deleteCourses(String[] cid, String sid, int[] tid) {
        for(int i=0;i< cid.length;i++){
            studentSCDAO.deleteCourses(Integer.parseInt(sid),Integer.parseInt(cid[i]),tid[i]);
        }
    }

    //获取学生课表
    @Override
    public List<Curriculum> selectCurriculum(int sid,String smester) {
        return studentSCDAO.selectCurriculum(sid,smester);
    }

}
