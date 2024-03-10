<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022-06-22
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <nav class="fh5co-nav" role="navigation">
        <div class="container-wrap">
            <div class="top-menu">
                <div class="row">
                    <div class="col-xs-2">
                        <div id="fh5co-logo"><a href=" ">选课系统</a></div>
                    </div>
                    <div class="col-xs-10 text-right menu-1">
                        <ul>
                            <li><a href="selectAllCourse">所有课程</a></li>
                            <li class="has-dropdown">
                                <a href="selectCertainCourse">查询课程</a>
                                <ul class="dropdown">
                                    <li><a href="#">课程名查询</a></li>
                                    <li><a href="#">课程号查询</a></li>
                                    <li><a href="#">教师名查询</a></li>
                                    <li><a href="#">学分查询</a></li>
                                </ul>
                            </li>
                            <li><a href="selectedCourses" >学生选课</a></li>
                            <li><a href="selectGrades" >成绩查询</a></li>
                            <li><a href="kebiao">生成课表</a></li>
                            <li class="active"><a href="allValues" >已选学分</a></li>
                            <li><a href="analysisGrades">成绩分析</a> </li>
                            <li><a href="backToPage" >返回首页</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <!--页面基本内容 -->
    <div class="container-wrap">
        <div id="fh5co-work" class="fh5co-light-grey">
            <div class="row animate-box">
                <p style="font-size: 30px;text-align: center">欢迎来到选课系统</p>
                <hr>
                <p style="text-align: center">以下为当前学生所选课程的总学分：</p>
                <form class="smart-green" style="text-align: center">
                    <table border="1" style="margin: 0 auto" class="smart-green">
                        <tr style="height: 80px;text-align: center">
                            <th style="height: 80px;text-align: center">学号</th>
                            <th style="height: 80px;text-align: center">已选学分</th>
                        </tr>
                        <c:forEach items="${values}" var="s">
                            <tr style="height: 80px">
                                <td align="center">${s.sid}</td>
                                <td align="center">${s.value}</td>
                            </tr>
                        </c:forEach>
                    </table><br><br>
                    <input type="hidden" name="studentID" value=${sessionScope.studentID}>
                </form>
                <br>
                <br>
            </div>

            <div class="row copyright">
                <div class="col-md-12 text-center">
                    <p>
                        <big class="block">&copy; 2022 吴天雄. All Rights Reserved.</big>
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
</html>
