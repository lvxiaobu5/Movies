<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/11/22
    Time: 21:24
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>

<!DOCTYPE html>
<html>

<head>
    <title>添加电影</title>
    <style>
        body{
            font: 17px/1.5 "PingFang SC","微软雅黑";
        }
        .div1{
            text-align: center;
        }
        .div2{
            width: 25%;
            height: 60px;
            padding: 0 10px;
            margin: 10px auto;
        }
        .div3{
            text-align: center;
            font-style: inherit;
        }
    </style>
</head>

<body>
    <form action="${path}/movie/add.do" method="post" enctype="multipart/form-data">
        <div class="div1">
            <div class="div2">
                电影名称：<input type="text" id="moviename" name="moviename" maxlength="20"><br>
                上传图片：<input type="file" id="moviepic" name="moviepic"><br>
            </div>
            <h3>电影介绍：</h3><br>
            <textarea name="introduce" cols="100" rows="30" wrap="hard" id="introduce"></textarea>
        </div>
        <div class="div3">
            <input type="submit" value="提交" id="tijiao">
        </div>
    </form>
</body>

</html>
