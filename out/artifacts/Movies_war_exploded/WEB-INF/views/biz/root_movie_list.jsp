<%--
    Depiction: TODO
    User: KaYo
    Date: 2019/12/1
    Time: 2:40
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>电影列表</title>
    <link rel="stylesheet" href="/Movies/css/list.css">
    <link rel="stylesheet" href="/Movies/css/abc.css">
    <link rel="stylesheet" href="/Movies/css/index.css">
    <link rel="stylesheet" href="/Movies/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function submitMessageForm(flag) {
            if ('first' == flag) {
                document.getElementById('page').value = 1;
            } else if ('pre' == flag) {
                var current = Number(document.getElementById('page').value);
                if (current > 1) {
                    document.getElementById('page').value = current - 1;
                }
            } else if ('next' == flag) {
                var current = Number(document.getElementById('page').value);
                var last = Number(document.getElementById('last').value);
                if (current < last) {
                    document.getElementById('page').value = current + 1;
                }
            } else if ('last' == flag) {
                var last = Number(document.getElementById('last').value);
                document.getElementById('page').value = last < 1 ? 1 : last;
            }
            document.getElementById('messageForm').submit();
        }
    </script>

</head>
<body>
<!-- 头部 -->
<header class="header">
    <div class="logo"></div>
    <div class="nav">
        <a href="${path}/product/list.do" class="nav__item nav__course">电影</a>
        <a href="" class="nav__item nav__item_icon_new">职业路径<i class="icon_new"></i></a>
        <a href="" class="nav__item">实战</a>
        <a href="" class="nav__item">猿问</a>
        <a href="${path}/addparty.do" class="nav__item">活动</a>
    </div>
    <div class="profile">
        <a href="${path}/cart/list.do" class="profile__item profile__car"></a>
        <a href="${path}/browse/list.do" class="profile__item profile__message"></a>
        <a href="" class="profile__item profile__ava"></a>
    </div>
    <form id="searchForm" method="post" action="${path}/movie/search.do">
        <div class="search">
            <input type="hidden" name="page" value="1">
            <input type="text" name="title" class="search_input" value="${title}">
            <input type="submit" class="search_submit" value="">
        </div>
    </form>
    <%--<div class="search"><input type="text" class="search_input"><a href="" class="search_submit"></a></div>--%>
</header>
<%--<hr style="display: block">--%>
<!-- 主体 -->
<div id="main">
    <div class="header2">
        <div class="login">
            <nav style="float: right;font-family: 微软雅黑;font-size: 13px;border:1px solid #428BCA;margin:auto 16px">
                <a href="${path}/login.do">退出登录</a>
            </nav>
            <nav style="float: right;font-family: 微软雅黑;font-size: 13px;border:1px solid #428BCA">
                <a href="${path}/admin.do">返回</a>
            </nav>
        </div>
    </div>
    <section class="main">
        <div class="container">
            <%--<c:forEach items="${movies}" var="movie">--%>
            <div class="row">
                <c:forEach items="${movies}" var="movie">
                    <div class="col-md-2 inner" style="float: left">
                        <a href="${path}/movie/detail.do?moviename=${movie.moviename}&filename=${movie.filename}">
                            <div class="pic">
                                <img src="/Movies/img/${movie.filename}">
                            </div>
                            <div class="clear" style="text-align: center">${movie.moviename}</div>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <%--</c:forEach>--%>
        </div>
    </section>
    <div id="pagefy">
        <ul>
            <form id="messageForm" action="${path}/movie/list.do" method="post">
                <input type="hidden" id="page" name="page" value="${page}">
                <input type="hidden" id="last" name="last" value="${last}">
                <li><a href="javascript:void(0)" onclick="submitMessageForm('first')">首页</a></li>
                <li><a href="javascript:void(0)" onclick="submitMessageForm('pre')">上一页</a></li>
                <li><a href="javascript:void(0)">当前第${page}页</a></li>
                <li><a href="javascript:void(0)" onclick="submitMessageForm('next')">下一页</a></li>
                <li><a href="javascript:void(0)" onclick="submitMessageForm('last')">尾页</a></li>
            </form>
        </ul>
    </div>
</div>

<!-- 尾部 -->
<footer class="footer" style="background-color: black">
    <div class="waper">
        <div class="footerWaper">
            <%--<div class="followus">--%>
            <%--<a href="" class="followus_weixin"><div class="flw-weixin-box"></div></a>--%>
            <%--<a href="" class="followus_weibo"></a>--%>
            <%--<a href="" class="followus_qzone"></a>--%>
            <%--</div>--%>
            <div class="footer_intro" style="width: 100%">
                <div class="footer_link">
                    <ul>
                        <li><a href="">网站首页</a></li>
                        <li><a href="">企业合作</a></li>
                        <li><a href="">人才招聘</a></li>
                        <li><a href="">联系我们</a></li>
                        <li><a href="">讲师招募</a></li>
                        <li><a href="">常见问题</a></li>
                        <li><a href="">意见反馈</a></li>
                        <li><a href="">慕课大学</a></li>
                        <li><a href="">友情链接</a></li>
                    </ul>
                </div>
                <p>Copyright © 2017 imooc.com All Rights Reserved | 京ICP备 13046642号-2</p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>