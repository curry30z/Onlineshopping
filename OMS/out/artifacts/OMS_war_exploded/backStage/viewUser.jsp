<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/24
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
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

<body>
<h1>用户信息</h1>
<form action="${pageContext.request.contextPath}/ServletSelectUser" method="post">

    <input type="text" placeholder="请输入查询的关键词" name="key">
    <button type="submit">查询</button>
</form>
<table class=>
    <thead>
    <tr>
        
        <th>编号</th>
        <th>用户名</th>
        <th>性别</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>状态</th>
        <th>头像</th>
        <th colspan="6" align="center">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">

        <tr align="center" >

            <td> ${user.id}</td>
            <td>${user.name}</td>
            <td>${user.sex}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>
                <c:choose>
                    <c:when test="${user.statu==0}">不可用</c:when>
                    <c:when test="${user.statu==1}">正常</c:when>
                    <c:otherwise>注销</c:otherwise>
                </c:choose>
            </td>
            <td>
                <img src="../stage/img/${user.img}" alt="头像" style="width: 80px;height: 80px">
            </td>
            <td><a href="${pageContext.request.contextPath}/ServletLookUser?id=${user.id}">查看</a></td>

            <td><a href="${pageContext.request.contextPath}/ServletDeleteUser?play=r&&id=${user.id}"
                   onclick="return confirm('确定要重置密码吗？')">重置密码</a></td>


            <td><a href="${pageContext.request.contextPath}/ServletDeleteUser?play=d&&id=${user.id}"
                   onclick="return confirm('确定要删除吗？')">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/ServletDeleteUser?play=s&&id=${user.id}"
                   onclick="return confirm('确定要设置状态不可用？')">状态设置</a></td>

            <td><input type="checkbox" id="checkbox" name="cheknid" value="${user.id}" style="width: 25px;display: none"> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<button type="button" id="bu">选择</button>
<script>
    let bu = document.getElementById("bu");
    bu.addEventListener("click", function () {

        const checkboxes = document.querySelectorAll("input[type=checkbox][style='width: 25px;display: none']");
        checkboxes.forEach((checkbox) => {
            checkbox.style.display = "block";
        })


    })




</script>


</body>
</html>
