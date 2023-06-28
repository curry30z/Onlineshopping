<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/25
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #f1f1f1;
            font-family: "Montserrat", sans-serif;
            color: #555;
        }

        h1 {
            font-size: 3.5rem;
            font-weight: 700;
            margin-top: 50px;
            margin-bottom: 50px;
            text-align: center;
        }

        form {
            display: flex;
            align-items: center;
            margin-bottom: 50px;
        }

        input[type="text"],
        button[type="submit"] {
            font-size: 1.5rem;
            border-radius: 25px;
            padding: 15px 25px;
            border: 2px solid #555;
            background-color: white;
            margin-right: 25px;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"]:focus,
        button[type="submit"]:focus {
            outline: none;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        }

        button[type="submit"] {
            background-color: #555;
            color: white;
            transition: all 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #333;
            cursor: pointer;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        }

        th {
            background-color: #333;
            color: white;
            padding: 20px;
            text-align: left;
            font-size: 1.5rem;
            font-weight: 700;
        }

        td {
            background-color: white;
            padding: 20px;
            font-size: 1.2rem;
            border-bottom: 1px solid #ddd;
        }

        img {
            border-radius: 50%;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        }

        a {
            color: #555;
            text-decoration: none;
            margin-left: 10px;
            margin-right: 10px;
            transition: all 0.3s ease;
        }

        a:hover {
            color: #333;
        }

        input[type="checkbox"] {
            width: 25px;
            display: none;
        }

        tr:hover {
            background-color: #f9f9f9;
            cursor: pointer;
        }

        .fa-trash-alt,
        .fa-check-circle,
        .fa-eye,
        .fa-sync {
            font-size: 1.5rem;
            margin-right: 5px;
        }

        .delete-link {
            color: #ff4136;
        }

        .active-link {
            color: #0074d9;
        }

        .update-link {
            color: #2ecc40;
        }

        .show-link {
            color: #ffdc00;
        }

        .reset-link {
            color: #7fdbff;
        }

    </style>
</head>
<body>
<h1>商品信息</h1>

<form action="${pageContext.request.contextPath}/ServletSelectGoods" method="post">

    <input type="text" placeholder="请输入查询的商品名关键词" name="goodName">
    <input type="text" placeholder="请输入查询的类别名关键词" name="item">
    <button type="submit">查询</button>
</form>
<table class=>
    <thead>
    <tr>
        <th>编号</th>
        <th>商品名</th>
        <th>单价</th>
        <th>数量</th>
        <th>卖家</th>
        <th>类别</th>
        <th>状态</th>
        <th>折扣</th>
        <th colspan="6" align="center">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goodsList}" var="goods">
        <tr align="center" >

            <td> ${goods.goodsno}</td>
            <td>${goods.gname}</td>
            <td>${goods.price}</td>
            <td>${goods.amount}</td>
            <td>${goods.seller}</td>
            <td>${goods.name}</td>
            <td>
                <c:choose>
                    <c:when test="${goods.status==0}">下架</c:when>
                    <c:when test="${goods.status==1}">正常</c:when>
                    <c:otherwise>异常用户</c:otherwise>
                </c:choose>
            </td>
            <td>${goods.discount}</td>

            <td><a href="${pageContext.request.contextPath}/ServletDetail?goodsno=${goods.goodsno}">查看详情</a></td>
            <td><a href="${pageContext.request.contextPath}/ServletUpGoods?play=u&id=${goods.id}"
                   onclick="return confirm('确定要下架该商品？')">下架商品</a></td>
            <td><a href="${pageContext.request.contextPath}/ServletUpGoods?play=d&id=${goods.id}"
                   onclick="return confirm('确定要删除该商品？')">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/ServletSetGoods?id=${goods.id}">修改</a></td>

            <td><input type="checkbox" id="checkbox" name="cheknid" value="${user.id}" style="width: 25px;display: none"> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
