package Controller;

import Pojo.Administer;
import Pojo.Student;
import Pojo.Teacher;
import Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value="/StudentLogin",method = RequestMethod.POST)
    public String loginStudent(Student student, HttpServletRequest request){
        HttpSession session= request.getSession();
        if(adminService.loginStudent(student)==null){
            request.setAttribute("loginError", "登录失败，用户名或密码错误 请重新尝试！");
            return "login";
        }
        else{
            session.setAttribute("studentID",adminService.loginStudent(student).getSid());
            return "/WEB-INF/showStudentPages/StudentSystem";
        }
    }

    @RequestMapping(value="/TeacherLogin",method = RequestMethod.POST)
    public String loginTeacher(Teacher teacher,HttpServletRequest request,HttpServletResponse response){
        HttpSession session= request.getSession();
        if(adminService.loginTeacher(teacher)==null){
            request.setAttribute("loginError", "登录失败，用户名或密码错误 请重新尝试！");          // 设置错误属性
            return "login";
        }
        else{
            session.setAttribute("teacherID",adminService.loginTeacher(teacher).getTid());
            return "/WEB-INF/showTeacherPages/TeacherSystem";
        }
    }

    @RequestMapping(value="/AdministerLogin",method = RequestMethod.POST)
    public String loginAdminister(Administer administer,Model model,HttpServletRequest request){
        if(adminService.loginAdminister(administer)==null){
            request.setAttribute("loginError", "登录失败，用户名或密码错误 请重新尝试！");
            return "administerLogin";
        }
        else{
            return "WEB-INF/showAdministerPages/teacherSC";
        }
    }

    @RequestMapping(value="/backToPage")
    public String backToPage(){
        return "index";
    }
}
