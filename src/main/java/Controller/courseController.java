package Controller;

import Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Pojo.Course;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class courseController {
    @Resource
    private AdminService adminService;
    //添加课程
    @RequestMapping(value = "/courseAdd",method = RequestMethod.POST)
    public String save(Course c, HttpServletRequest request){
        if(adminService.saveCourse(c)>0){
            request.setAttribute("loginError", "添加成功！");
        }
        else{
            request.setAttribute("loginError", "添加失败，请重新尝试！");
        }
        return "WEB-INF/showAdministerPages/teacherSC";
    }

    //查询所有课程
    @RequestMapping(value = "/courseAll")
    public String all(HttpServletRequest request,Model model){
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
        //model.addAttribute("courses",cService.queryAllcourse());
        model.addAttribute("pageCourse",page_course);
        return "WEB-INF/showAdministerPages/showCourses";
    }

    //删除课程
    @RequestMapping(value = "courseDel")
    public String del(HttpServletRequest request, Model model){
        String[] arr_id = request.getParameterValues("selectedCourses");
        if(adminService.delCourse(arr_id)>0){
            request.setAttribute("loginError", "删除成功！");
        }
        else{
            request.setAttribute("loginError", "删除失败，请重新尝试！");
        }
        return "WEB-INF/showAdministerPages/teacherSC";
    }

    @RequestMapping(value="/courseInsert")
    public String courseInsert(){
        return "WEB-INF/showAdministerPages/insertCourse";
    }
}
