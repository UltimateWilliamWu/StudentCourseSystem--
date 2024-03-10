<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022-06-26
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生选课系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../AdministerUI/css/form.css">
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
                <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                    <p style="font-size: 30px;">欢迎来到教务管理系统</p>
                    <form action="courseAdd" method="post" style="text-align: left">
                        课程号:<input type="text" name="cid">
                        教师号:<input type="text" name="tid">
                        课程名:<input type="text" name="cname">
                        学分:<input type="text" name="ccredits">
                        学期:<input type="text" name="csemester">
                        学年:<input type="text" name="cyear">
                        上课日:<input type="text" name="ccourseday">
                        上课时间:<input type="text" name="ccoursetime">
                        <input type="submit" value="提交">
                    </form>

                </div>
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
</html>
