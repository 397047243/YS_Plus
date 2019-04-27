<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\3\3 0003
  Time: 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>APP信息管理平台</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/statics/images/xrz.ico"/>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/statics/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <%--<link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">--%>

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/statics/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form>
                    <h1>APP信息管理平台</h1>
                    <div>
                        <a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/bac/login">后台管理系统入口</a>
                    </div>
                    <div>
                        <a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/dev/login">开发者平台入口</a>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
