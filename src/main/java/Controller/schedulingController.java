package Controller;

import Pojo.*;
import Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.List;

@Controller
public class sschedulingController {

    @Resource
    private AdminService adminService;

    public void selectAllCourse(Model model,HttpServletRequest request){
        int perPageSize = 5;//每页n个
        int totalCount =adminService.getCourseCount();
        int totalPage = 0;
        if(totalCount == 0){
            totalPage = 0;
        }else{
            totalPage = (int)Math.ceil((double) totalCount/perPageSize);//返回大于等于指定表达式的最小整数
        }
        String pageCurll = request.getParameter("pageCur");
        if(pageCurll == null){
            pageCurll = "1";
        }
        int pageCur = Integer.parseInt(pageCurll);
        if((pageCur-1)*perPageSize>totalCount){
            pageCur = pageCur-1;
        }
        int startIndex = (pageCur-1)*perPageSize;//起始位置
        List<Course> page_course;
        page_course = adminService.queryPageCourse(startIndex,perPageSize);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageCur",pageCur);
        request.setAttribute("startIndex",startIndex);
        model.addAttribute("pageCourse",page_course);
    }

    //选择排课班级 显示所有课程信息
    @RequestMapping(value = "/selectClass")
    public String selectClass(HttpSession session,Model model, HttpServletRequest request){
        //显示所有排课班级
        model.addAttribute("AllClass",adminService.selectClass());
        session.setAttribute("AllClass",adminService.selectClass());
        //显示所有排课教室
        model.addAttribute("AllClassroom",adminService.selectAllClassroom());
        session.setAttribute("AllClassroom",adminService.selectAllClassroom());

        selectAllCourse(model, request);
        return "WEB-INF/showAdministerPages/scheduling";
    }

    //查看课表
    @RequestMapping(value = "/searchSchedule")
    public String searchSchedule(HttpSession session,Model model, HttpServletRequest request){
        model.addAttribute("AllClass",adminService.selectClass());
        session.setAttribute("AllClass",adminService.selectClass());
        String sclass=request.getParameter("selectClass");
        String smester=request.getParameter("selectSemester");
        List<Curriculum> curricula = adminService.selectScheduleCourse(sclass,smester);
        model.addAttribute("kebiao",curricula);
        return "WEB-INF/showAdministerPages/showSchedule";
    }

