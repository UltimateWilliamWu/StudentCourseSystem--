<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-06-22
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生选课系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../StudentUI/css/table.css">
    <link href="https://fonts.googleapis.com/css?family=Oxygen:300,400" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="../../StudentUI2/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="../../StudentUI2/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="../../StudentUI2/css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="../../StudentUI2/css/magnific-popup.css">

    <!-- Flexslider  -->
    <link rel="stylesheet" href="../../StudentUI2/css/flexslider.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="../../StudentUI2/css/style.css">

    <!-- Modernizr JS -->
    <script src="../../StudentUI2/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="../../StudentUI2/js/respond.min.js"></script>
    <![endif]-->

</head>
<script type="text/javascript">
    function base64 (content) {
        return window.btoa(unescape(encodeURIComponent(content)));
    }
    /*
    *@tableId: table的Id
    *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
    */
    function tableToExcel(tableID,fileName){
        var table = document.getElementById(tableID);
        var excelContent = table.innerHTML;
        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
        excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
        excelFile += "<body><table>";
        excelFile += excelContent;
        excelFile += "</table></body>";
        excelFile += "</html>";
        var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
        var a = document.createElement("a");
        a.download = fileName+".xlsx";
        a.href = link;
        a.click();
    }
</script>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <nav class="fh5co-nav" role="navigation">
        <div class="container-wrap">
            <div class="top-menu">
                <div class="row">
                    <div class="col-xs-2">
                        <div id="fh5co-logo"><a href=" ">教务系统</a></div>
                    </div>
                    <div class="col-xs-10 text-right menu-1">
                        <ul>
                            <li><a href="backToPage" >返回首页</a></li>
                            <li class="has-dropdown">
                                <a href=" ">插入</a>
                                <ul class="dropdown">
                                    <li><a href="studentInsert">插入新学生</a></li>
                                    <li><a href="teacherInsert">插入新教师</a></li>
                                    <li><a href="courseInsert">插入新课程</a></li>
                                    <li><a href="insertClassroom">插入新教室</a></li>
                                </ul>
                            </li>
                            <li class="has-dropdown">
                                <a href=" ">查询</a>
                                <ul class="dropdown">
                                    <li><a href="studentAll">查询所有学生</a></li>
                                    <li><a href="teacherAll">查询所有教师</a></li>
                                    <li><a href="courseAll">查询所有课程</a></li>
                                    <li><a href="classroomAll">查询所有教室</a></li>
                                </ul>
                            </li>
                            <li class="has-dropdown">
                                <a href=" ">排课</a>
                                <ul class="dropdown">
                                    <li><a href="selectClass">排课</a></li>
                                    <li><a href="searchSchedule">查看课表</a></li>
                                    <li><a href="AllSchedule">查看已排课程</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <div class="container-wrap">
        <div id="fh5co-work" class="fh5co-light-grey">
            <div class="row animate-box">
                <p style="font-size: 30px;text-align: center">欢迎来到教务管理系统</p>
                <form action="scheduleDel" style="margin: 0 auto">
                    <hr>
                    <button type="button" style="float: right" onclick="tableToExcel('AllSchedule','schedule')">导出xls</button>
                    <table border="1" style="margin: 0 auto" id="AllSchedule">
                        <tr style="height: 80px;text-align: center">
                            <th style="height: 80px;text-align: center">专业</th>
                            <th style="height: 80px;text-align: center">课程名</th>
                            <th style="height: 80px;text-align: center">上课日</th>
                            <th style="height: 80px;text-align: center">上课时间</th>
                            <th style="height: 80px;text-align: center">教室</th>
                            <th style="height: 80px;text-align: center">教师名</th>
                            <th style="height: 80px;text-align: center">批量删除</th>
                        </tr>
                        <c:forEach items="${requestScope.pageCourse}" var="c">
                            <tr style="height: 80px">
                                <td align="center">${c.sclass}</td>
                                <td align="center">${c.day}</td>
                                <td align="center">${c.time}</td>
                                <td align="center">${c.cname}</td>
                                <td align="center">${c.location}</td>
                                <td align="center">${c.tname}</td>
                                <td align="center"><input type="checkbox" name="scheduleCourse" class="delCourses" value="${c.id}"></td>
                            </tr>
                        </c:forEach>
                        <tr style="height: 80px">
                            <td colspan="6" align="right">
                                &nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
                                第${pageCur}页&nbsp;&nbsp;
                                <c:url var="url_pre" value="selectClass">
                                    <c:param name="pageCur" value="${pageCur-1}"></c:param>
                                </c:url>
                                <c:url var="url_next" value="selectClass">
                                    <c:param name="pageCur" value="${pageCur+1}"></c:param>
                                </c:url>
                                <c:if test="${pageCur!=1}">
                                    <a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                </c:if>
                                <c:if test="${pageCur != totalPage && totalPage != 0}">
                                    <a href="${url_next}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                </c:if>
                            </td>
                            <td colspan="1" align="center">
                                <input type="submit" value="删除">
                            </td>
                        </tr>
                    </table>
                </form>



            </div>

            <div class="row copyright">
                <div class="col-md-12 text-center">
                    <p>
                        <big class="block">&copy; 2023 吴天雄. All Rights Reserved.</big>
                    <hr>
                    <big class="block">Designed by <a href="https://freehtml5.co/" target="_blank">FreeHTML5.co</a> Demo Images: <a href="http://unsplash.co/" target="_blank">Unsplash</a></big>
                    </p>
                </div>
            </div>

        </div>


    </div><!-- END container-wrap -->


</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
</div>

<!-- jQuery -->
<script src="../../StudentUI2/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="../../StudentUI2/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="../../StudentUI2/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="../../StudentUI2/js/jquery.waypoints.min.js"></script>
<!-- Flexslider -->
<script src="../../StudentUI2/js/jquery.flexslider-min.js"></script>
<!-- Magnific Popup -->
<script src="../../StudentUI2/js/jquery.magnific-popup.min.js"></script>
<script src="../../StudentUI2/js/magnific-popup-options.js"></script>
<!-- Counters -->
<script src="../../StudentUI2/js/jquery.countTo.js"></script>
<!-- Main -->
<script src="../../StudentUI2/js/main.js"></script>

</body>
<%
    String errorInfo = (String)request.getAttribute("SchedulingError");         // 获取错误属性
    if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=errorInfo%>");                                            // 弹出错误信息

    // 跳转到登录界面
</script>
<%
    }
%>
</html>