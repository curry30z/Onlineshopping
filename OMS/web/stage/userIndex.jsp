<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/21
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="css/style3.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="index.jsp">主页</a></li>
            <li><a href="#">订单</a></li>
            <li><a href="${pageContext.request.contextPath}/ServletSelectCar?id=${user.id}">购物车</a></li>
            <c:if test="${u!=null}">
                <li><a href="../backStage/Manage.jsp">返回</a></li>
            </c:if>
        </ul>
    </nav>
    <h1>个人中心</h1>
</header>
<main>
    <div class="left-col">
        <div class="profile">
            <div class="avatar"><img src="img/${user.img}${u.img}" alt="头像"></div>
            <div class="info">
                <p>姓名：<span id="name">${user.name}${u.name}</span></p>
                <p>电话：<span id="phone">${user.phone}${u.phone}</span></p>
                <p>性别：<span id="gender">${user.sex}${u.sex}</span></p>
                <p>邮箱：<span id="email">${user.email}${u.email}</span></p>
                <p>地址：<span id="address">${user.address}${u.address}</span></p>
                <c:if test="${user==null}">
                    <p>真实姓名：<span id="realname">${u.realname}</span></p>



                </c:if>
            </div>
        </div>
<c:if test="${user!=null}">

            <ul class="menu">
            <li><a href="#">修改密码</a></li>
            <li><a href="#">修改个人信息</a></li>
            <li><a href="#">注销账号</a></li>
        </ul>
</c:if>
    </div>
<c:if test="${user!=null}">
    <div class="right-col">
        <h2>个人项目</h2>
        <p>这里可以展示你的个人项目。</p>
    </div>
</c:if>
</main>
<footer style="margin-top: 250px">
    <p>版权所有 © 2023</p>
</footer>
<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
