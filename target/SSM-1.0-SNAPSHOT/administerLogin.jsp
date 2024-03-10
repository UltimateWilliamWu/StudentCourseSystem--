<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022-06-22
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员登录</title>
    <link href="css/administerlogin.css" rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <style>
        button,hr,input{overflow:visible}audio,canvas,progress,video{display:inline-block}progress,sub,sup{vertical-align:baseline}html{font-family:sans-serif;line-height:1.15;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}body{margin:0} menu,article,aside,details,footer,header,nav,section{display:block}h1{font-size:2em;margin:.67em 0}figcaption,figure,main{display:block}figure{margin:1em 40px}hr{box-sizing:content-box;height:0}code,kbd,pre,samp{font-family:monospace,monospace;font-size:1em}a{background-color:transparent;-webkit-text-decoration-skip:objects}a:active,a:hover{outline-width:0}abbr[title]{border-bottom:none;text-decoration:underline;text-decoration:underline dotted}b,strong{font-weight:bolder}dfn{font-style:italic}mark{background-color:#ff0;color:#000}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative}sub{bottom:-.25em}sup{top:-.5em}audio:not([controls]){display:none;height:0}img{border-style:none}svg:not(:root){overflow:hidden}button,input,optgroup,select,textarea{font-family:sans-serif;font-size:100%;line-height:1.15;margin:0}button,input{}button,select{text-transform:none}[type=submit], [type=reset],button,html [type=button]{-webkit-appearance:button}[type=button]::-moz-focus-inner,[type=reset]::-moz-focus-inner,[type=submit]::-moz-focus-inner,button::-moz-focus-inner{border-style:none;padding:0}[type=button]:-moz-focusring,[type=reset]:-moz-focusring,[type=submit]:-moz-focusring,button:-moz-focusring{outline:ButtonText dotted 1px}fieldset{border:1px solid silver;margin:0 2px;padding:.35em .625em .75em}legend{box-sizing:border-box;color:inherit;display:table;max-width:100%;padding:0;white-space:normal}progress{}textarea{overflow:auto}[type=checkbox],[type=radio]{box-sizing:border-box;padding:0}[type=number]::-webkit-inner-spin-button,[type=number]::-webkit-outer-spin-button{height:auto}[type=search]{-webkit-appearance:textfield;outline-offset:-2px}[type=search]::-webkit-search-cancel-button,[type=search]::-webkit-search-decoration{-webkit-appearance:none}::-webkit-file-upload-button{-webkit-appearance:button;font:inherit}summary{display:list-item}[hidden],template{display:none}/*# sourceMappingURL=normalize.min.css.map */
        body {
            font-family: "Open Sans", sans-serif;
            height: 100vh;
            background: url(SystemUI/images/background_oeuhe7.jpg) 50% fixed;
            background-size: cover;
        }

        @keyframes spinner {
            0% {
                transform: rotateZ(0deg);
            }
            100% {
                transform: rotateZ(359deg);
            }
        }
        * {
            box-sizing: border-box;
        }

        .wrapper {
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: center;
            width: 100%;
            min-height: 100%;
            padding: 20px;
            background: rgba(4, 40, 68, 0.85);
        }

        .login {
            border-radius: 2px 2px 5px 5px;
            padding: 10px 20px 20px 20px;
            width: 90%;
            max-width: 320px;
            background: #ffffff;
            position: relative;
            padding-bottom: 80px;
            box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.3);
        }
        .login.loading button {
            max-height: 100%;
            padding-top: 50px;
        }
        .login.loading button .spinner {
            opacity: 1;
            top: 40%;
        }
        .login.ok button {
            background-color: #8bc34a;
        }
        .login.ok button .spinner {
            border-radius: 0;
            border-top-color: transparent;
            border-right-color: transparent;
            height: 20px;
            animation: none;
            transform: rotateZ(-45deg);
        }
        .login input {
            display: block;
            padding: 15px 10px;
            margin-bottom: 10px;
            width: 100%;
            border: 1px solid #ddd;
            transition: border-width 0.2s ease;
            border-radius: 2px;
            color: #ccc;
        }
        .login input + i.fa {
            color: #fff;
            font-size: 1em;
            position: absolute;
            margin-top: -47px;
            opacity: 0;
            left: 0;
            transition: all 0.1s ease-in;
        }
        .login input:focus {
            outline: none;
            color: #444;
            border-color: #2196F3;
            border-left-width: 35px;
        }
        .login input:focus + i.fa {
            opacity: 1;
            left: 30px;
            transition: all 0.25s ease-out;
        }
        .login a {
            font-size: 0.8em;
            color: #2196F3;
            text-decoration: none;
        }
        .login .title {
            color: #444;
            font-size: 1.2em;
            font-weight: bold;
            margin: 10px 0 30px 0;
            border-bottom: 1px solid #eee;
            padding-bottom: 20px;
        }
        .login button {
            width: 100%;
            height: 100%;
            padding: 10px 10px;
            background: #2196F3;
            color: #fff;
            display: block;
            border: none;
            margin-top: 20px;
            position: absolute;
            left: 0;
            bottom: 0;
            max-height: 60px;
            border: 0px solid rgba(0, 0, 0, 0.1);
            border-radius: 0 0 2px 2px;
            transform: rotateZ(0deg);
            transition: all 0.1s ease-out;
            border-bottom-width: 7px;
        }
        .login button .spinner {
            display: block;
            width: 40px;
            height: 40px;
            position: absolute;
            border: 4px solid #ffffff;
            border-top-color: rgba(255, 255, 255, 0.3);
            border-radius: 100%;
            left: 50%;
            top: 0;
            opacity: 0;
            margin-left: -20px;
            margin-top: -20px;
            animation: spinner 0.6s infinite linear;
            transition: top 0.3s 0.3s ease, opacity 0.3s 0.3s ease, border-radius 0.3s ease;
            box-shadow: 0px 1px 0px rgba(0, 0, 0, 0.2);
        }
        .login:not(.loading) button:hover {
            box-shadow: 0px 1px 3px #2196F3;
        }
        .login:not(.loading) button:focus {
            border-bottom-width: 4px;
        }

        footer {
            display: block;
            padding-top: 50px;
            text-align: center;
            color: #ddd;
            font-weight: normal;
            text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.2);
            font-size: 0.8em;
        }
        footer a, footer a:link {
            color: #fff;
            text-decoration: none;
        }

    </style>
</head>
<body>
<div class="wrapper">
    <form class="login" action="AdministerLogin" id="form1" method="post">
        <p class="title">管理员登录</p>
        <input type="text" name="name" placeholder="用户名" autofocus/>
        <i class="fa fa-user"></i>
        <input type="password" name="password" placeholder="密码" />
        <i class="fa fa-key"></i>
        <a href="#">忘记密码?</a>
        <button onclick="document.getElementById('form1').submit()">
            <i class="spinner"></i>
            <span class="state">登录</span>
        </button>
    </form>

    <div style="text-align:center;clear:both;margin-top:80px">
    </div>
    </p>
</div>
<script src='js/jquery.min.js'></script>
<script>
    var working = false;
    $('.login').on('submit', function(e) {
    e.preventDefault();
    if (working) return;
    working = true;
    var $this = $(this),
        $state = $this.find('button > .state');
    $this.addClass('loading');
    $state.html('认证中...');
    setTimeout(function() {
        $this.addClass('ok');
        $state.html('Welcome back!');
        setTimeout(function() {
            $state.html('Log in');
            $this.removeClass('ok loading');
            working = false;
        }, 4000);
    }, 3000);
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


