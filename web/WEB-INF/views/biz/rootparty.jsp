<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/12/3
    Time: 1:26
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加出游活动</title>
    <link rel="stylesheet" href="/Movies/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Movies/css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${path}/adminmovielist.do">
                返回
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron" style="text-align: center">
        <h1>Hello, 主人!</h1>
        <p>请斟酌后添加 ^_^</p>
    </div>
    <div class="page-header">
        <h3><small>请添加出游活动</small></h3>
    </div>
    <form class="form-horizontal" action="${path}/add.do" method="post">
        <input id="id" name="id" type="hidden" value="">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">地点 ：</label>
            <div class="col-sm-6">
                <input name="address" class="form-control" id="name" value="">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">出游费 ：</label>
            <div class="col-sm-6">
                <input name="perprice" class="form-control" id="password" value="">
            </div>
        </div>
        <div class="form-group">
            <label for="realName" class="col-sm-2 control-label">介绍 ：</label>
            <div class="col-sm-8">
                <input name="introduce" class="form-control" id="realName" value="">
            </div>
        </div>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">出游日期 ：</label>
            <div class="col-sm-8">
                <input name="partydate" class="form-control" id="birthday" value="">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">确认添加</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>
