package Service;

import Pojo.*;

import java.util.List;

public interface StudentService {

    int getCourseCount();//获取课程页

    List<Course> queryPageCourse(int startIndex, int perPageSize);//查询课程的页数

    List<StudentGrades> selectGrades(int sid);//根据学号查询学生成绩

    List<student_value> getValues(int sno);//根据学号查询学生学分

    List<Course> selectCertainCourses(Course course);//查询课程名相关课程

    List<Course> selectCertainCoursesCid(Course course);//查询课程号相关课程

    List<Course> selectCertainCourseCSemester(Course course);//查询课程学期相关课程

    //获取各个分数段的学生以及总学生数 从而统计各个分数段的学生占比
    String selectAllStudents(int cid);

    String selectAStudents(int cid);

    String selectBStudents(int cid);

    String selectCStudents(int cid);

    String selectDStudents(int cid);

    String selectEStudents(int cid);

    void selectCourses(String[] cid,String sid,int[] tid);//学生选课

    int selectTeacher(String cid);//找到任课老师

    List<SelectedCourses> selectedCourses(String sid);//已选课程

    void deleteCourses(String[] cid,String sid,int[] tid);//学生退课

    List<Curriculum> selectCurriculum(int sid,String smester);//根据学号查课表

}
