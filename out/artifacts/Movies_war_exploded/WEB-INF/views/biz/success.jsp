<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/12/6
    Time: 13:07
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>

<!DOCTYPE html>
<html>

<head>
    <title>报名成功</title>

</head>

<body>
报名成功！<br>
<a href="${path}/login.do" style="text-align: center">退出登录</a>
</body>

</html>
