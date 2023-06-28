<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaocheng
  Date: 2023/6/25
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apple Product Detail</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #000;
            color: #fff;
            display: flex;
            justify-content: flex-end;
            padding: 20px;
        }
        nav ul {
            display: flex;
            list-style: none;
        }
        nav ul li a {
            color: #fff;
            padding: 10px;
            text-decoration: none;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
        main {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            margin-top: 50px;
        }
        /* 前面的样式保持不变 */
        .product-info .quantity {
            display: flex;
            align-items: center;
            margin-top: 210px;
        }
        .product-info .quantity-btn {
            width: 30px;
            height: 30px;
            border: none;
            background-color: #000;
            color: #fff;
            font-size: 20px;
            cursor: pointer;
        }
        .product-info .quantity-input {
            width: 50px;
            height: 30px;
            text-align: center;
            border: none;
            border-bottom: 1px solid #ccc;
            margin: 0 10px;
        }
        /* 后面的样式保持不变 */
        button {
            background-color: #000;
            color: #fff;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #fff;
            color: #000;
        }
        footer {
            background-color: #ccc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 50px;
            margin-top: 150px;
        }
        .product-image{
            margin-right: 50px;
        }
        button{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="index.jsp">主页</a></li>
            <c:if test="${user!=null}">
            <li><a href="userIndex.jsp">个人中心</a></li>
            <li><a href="${pageContext.request.contextPath}/ServletSelectCar?id=${user.id}">购物车</a></li>
            </c:if>>
        </ul>
    </nav>
</header>
<!-- 前面的代码保持不变 -->
<main>

    <div class="product-image">
        <img src="../backStage/img/${gs.picturename}" alt="Product Image" style="width: 400px;height: 400px;">
    </div>
    <div class="product-info">
        <form action="${pageContext.request.contextPath}/ServletAddCar?userid=${user.id}&&goodsid=${gs.id}" method="post">
        <h1>${gs.gname}</h1>
        <h2>${gs.price}</h2>
        <h2>折扣价！！${gs.price*gs.discount}</h2>
        <p>${gs.describe}</p>


        <div class="quantity">

            <button class="quantity-btn minus-btn" type="button">-</button>
            <input type="text " name="amount" class="quantity-input" value="1">
            <button class="quantity-btn plus-btn" type="button">+</button>

        </div>
        <h2 style="margin-top: 20px">数量：${gs.amount}</h2>
        <button class="add-to-cart-btn" type="submit">
           Add to Cart</button>
        </form>
    </div>
</main>
<!-- 后面的代码保持不变 -->
<footer>
    <p>© 2023 Apple Inc. All Rights Reserved</p>
    <script>
        const minusBtn = document.querySelector('.minus-btn');
        const plusBtn = document.querySelector('.plus-btn');
        const quantityInput = document.querySelector('.quantity-input');

        // 减少数量
        minusBtn.addEventListener('click', () => {
            if (quantityInput.value > 1) {
                quantityInput.value = parseInt(quantityInput.value) - 1;
            }
        });

        // 增加数量
        plusBtn.addEventListener('click', () => {
            quantityInput.value = parseInt(quantityInput.value) + 1;
        });
    </script>
</footer>
</body>
</html>