<%--
  Created by IntelliJ IDEA.
  User: 15529
  Date: 2022/6/23
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--Begin Header -->
<div id="header">
  <h1><a href="#" title="Green Zone">教师管理界面</a></h1>
</div>
<!--End Header -->
<nav>
  <label for="show-menu" class="responsive">&#9776; Menu</label>
  <input type="checkbox" id="show-menu" role="button">
  <ul id="menu">
    <li><a>Home</a></li>
    <li><a href="#" title="课程">插入</a>
      <ul>
        <li><a href="inset_student.jsp">插入新学生</a></li>
        <li><a href="insert_teacher.jsp">插入新老师</a></li>
        <li><a href="insert_course.jsp">插入新课程</a></li>
      </ul>
    </li>
    <li><a href="#" title="信息修改">查询</a>
      <ul>

        <li><a href="studentAll">查询所有学生</a></li>
        <li><a href="teacherAll">查询所有老师</a></li>
        <li><a href="courseAll">查询所有课程</a></li>
      </ul>
    </li>
    <li><a href="changePassword.jsp" title="修改密码">修改密码</a></li>
  </ul>
</nav>
<!-- Begin Content -->
</body>
</html>
