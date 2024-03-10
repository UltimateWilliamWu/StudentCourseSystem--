package Controller;

import Pojo.Curriculum;
import Service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class teacherSystemController {
    @Resource
    private TeacherService service;

    @RequestMapping(value = "/teacherCourse",method = RequestMethod.GET) //查询当前老师的课程
    public String teacherCourse(Model model, HttpSession session){
        String teacherID=String.valueOf(session.getAttribute("teacherID"));
        model.addAttribute("courses",service.teacherCourse(Integer.parseInt(teacherID)));
        return "WEB-INF/showTeacherPages/teacherCourse";
    }

    @RequestMapping(value = "/teacherStudent",method=RequestMethod.GET) //查询选择当前老师指定课程的所有学生
    public String teacherStudent(Model model,HttpSession session){
        String teacherID=String.valueOf(session.getAttribute("teacherID"));
        model.addAttribute("courses",service.teacherCourse(Integer.parseInt(teacherID)));
        model.addAttribute("students",service.teacherStudent(Integer.parseInt(teacherID)));
        return "WEB-INF/showTeacherPages/teacherAllStudents";
    }

    @RequestMapping(value="/courseStudent",method = RequestMethod.GET) //根据课程查询学生信息
    public String courseStudent(Model model,HttpSession session,HttpServletRequest request){
        String teacherID=String.valueOf(session.getAttribute("teacherID"));
        String selectCourse= request.getParameter("selectCourse");
        model.addAttribute("students",service.studentCourse(Integer.parseInt(selectCourse)));
        model.addAttribute("courses",service.teacherCourse(Integer.parseInt(teacherID)));
        return "WEB-INF/showTeacherPages/teacherAllStudents";
    }

    @RequestMapping(value = "/findStudents",method=RequestMethod.GET) //教师找到学生
    public String findStudents(Model model,HttpSession session,HttpServletRequest request){
        String teacherID=String.valueOf(session.getAttribute("teacherID"));
        model.addAttribute("courses",service.teacherCourse(Integer.parseInt(teacherID)));
        model.addAttribute("students",service.teacherStudent(Integer.parseInt(teacherID)));
        return "WEB-INF/showTeacherPages/teacherGrade";
    }

    @RequestMapping(value="/giveGrades",method = RequestMethod.GET) //教师打分
    public String giveGrades(Model model,HttpSession session,HttpServletRequest request){
        String teacherID=String.valueOf(session.getAttribute("teacherID"));
        String[] stu= request.getParameterValues("studentID");
        String[] cname= request.getParameterValues("cname");
        String[] ggrades= request.getParameterValues("ggrades");
        String[] tgrades= request.getParameterValues("tgrades");
        String[] fgrades= request.getParameterValues("fgrades");
        for(int i=0;i<stu.length;i++){
            service.giveGrades(Integer.parseInt(stu[i]),cname[i],Float.parseFloat(ggrades[i]),Float.parseFloat(tgrades[i]),Float.parseFloat(fgrades[i]));
            System.out.println("学生号："+stu[i]+" 课程名"+cname[i]+" 平时成绩："+ggrades[i]);
        }
        model.addAttribute("courses",service.teacherCourse(Integer.parseInt(teacherID)));
        model.addAttribute("students",service.teacherStudent(Integer.parseInt(teacherID)));
        return "WEB-INF/showTeacherPages/teacherAllStudents";
    }

    @RequestMapping(value="teacherkeibiao") //教师课表
    public String teacherkeibiao(Model model,HttpSession session,HttpServletRequest request){
        String teacherID=String.valueOf(session.getAttribute("teacherID"));
        String selectSemester=request.getParameter("selectSemester");
        /*List<Curriculum> kebiao = service.TeacherSelectCourse(Integer.parseInt(teacherID),selectSemester);*/
        List<Curriculum> kebiao=service.selectTeacherCurriculum(Integer.parseInt(teacherID),selectSemester);
        model.addAttribute("kebiao",kebiao);
        return "WEB-INF/showTeacherPages/teacherCurriculum";
    }
}
