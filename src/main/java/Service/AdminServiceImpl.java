package Service;

import DAO.*;
import Pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private LoginDAO loginDAO;//登录操作
    @Resource
    private AdminStudentDAO adminStudentDAO;//管理员对学生操作
    @Resource
    private AdminTeacherDao adminTeacherDao;//管理员对老师操作
    @Resource
    private AdminCourseDAO adminCourseDAO;//管理员对课程操作
    @Resource
    private AdminClassroomDAO adminClassroomDAO;//管理员对教室操作
    @Resource
    private AdminSchedulingDAO adminSchedulingDAO;//管理员排课操作

    @Override
    public Student loginStudent(Student student) {
        return loginDAO.selectStudent(student);
    }

    @Override
    public Teacher loginTeacher(Teacher teacher) {
        return loginDAO.selectTeacher(teacher);
    }

    @Override
    public Administer loginAdminister(Administer administer) {
        return loginDAO.selectAdminister(administer);
    }

    @Override
    public int saveCourse(Course c){
        return adminCourseDAO.insert(c);
    }

    @Override
    public int delCourse(String[] arr){
        int num = 0;
        for (String s : arr) {
            num += adminCourseDAO.delete(Integer.parseInt(s));
        }
        return num;
    }

    @Override
    public  int getCourseCount(){
        return adminCourseDAO.getCount();
    }

    @Override
    public List<Course> queryPageCourse(int startIndex, int perPageSize){
        return adminCourseDAO.selectPage(startIndex,perPageSize);
    }

    @Override
    public int saveStudent(Student s){
        return adminStudentDAO.insert(s);
    }

    @Override
    public int delStudent(String[] arr){
        int num = 0;
        for (String s : arr) {
            num += adminStudentDAO.delete(Integer.parseInt(s));
        }
        return num;
    }

    @Override
    public  int getStudentCount(){
        return adminStudentDAO.getCount();
    }

    @Override
    public List<Student> queryPagestudent(int startIndex, int perPageSize){
        return adminStudentDAO.selectPage(startIndex,perPageSize);
    }


    @Override
    public int saveTeacher(Teacher t){
        return adminTeacherDao.insert(t);
    }

    @Override
    public int delTeacher(String[] arr){
        int num = 0;
        for (String s : arr) {
            num += adminTeacherDao.delete(Integer.parseInt(s));
        }
        return num;
    }

    @Override
    public  int getTeacherCount(){
        return adminTeacherDao.getCount();
    }

    @Override
    public List<Teacher> queryPageteacher(int startIndex, int perPageSize){
        return adminTeacherDao.selectPage(startIndex,perPageSize);
    }

    @Override
    public int addClassroom(Classroom c) {
        return adminClassroomDAO.insert(c);
    }

    @Override
    public int delClassroom(String[] arr) {
        int num = 0;
        for (String s : arr) {
            num += adminClassroomDAO.delete(Integer.parseInt(s));
        }
        return num;
    }

    @Override
    public int getClassroomCount() {
        return adminClassroomDAO.getCount();
    }

    @Override
    public List<Classroom> queryPageClassroom(int startIndex, int perPageSize) {
        return adminClassroomDAO.selectPage(startIndex,perPageSize);
    }

    @Override
    public List<Student> selectClass(){return adminStudentDAO.selectClass();}

    @Override
    public List<Classroom> selectAllClassroom(){return adminSchedulingDAO.selectAllClassroom();}

    @Override
    public List<Curriculum> selectScheduleCourse(String sclass,String smester) {
        return adminSchedulingDAO.selectScheduleCourse(sclass,smester);
    }

    @Override
    public void insertSchedule(Schedule s) {
        adminSchedulingDAO.insertSchedule(s);
    }

    @Override
    public int allScheduleCount() {
        return adminSchedulingDAO.getCount();
    }

    @Override
    public List<AllSchedule> schedulePage(int startIndex, int perPageSize) {
        return adminSchedulingDAO.selectPage(startIndex,perPageSize);
    }

    @Override
    public int delSchedule(String[] arr) {
        int num = 0;
        for (String s : arr) {
            num += adminSchedulingDAO.delete(Integer.parseInt(s));
        }
        return num;
    }

    @Override
    public String findClassroom(String location) {
        return adminSchedulingDAO.classroom(location);
    }

    @Override
    public void insertStudents(int sid,int cid,int tid) {
        adminSchedulingDAO.addStudentGrades(sid,cid,tid);
    }

    @Override
    public void deleteStudents(int sid, int cid, int tid) {
        adminSchedulingDAO.delStudentGrades(sid);
    }

    @Override
    public List<Integer> selectSid(String sclass) {
        return adminSchedulingDAO.selectSid(sclass);
    }

    @Override
    public int selectTid(String cid) {
        return adminSchedulingDAO.selectTid(cid);
    }
}
