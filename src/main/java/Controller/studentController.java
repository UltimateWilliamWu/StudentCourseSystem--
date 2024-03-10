package Controller;


import Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Pojo.Student;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class studentController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/studentAdd",method = RequestMethod.POST)
    public String save(Student s, Model model,HttpServletRequest request){
        if(adminService.saveStudent(s)>0){
            request.setAttribute("loginError", "插入成功！");
            return "WEB-INF/showAdministerPages/teacherSC";
        }
        else{
            request.setAttribute("loginError", "插入失败，请重新尝试！");
            return "WEB-INF/showAdministerPages/teacherSC";
        }
    }

    //查询
    @RequestMapping(value = "/studentAll")
    public String all(HttpServletRequest request,Model model){
        int perPageSize = 5;//每页n个
        int totalCount =adminService.getStudentCount();
        System.out.println(totalCount);
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

        List<Student> page_student;
        page_student = adminService.queryPagestudent(startIndex,perPageSize);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageCur",pageCur);
        request.setAttribute("startIndex",startIndex);
        //model.addAttribute("courses",cService.queryAllcourse());
        model.addAttribute("pageStudent",page_student);
        return "WEB-INF/showAdministerPages/showStudents";
    }

    @RequestMapping(value = "studentDel")
    public String del(HttpServletRequest request,Model model){
        String[] arr_id = request.getParameterValues("selectedStudents");
        if(adminService.delStudent(arr_id)>0){
            request.setAttribute("loginError", "删除成功！");
            return "WEB-INF/showAdministerPages/teacherSC";
        }
        else{
            request.setAttribute("loginError", "删除失败，请重新尝试！");
            return "WEB-INF/showAdministerPages/teacherSC";
        }
    }

    @RequestMapping(value="studentInsert")
    public String studentInsert(){
        return "WEB-INF/showAdministerPages/insertStudent";
    }
}
