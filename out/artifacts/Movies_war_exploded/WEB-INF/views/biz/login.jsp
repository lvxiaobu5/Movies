<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/11/25
    Time: 1:13
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/Movies/css/login.css">
    <link rel="stylesheet" href="/Movies/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Movies/css/add.css">

    <script type="text/javascript">
        function changeImg() {
            var img = document.getElementById("img");
            img.src = "${path}/verificationCode.do?date=" + new Date();
        }

        function checkVerificationCode() {
            var verificationCode = document.getElementById('verificationCode').value;
            var flag = (getCookie('v_c_v') == verificationCode);
            if (!flag) {
                alert('验证码输入错误');
            }
            return flag;
        }

        function getCookie(cookie_name) {
            var allCookies = document.cookie;
            var cookie_pos = allCookies.indexOf(cookie_name);   //如果找到了索引，就代表cookie存在
            if (cookie_pos != -1) {
                cookie_pos += cookie_name.length + 1;
                var cookie_end = allCookies.indexOf(";", cookie_pos);
                if (cookie_end == -1) {
                    cookie_end = allCookies.length;
                }
                return unescape(allCookies.substring(cookie_pos, cookie_end));
            }
            return null;
        }
    </script>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${path}/movie/list.do">
                    返回电影列表
                </a>
            </div>
        </div>
    </nav>
    <%
        String fail = (String)request.getAttribute("fail");         // 获取注册失败属性
        if(fail != null) {
    %>
    <script type="text/javascript" language="javascript">
        alert("<%= fail%>");                                            // 弹出注册失败信息
    </script>
    <%
        }
    %>
    <div class="login">
        <div class="header">
            <h1>
                <a href="${path}/login.do">登录</a>
                <a href="${path}/regPrompt.do">注册</a>
            </h1>
        </div>
        <form action="${path}/main.do" method="post">
            <div class="name">
                <input type="text" id="name" name="username" placeholder="请输入登录用户名">
                <p></p>
            </div>
            <div class="pwd">
                <input type="password" id="pwd" name="password" placeholder="6-16位密码，区分大小写，不能用空格">
                <p></p>
            </div>
            <div class="idcode">
                <input type="text" id="verificationCode" placeholder="请输入验证码">
                <a href='#' onclick="javascript:changeImg()">&nbsp;&nbsp;&nbsp;&nbsp;换一张</a>
                <span><img id="img" src="/verificationCode.do"/></span>
                <div class="clear"></div>
            </div>
            <div class="autoLogin">
                <label for="auto">
                    <input type="checkbox" checked="checked" id="auto">
                    下次自动登录
                </label>
                <a href="">忘记密码</a>
            </div>
            <div class="btn-red">
                <input onclick="return checkVerificationCode();" type="submit" value="登录" id="login-btn">
            </div>
        </form>
    </div>
</body>
</html>