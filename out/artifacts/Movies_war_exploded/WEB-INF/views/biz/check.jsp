<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/12/6
    Time: 13:27
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的信息</title>
    <link rel="stylesheet" href="/Movies/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Movies/css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${path}/admin.do">
                返回
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron" style="text-align: center">
        <h1>Hello,主人!</h1>
        <p>信息都在这里了 ^_^</p>
    </div>
    <div class="page-header">
        <h3><small>查看报名信息</small></h3>
    </div>
    <table style="width: 90%;border: 1px solid red">
        <tr style="height:25px;border: blue solid 1px">
            <td style="width: 33.3%;text-align: center;border-right: blue solid 1px">用户名</td>
            <td style="width: 33.3%;text-align: center;border-right: blue solid 1px">应缴费用</td>
            <td style="width: 33.3%;text-align: center">电话</td>
        </tr>
        <c:forEach items="${partys}" var="party">
            <tr style="height:25px;border: blue solid 1px">
                <td style="width: 33.3%;text-align: center;border-right: blue solid 1px">${party.username}</td>
                <td style="width: 33.3%;text-align: center;border-right: blue solid 1px">${party.perprice}</td>
                <td style="width: 33.3%;text-align: center">${party.phone}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>

