<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<!-- https://codepen.io/danielkvist/pen/LYNVyPL -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="SystemUI/LoginCSS/login.css" type="text/css">
</head>

<body>
<div class="container right-panel-active">
    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form action="StudentLogin" class="form" id="form1" method="post">
            <h2 class="form__title">学生登录</h2>
                <label>
                    <input type="text" name="sid" placeholder="学号" class="input"/>
                </label>
                <label>
                    <input type="password" name="spassword" placeholder="密码" class="input"/>
                </label>
                <input type="submit" value="登录" class="btn"/>
        </form>
    </div>

    <!-- Sign In -->
    <div class="container__form container--signin">
        <form action="TeacherLogin" class="form" id="form2" method="post">
            <h2 class="form__title">教师登录</h2>
            <label>
                <input type="text" name="tid" placeholder="教师号" class="input" />
            </label>
            <label>
                <input type="password" name="tpassword" placeholder="密码" class="input" />
            </label>
            <input type="submit" value="登录" class="btn">
        </form>
    </div>

    <!-- Overlay -->
    <div class="container__overlay">
        <div class="overlay">
            <div class="overlay__panel overlay--left">
                <button class="btn" id="signIn">教师登录</button>
            </div>
            <div class="overlay__panel overlay--right">
                <button class="btn" id="signUp">学生登录</button>
            </div>
        </div>
    </div>
</div>

<script>
    const signInBtn = document.getElementById("signIn");
    const signUpBtn = document.getElementById("signUp");
    const fistForm = document.getElementById("form1");
    const secondForm = document.getElementById("form2");
    const container = document.querySelector(".container");

    signInBtn.addEventListener("click", () => {
        container.classList.remove("right-panel-active");
    });

    signUpBtn.addEventListener("click", () => {
        container.classList.add("right-panel-active");
    });

</script>
<%
String errorInfo = (String)request.getAttribute("loginError");         // 获取错误属性
if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=errorInfo%>");                                            // 弹出错误信息

    // 跳转到登录界面
</script>
<%
    }
%>
</body>

</html>