    //处理课程冲突并排课
    @RequestMapping(value = "/handleSchedule")
    public String handleScedule(HttpSession session,Model model, HttpServletRequest request) {
        String selectClass = request.getParameter("selectClass");
        String selectClassroom = request.getParameter("selectClassroom");
        String selectCourses = request.getParameter("scheduleCourse");
        String selectSemester=request.getParameter("selectSemester");
        String selectDay=request.getParameter("selectDay");
        String selectTime=request.getParameter("selectTime");

        Schedule schedule = new Schedule(0, selectClass, selectDay, selectTime, selectCourses, adminService.findClassroom(selectClassroom),selectSemester);

        //链接数据库
        String url = "jdbc:mysql://localhost:3306/student_system"; //数据库名
        String username = "root";  //数据库用户名
        String password = "jimmy1016";  //数据库用户密码
        ResultSet resultSet=null;
        ResultSet resultSet1=null;
        ResultSet resultSet2=null;

        PreparedStatement preparedStatement1,preparedStatement2,preparedStatement3,preparedStatement4,preparedStatement5,preparedStatement6,preparedStatement7,preparedStatement8,preparedStatement9,preparedStatement10,preparedStatement11;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态
            String sql1 = "select * from schedule where (sclass,day,time,smester) in (select sclass,day,time,smester from schedule group by sclass,day,time,smester having count(*) > 1);";

            String sql2 = "select * from schedule where (idclassroom,day,time,smester) in (select idclassroom,day,time,smester from schedule group by idclassroom,day,time,smester having count(*) > 1); ";

            String sql3="select * from schedule where (cid,day,time,smester) in (select cid,day,time,smester from schedule group by cid,day,time,smester having count(*) > 1);";

            String sql4="delete from schedule where id in (select id from(SELECT max(id) id from schedule)a);";

            preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement2=conn.prepareStatement(sql2);
            preparedStatement3=conn.prepareStatement(sql3);
            preparedStatement4 = conn.prepareStatement(sql4);

            //查询并删除同专业在相同时间段选择的课程
            adminService.insertSchedule(schedule);
            resultSet=preparedStatement1.executeQuery();
            resultSet1=preparedStatement2.executeQuery();
            resultSet2=preparedStatement3.executeQuery();

            if(resultSet.next()||resultSet1.next()||resultSet2.next()){
                preparedStatement4.execute();
                List<Integer> students=adminService.selectSid(selectClass);
                int tid=adminService.selectTid(selectCourses);
                int cid=Integer.parseInt(selectCourses);
                for (Integer student : students) {
                    int sid= student;
                    adminService.deleteStudents(sid, cid, tid);
                }
                request.setAttribute("SchedulingError", "选课冲突！");
                conn.close();
                selectClass(session,model,request);
                return "WEB-INF/showAdministerPages/scheduling";
            }
            /*if(resultSet1.next()){
                preparedStatement4.execute();
                List<Integer> students=sService.selectSid(selectClass);
                int tid=sService.selectTid(selectCourses);
                int cid=Integer.parseInt(selectCourses);
                for (Integer student : students) {
                    int sid= student;
                    sService.deleteStudents(sid, cid, tid);
                }
                request.setAttribute("SchedulingError", "教室在该时间段已被占用！");
                conn.close();
                selectClass(session,model,request);
                return "WEB-INF/showAdministerPages/showSchedule";
            }
            if(resultSet2.next()){
                preparedStatement4.execute();
                List<Integer> students=sService.selectSid(selectClass);
                int tid=sService.selectTid(selectCourses);
                int cid=Integer.parseInt(selectCourses);
                for (Integer student : students) {
                    int sid= student;
                    sService.deleteStudents(sid, cid, tid);
                }
                request.setAttribute("SchedulingError", "教师授课重复！");
                conn.close();
                selectClass(session,model,request);
                return "WEB-INF/showAdministerPages/showSchedule";
            }*/
            List<Integer> students=adminService.selectSid(selectClass);
            int tid=adminService.selectTid(selectCourses);
            int cid=Integer.parseInt(selectCourses);
            for (Integer student : students) {
                int sid= student;
                adminService.insertStudents(sid, cid, tid);
            }
            selectClass(session,model,request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchSchedule(session,model,request);
    }

    //查看所有已排课程
    @RequestMapping(value = "/AllSchedule")
    public String AllSchedule(HttpSession session,Model model, HttpServletRequest request){
        //显示课程信息
        int perPageSize = 5;//每页n个
        int totalCount =adminService.allScheduleCount();
        int totalPage = 0;
        if(totalCount == 0){
            totalPage = 0;
        }else{
            totalPage = (int)Math.ceil((double) totalCount/perPageSize);//返回大于等于指定表达式的最小整数
        }
        String pageCurll = request.getParameter("pageCur");
        if(pageCurll == null){
            pageCurll = "1";
        }
        int pageCur = Integer.parseInt(pageCurll);
        if((pageCur-1)*perPageSize>totalCount){
            pageCur = pageCur-1;
        }
        int startIndex = (pageCur-1)*perPageSize;//起始位置
        List<AllSchedule> page_course;
        page_course = adminService.schedulePage(startIndex,perPageSize);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageCur",pageCur);
        request.setAttribute("startIndex",startIndex);
        //model.addAttribute("courses",cService.queryAllcourse());
        model.addAttribute("pageCourse",page_course);
        return "WEB-INF/showAdministerPages/AllSchedule";
    }

    //批量删除
    @RequestMapping(value = "/scheduleDel")
    public String scheduleDel(HttpServletRequest request, Model model){
        String[] arr_id = request.getParameterValues("scheduleCourse");
        if(adminService.delSchedule(arr_id)>0){
            request.setAttribute("SchedulingError", "删除成功！");
        }
        else{
            request.setAttribute("SchedulingError", "删除失败，请重新尝试！");
        }
        return "WEB-INF/showAdministerPages/AllSchedule";
    }

}
