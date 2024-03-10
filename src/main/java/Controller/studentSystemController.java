package Controller;

import Pojo.Course;
import Pojo.Curriculum;
import Pojo.StudentGrades;
import Pojo.student_value;
import Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class studentSystemController {
    @Resource
    private StudentService studentService;

    public void selectAllCourse(Model model,HttpServletRequest request){
        int perPageSize = 5;//每页n个
        int totalCount =studentService.getCourseCount();
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
        page_course = studentService.queryPageCourse(startIndex,perPageSize);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageCur",pageCur);
        request.setAttribute("startIndex",startIndex);
        model.addAttribute("courses",page_course);
    }

    @RequestMapping(value = "/selectAllCourse",method = RequestMethod.GET)
    public String selectAll(Model model,HttpServletRequest request){
        selectAllCourse(model,request);
        return "WEB-INF/showStudentPages/selectAllCourse";
    }

    @RequestMapping(value = "/selectCertainCourse",method = RequestMethod.GET)
    public String selectCertain(Course certainCourses, Model model){
        if(certainCourses!=null){
            model.addAttribute("certainCourses",studentService.selectCertainCourses(certainCourses));
        }
        return "WEB-INF/showStudentPages/selectLikeCourse";
    }

    @RequestMapping(value="/selectCertainCoursesCid")
    public String selectCertainCoursesCid(Course course,Model model){
        model.addAttribute("certainCourses",studentService.selectCertainCoursesCid(course));
        return "WEB-INF/showStudentPages/selectLikeCourse";
    }

    @RequestMapping(value = "/selectCertainCoursesCSemester")
    public String selectCertainCoursesCSemester(Course course,Model model){
        model.addAttribute("certainCourses",studentService.selectCertainCourseCSemester(course));
        return "WEB-INF/showStudentPages/selectLikeCourse";
    }

    @RequestMapping(value = "selectStudentCourse",method = RequestMethod.GET)
    public String selectStudentCourse(HttpServletRequest request,Model model, HttpSession session, @RequestParam(required = true)String studentID){
        selectAllCourse(model,request);

        session.setAttribute("studentID",studentID);
        String[] selectCourse = request.getParameterValues("course");
        if(selectCourse!=null){
            int[] tid = new int[selectCourse.length];
            for (int i=0;i<selectCourse.length;i++) {
                tid[i]=studentService.selectTeacher(selectCourse[i]);
            }
            studentService.selectCourses(selectCourse,studentID,tid);
        }
        return "WEB-INF/showStudentPages/selectAllCourse";
    }

    @RequestMapping(value = "selectedCourses",method = RequestMethod.GET)
    public String selectedCourses(Model model,HttpSession session,HttpServletRequest request){
        String studentID=String.valueOf(session.getAttribute("studentID"));
        if(studentService.selectedCourses(studentID)!=null){
            model.addAttribute("selectedCourses",studentService.selectedCourses(studentID));
            session.setAttribute("selectedCourses",studentService.selectedCourses(studentID));
            return "WEB-INF/showStudentPages/selectedCourses";
        }
        else{
            request.setAttribute("loginError", "请先选课！");
            return "WEB-INF/showStudentPages/StudentSystem";
        }
    }

    @RequestMapping(value="delselectedCourses",method=RequestMethod.GET)
    public String delselectedCourses(Model model,HttpSession session,HttpServletRequest request){
        String studentID=String.valueOf(session.getAttribute("studentID"));
        String[] delCourse = request.getParameterValues("deleteCourse");
        if(delCourse!=null){
            int[] tid=new int[delCourse.length];
            for(int i=0;i<delCourse.length;i++){
                tid[i]=studentService.selectTeacher(delCourse[i]);
            }
            studentService.deleteCourses(delCourse,studentID,tid);
        }
        model.addAttribute("selectedCourses",studentService.selectedCourses(studentID));
        return "WEB-INF/showStudentPages/selectedCourses";
    }

    @RequestMapping(value = "kebiao")
    public String kebiao(Model model,HttpSession session,HttpServletRequest request){
        String studentID=String.valueOf(session.getAttribute("studentID"));
        String selectSemester=request.getParameter("selectSemester");
        List<Curriculum> kebiao =studentService.selectCurriculum(Integer.parseInt(studentID),selectSemester);
        model.addAttribute("kebiao",kebiao);
        return "WEB-INF/showStudentPages/curriculum";
    }

    @RequestMapping(value = "/selectGrades")
    public String selectGrades(Model model,HttpSession session,HttpServletRequest request){
        String studentID=String.valueOf(session.getAttribute("studentID"));
        List<StudentGrades> studentGrades=studentService.selectGrades(Integer.parseInt(studentID));
        if(studentGrades.isEmpty()){
            request.setAttribute("loginError", "学生还未选课！");
            return "WEB-INF/showStudentPages/StudentSystem";
        }
        else{
            model.addAttribute("grades",studentGrades);
            return "WEB-INF/showStudentPages/selectGrades";
        }
    }

    @RequestMapping(value = "allValues")
    public String getValues(Model model,HttpSession session){
        String studentID=String.valueOf(session.getAttribute("studentID"));
        int id = Integer.parseInt(studentID);
        List<student_value> values = studentService.getValues(id);
        model.addAttribute("values",values);
        return "WEB-INF/showStudentPages/showCredits";
    }

    @RequestMapping(value="analysisGrades")
    public String analysisGrades(HttpSession session){
        String studentID=String.valueOf(session.getAttribute("studentID"));
        session.setAttribute("selectedCourses",studentService.selectedCourses(studentID));
        return "WEB-INF/showStudentPages/analysisGrades";
    }

    @RequestMapping(value="handleAnalysis")
    public String handleAnalysis(HttpSession session,HttpServletRequest request){
        String selectCourse= request.getParameter("selectCourse");
        session.setAttribute("allStudents",studentService.selectAllStudents(Integer.parseInt(selectCourse)));
        session.setAttribute("A",studentService.selectAStudents(Integer.parseInt(selectCourse)));
        session.setAttribute("B",studentService.selectBStudents(Integer.parseInt(selectCourse)));
        session.setAttribute("C",studentService.selectCStudents(Integer.parseInt(selectCourse)));
        session.setAttribute("D",studentService.selectDStudents(Integer.parseInt(selectCourse)));
        session.setAttribute("E",studentService.selectEStudents(Integer.parseInt(selectCourse)));
        return "WEB-INF/showStudentPages/analysisGrades";
    }
}
