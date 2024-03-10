package Controller;

import Pojo.Classroom;
import Pojo.Course;
import Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class classroomController {
    @Resource
    private AdminService adminService;
    @RequestMapping(value="/insertClassroom")
    public String insertClassroom(){
        return "WEB-INF/showAdministerPages/insertClassroom";
    }

    @RequestMapping(value = "/classroomInsert")
    public String ClassroomInsert(Classroom c, HttpServletRequest request){
        if(adminService.addClassroom(c)>0){
            request.setAttribute("loginError", "添加成功！");
        }
        else{
            request.setAttribute("loginError", "添加失败，请重新尝试！");
        }
        return "WEB-INF/showAdministerPages/teacherSC";
    }

    //查询所有课程
    @RequestMapping(value = "/classroomAll")
    public String all(HttpServletRequest request, Model model){
        int perPageSize = 5;//每页n个
        int totalCount =adminService.getClassroomCount();
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

        List<Classroom> page_course;
        page_course = adminService.queryPageClassroom(startIndex,perPageSize);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageCur",pageCur);
        request.setAttribute("startIndex",startIndex);
        //model.addAttribute("courses",cService.queryAllcourse());
        model.addAttribute("pageCourse",page_course);
        return "WEB-INF/showAdministerPages/showClassroom";
    }

    //删除课程
    @RequestMapping(value = "classroomDel")
    public String del(HttpServletRequest request, Model model){
        String[] arr_id = request.getParameterValues("selectedClassroom");
        if(adminService.delClassroom(arr_id)>0){
            request.setAttribute("loginError", "删除成功！");
        }
        else{
            request.setAttribute("loginError", "删除失败，请重新尝试！");
        }
        return "WEB-INF/showAdministerPages/teacherSC";
    }
}
