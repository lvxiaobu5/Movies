<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/11/19
    Time: 16:02
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<html>
<head>
    <meta charset="utf-8">
    <title>电影介绍</title>
    <link rel="stylesheet" href="/Movies/css/list.css">
    <link rel="stylesheet" href="/Movies/css/abc.css">
    <link rel="stylesheet" href="/Movies/css/index.css">
    <style>
        html,body{
            margin: 0px;
        }
        header{
            background-color: #00FFFF;
            height: 100px;
        }
        #container {
            background-color: lightgreen;
            height: 100%;
        }
        footer{
            background-color: purple;
            height: 100px;
        }
        nav{
            background-color: lightblue;
            height: 100%;
            width: 180px;
            float: left;
        }
        article{
            background-color: lightpink;
            height: 100%;
            margin-left: 150px;				/*左外边距等于第一列的宽，实现无重叠*/
        }
    </style>
</head>
<body>
    <!-- 头部 -->
    <header class="header">
        <div class="logo"></div>
        <div class="nav">
            <a href="${path}/movie/list.do" class="nav__item nav__course">电影</a>
            <a href="" class="nav__item nav__item_icon_new">职业路径<i class="icon_new"></i></a>
            <a href="" class="nav__item">实战</a>
            <a href="" class="nav__item">猿问</a>
            <a href="" class="nav__item">手记</a>
        </div>
        <div class="profile">
            <a href="${path}/cart/list.do" class="profile__item profile__car"></a>
            <a href="${path}/browse/list.do" class="profile__item profile__message"></a>
            <a href="" class="profile__item profile__ava"></a>
        </div>
        <form id="searchForm" method="post" action="${path}/product/list.do">
            <div class="search">
                <input type="hidden" name="page" value="1">
                <input type="text" name="title" class="search_input" value="${title}">
                <input type="submit" class="search_submit" value="">
            </div>
        </form>
        <%--<div class="search"><input type="text" class="search_input"><a href="" class="search_submit"></a></div>--%>
    </header>
    <div id="container">
        <nav>
            <%--<c:forEach items="${movies}" var="movie">--%>
                <div class="col-md-2 inner" style="float: left">
                    <a>
                        <div class="pic">
                            <img src="/Movies/img/${movie.filename}">
                        </div>
                        <div class="clear">${movie.moviename}</div>
                    </a>
                </div>
            <%--</c:forEach>--%>
        </nav>
        <article>${movie.introduce}</article>
    </div>
</body>
</html>
