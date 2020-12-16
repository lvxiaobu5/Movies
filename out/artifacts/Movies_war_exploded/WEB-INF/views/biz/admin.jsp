<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/11/28
    Time: 20:26
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>

<!DOCTYPE html>
<html>

<head>
    <title>管理员页面</title>
    <link rel="stylesheet" href="/Movies/css/bootstrap.min.css">
    <style>
        table{
            width: 300px;
            height: 260px;
            margin: 10px auto;
        }
        .div1{
            border:1px solid dodgerblue;
            line-height: 60px;
            text-align: center;
            font-family: 微软雅黑;
            font-size: 28px;
        }
    </style>
</head>

<body>
    <div class="jumbotron" style="text-align: center">
        <h1>Hello, 主人!</h1>
        <p>站主，你拥有增删改查的特权哦！ ^_^</p>
    </div>
    <center>
        <table style="width: 300px">
            <tr style="align:center">
                <td><div style="margin-top: 18px" class="div1">
                    <a href="${path}/movie/addmovie.do">添加电影</a>
                </div></td>
            </tr>
            <tr style="align:center">
                <td><div style="margin-top: 18px" class="div1">
                    <a href="${path}/changedelete.do">修改或删除电影</a>
                </div></td>
            </tr>
            <tr style="align:center">
                <td><div style="margin-top: 18px" class="div1">
                    <a href="${path}/check.do">查看活动报名情况</a>
                </div></td>
            </tr>
            <tr style="align:center">
                <td><div style="margin-top: 18px" class="div1">
                    <a href="${path}/login.do">退出登录</a>
                </div></td>
            </tr>
        </table>
    </center>
</body>
</html>
