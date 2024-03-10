package Service;

import Pojo.*;

import java.util.List;

public interface AdminService {
    Student loginStudent(Student student);//学生登录功能

    Teacher loginTeacher(Teacher teacher);//老师登录功能

    Administer loginAdminister(Administer administer);//管理员登录功能

    int saveCourse(Course c); //管理员插入课程

    int delCourse(String[] arr);//删除课程

    int getCourseCount();//获取课程页

    List<Course> queryPageCourse(int startIndex, int perPageSize);//查询课程的页数

    int saveStudent(Student s); //插入学生

    int delStudent(String[] arr);//删除学生

    int getStudentCount();//获取学生总数

    List<Student> queryPagestudent(int startIndex, int perPageSize);//获取学生页

    int saveTeacher(Teacher t);//插入老师

    int delTeacher(String[] arr);//删除老师

    int getTeacherCount();//获取老师总数

    List<Teacher> queryPageteacher(int startIndex, int perPageSize);//获取老师页

    int addClassroom(Classroom c);//添加教室

    int delClassroom(String[] arr);//删除教室

    int getClassroomCount();//获取教室总数

    List<Classroom> queryPageClassroom(int startIndex, int perPageSize);//获取教室页

    List<Student> selectClass(); //查询所有专业

    List<Classroom> selectAllClassroom(); //查询所有教室

    List<Curriculum> selectScheduleCourse(String sclass,String smester); //根据专业查课表

    void insertSchedule(Schedule s); //排课

    int allScheduleCount();//获取排课总数

    List<AllSchedule> schedulePage(int startIndex, int perPageSize);//获取排课页数

    int delSchedule(String[] arr);//批量删除排课

    String findClassroom(String location);//根据教室地点查教室的id

    void insertStudents(int sid,int cid,int tid);//添加学生进入选课列表

    void deleteStudents(int sid,int cid,int tid);//删除学生进入选课列表

    List<Integer> selectSid(String sclass);//根据专业选学生

    int selectTid(String cid);//根据课程选老师
}
