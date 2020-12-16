<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/12/6
    Time: 11:20
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
            <a class="navbar-brand" href="${path}/usermovielist.do">
                返回电影列表
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron" style="text-align: center">
        <h1>Hello, ${user.name}!</h1>
        <p>信息都在这里了 ^_^</p>
    </div>
    <div class="page-header">
        <h3><small>出游信息</small></h3>
    </div>
    <form class="form-horizontal" action="${path}/party.do" method="post">
        <%--<input type="hidden" id="id" name="id" value="${user.id}">--%>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">地址 ：</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="name" name="address" value="${party.address}" readonly="readonly">
            </div>
        </div>
        <div class="form-group">
            <label for="realName" class="col-sm-2 control-label">需缴费用 ：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="realName" value="${party.perprice}" readonly="readonly">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">景点介绍 ：</label>
            <div class="col-sm-8">
                <input name=""  class="form-control" rows="3" id="phone" value="${party.introduce}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">出游日期 ：</label>
            <div class="col-sm-8">
                <input name=""  class="form-control" rows="3" id="birthday" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${party.partydate}"/>" readonly>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">我要报名</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>

