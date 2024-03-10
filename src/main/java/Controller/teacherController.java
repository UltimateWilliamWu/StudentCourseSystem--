package Controller;


import Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Pojo.Teacher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class teacherController {
    @Resource
    private AdminService adminService;
    @RequestMapping(value = "/teacherAdd",method = RequestMethod.POST)
    public String save(Teacher t, Model model,HttpServletRequest request){
        if(adminService.saveTeacher(t)>0){
            request.setAttribute("loginError", "添加成功！");
            return "WEB-INF/showAdministerPages/teacherSC";
        }
        else{
            request.setAttribute("loginError", "添加失败，请重新尝试！");
            return "WEB-INF/showAdministerPages/teacherSC";
        }
    }

    //查询
    @RequestMapping(value = "/teacherAll")
    public String all(HttpServletRequest request,Model model){
        int perPageSize = 5;//每页n个
        int totalCount =adminService.getTeacherCount();
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

        List<Teacher> page_teacher;
        page_teacher = adminService.queryPageteacher(startIndex,perPageSize);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageCur",pageCur);
        request.setAttribute("startIndex",startIndex);
        //model.addAttribute("courses",cService.queryAllcourse());
        model.addAttribute("pageTeacher",page_teacher);
        return "WEB-INF/showAdministerPages/showTeachers";
    }


    @RequestMapping(value = "teacherDel")
    public String del(HttpServletRequest request){
        String[] arr_id = request.getParameterValues("selectedTeachers");
        if(adminService.delTeacher(arr_id)>0){
            request.setAttribute("loginError", "删除成功！");
        }
        else{
            request.setAttribute("loginError", "删除失败，请重新尝试！");;
        }
        return "WEB-INF/showAdministerPages/teacherSC";
    }

    @RequestMapping(value="teacherInsert")
    public String teacherInsert(){
        return "WEB-INF/showAdministerPages/insertTeacher";
    }
}
