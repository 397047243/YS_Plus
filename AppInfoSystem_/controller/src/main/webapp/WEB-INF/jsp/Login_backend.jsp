<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\3\3 0003
  Time: 13:44
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
    <title>后台管理系统登录</title>
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
                <form action="${pageContext.request.contextPath}/bac/loginSub" method="post">
                    <h1>APP后台管理系统</h1>
                    <div>
                        <input type="text" class="form-control" name="userCode" placeholder="Username" required="" value="admin" />
                    </div>
                    <div>
                        <input type="password" class="form-control" name="userPassword" placeholder="Password" required="" value="123456" />
                    </div>
                    <div style="margin-bottom: 20px;color: #f00;font-size: 12px;">${error}</div>
                    <div>
                        <button type="submit" class="btn btn-success" >登录</button>
                        <button type="reset" class="btn btn-default" >重填</button>
                    </div>

                    <div class="clearfix"></div>
                </form>
            </section>
        </div>
        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form>
                    <div class="clearfix"></div>
                    <div class="separator">
                        <div class="clearfix"></div>
                        <br />
                        <div>
                            <p>©2016 All Rights Reserved. </p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
