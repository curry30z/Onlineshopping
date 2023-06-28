<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/20
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="bean.goods" %>
<jsp:include page="/ServletIndex" />



<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>京东购物</title>
    <!-- 引入CSS文件 -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>


<header>
    <!-- 网站Logo -->
    <div class="logo">
        <img style="width: 80px;height: 80px" src="img/src=http___c-ssl.duitang.com_uploads_item_201609_03_20160903172547_HJUE4.thumb.400_0.jpeg&refer=http___c-ssl.duitang.webp">
    </div>
    <!-- 导航菜单 -->
    <nav>
        <ul>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="#">新品</a></li>
            <li><a href="#">特惠</a></li>
            <li><a href="#">手机</a></li>
            <li><a href="#">电脑</a></li>
            <li><a href="#">家用电器</a></li>

            <c:if test="${user==null}">
                <li><a href="login.jsp">登录</a></li>
            </c:if>
            <c:if test="${user!=null}">
                <li><a href="#">用户：${user.name}</a></li>
                <li><a href="userIndex.jsp">个人中心</a></li>
                <li><a href="${pageContext.request.contextPath}/ServletLoginOut">退出登录</a></li>
            </c:if>
        </ul>
    </nav>
</header>
<main>
    <!-- 商品分类 -->
    <div class="category">
        <h2>商品分类</h2>
        <ul>
            <li><a href="#">手机</a></li>
            <li><a href="#">电脑</a></li>
            <li><a href="#">家用电器</a></li>
            <li><a href="#">数码</a></li>
            <li><a href="#">家具</a></li>
            <li><a href="#">家装</a></li>
            <li><a href="#">厨具</a></li>
            <li><a href="#">户外运动</a></li>
        </ul>
    </div>
    <!-- 商品推荐 -->

    <div class="recommend"  >
        <h2>商品推荐</h2>
        <div class="search-box" style="margin-left: 700px;margin-bottom: 20px" >
            <input type="text" placeholder="搜索你想要的商品">
            <button>搜索</button>
        </div>
        <ul>

            <c:forEach items="${gd}" var="goods">

                <li><a href="${pageContext.request.contextPath}/ServletDetail?goodsno=${goods.goodsno}">
                    <img src="../backStage/img/${goods.picturename}" style="width: 200px;height: 200px"><p>${goods.gname}</p></a></li>


            </c:forEach>
        </ul>
    </div>
</main>
<footer>
    <!-- 网站底部 -->
    <p>&copy; 2023 RY.</p>
</footer>
<!-- 引入JavaScript文件 -->
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha384-/1ZOwN1ITnhufCZoHSO1tGh2MjskCEmJ+OGx/3jZTCBmPOw1GSTYIMPeNjljBnUr"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
