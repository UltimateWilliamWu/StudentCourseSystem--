<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://kit.fontawesome.com/454334835f.js" crossorigin="anonymous"></script>

    <title>课程设计</title>
    <link rel="shortcut icon" href="./img/1.png">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
    <!--

    TemplateMo 550 Diagoona

    https://templatemo.com/tm-550-diagoona

    -->
</head>

<body>
<div class="tm-container">
    <div>
        <div class="tm-row pt-4">
            <div class="tm-col-left">
                <div class="tm-site-header media">
                    <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                    <div class="media-body">
                        <h1 class="tm-sitename text-uppercase">学生管理系统</h1>
                        <p class="tm-slogon">Student Management System</p>
                    </div>
                </div>
            </div>
            <div class="tm-col-right">
                <nav class="navbar navbar-expand-lg" id="tm-main-nav">
                    <button class="navbar-toggler toggler-example mr-0 ml-auto" type="button"
                            data-toggle="collapse" data-target="#navbar-nav"
                            aria-controls="navbar-nav" aria-expanded="false" aria-label="Toggle navigation">
                        <span><i class="fas fa-bars"></i></span>
                    </button>
                    <div class="collapse navbar-collapse tm-nav" id="navbar-nav">
                        <ul class="navbar-nav text-uppercase">
                            <li class="nav-item active">
                                <a class="nav-link tm-nav-link" href="#">主页 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link tm-nav-link" href="administerLogin.jsp">管理员登录</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link tm-nav-link" href="login.jsp">教师/学生登录</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link tm-nav-link" href="">关于</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>

        <div class="tm-row">
            <div class="tm-col-left"></div>
            <main class="tm-col-right">
                <section class="tm-content">
                    <h2 class="mb-5 tm-content-title">软件开发技术（Ⅲ）课程设计</h2>
                    <p class="mb-5">&nbsp;&nbsp;该项目分为三个系统：教务系统，选课系统，评分系统。数据库设计方面，共有5个关系模型对应管理员，教师，学生信息，同时还有使用触发器保证学生选课不能重复，以及数据库存储过程来实现查询学生的学分</p>
                    <hr class="mb-5">
                    <p class="mb-5">对应用户是管理员、学生、教师</p>
                    <a href="" class="btn btn-primary">Continue...</a>
                </section>
            </main>
        </div>
    </div>

    <div class="tm-row">
        <div class="tm-col-left text-center">
            <ul class="tm-bg-controls-wrapper">
                <li class="tm-bg-control active" data-id="0"></li>
                <li class="tm-bg-control" data-id="1"></li>
                <li class="tm-bg-control" data-id="2"></li>
            </ul>
        </div>
        <div class="tm-col-right tm-col-footer">
            <footer class="tm-site-footer text-right">
                <p class="mb-0">Copyright 2023 吴天雄
                    | Design: <a rel="nofollow" target="_parent" href="https://templatemo.com" class="tm-text-link">吴天雄</a></p>
            </footer>
        </div>
    </div>

    <!-- Diagonal background design -->
    <div class="tm-bg">
        <div class="tm-bg-left"></div>
        <div class="tm-bg-right"></div>
    </div>
</div>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.backstretch.min.js"></script>
<script src="js/templatemo-script.js"></script>
</body>
</html>