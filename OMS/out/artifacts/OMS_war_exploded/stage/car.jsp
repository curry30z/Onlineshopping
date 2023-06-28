<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/26
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>在线商城购物车页面</title>
    <link rel="stylesheet" href="css/style4.css">
</head>
<body>
<header>
    <!-- 页面头部，包括网站logo和购物车总价等信息 -->
</header>
<main><form action="${pageContext.request.contextPath}/ServletCar?userid=${user.id}" method="post">
    <div class="cart">
        <h1>购物车</h1>
        <!-- <div class="cart-actions">
          <button class="delete-selected-btn">批量删除</button>
        </div> -->
        <table >

            <thead>
            <tr>
                <th></th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${carList}" var="car">
                <tr>
                    <td>
                        <input type="checkbox" name="check" value="${car.id}"
                           class="item-checkbox" data-id="${car.id}"></td>
                    <td>
                        <img src="../backStage/img/${car.picturename}" alt="${car.gname}">
                        <span>${car.gname}</span>
                    </td>
                    <td> <span  class="price">¥${car.price*car.discount}</span></td>
                    <td>
                        <input name="number" type="number" min="1" value="${car.amount}" data-id="${car.id}">
                    </td>

                    <td>
                        <span class="subtotal" ></span>
                    </td>
                    <td>
                        <button class="btn-delete" data-id="${car.id}" >
                            <a href="${pageContext.request.contextPath}/ServletCar?id=${car.id}&&userid=${car.userid}">删除</a> </button>
                    </td>
                    <input type="hidden" name="goodsid" value="${car.goodsid}">
                </tr>

            </c:forEach>

            <!-- 商品列表，每个商品一行，包括商品名称、价格、数量、小计和操作按钮 -->
            </tbody>

        </table>
        <div class="cart-checkout">
            <div class="total">
                <span>总计：</span>
                <span id="cartTotal" class="cart-total" >0.00</span>
            </div>
            <button class="delete-selected-btn"type="submit" name="sb" value="delete">批量删除</button>
            <button class="checkout-btn" type="submit" name="sb" value="next">结算</button>
        </div>
    </div>
</form>
</main>
<script>


    // 获取相关元素
    const items = document.querySelectorAll('tbody tr');

    // 定义更新小计的函数
    function updateSubtotal(item) {
        const priceElement = item.querySelector('.price');
        const quantityElement = item.querySelector('input[type="number"]');
        const subtotalElement = item.querySelector('.subtotal');

        // 计算小计
        const price = parseFloat(priceElement.innerText.substring(1)); // 去掉¥符号并转为浮点数
        const quantity = parseInt(quantityElement.value);
        const subtotal = price * quantity;

        // 更新小计值
        subtotalElement.innerText = '¥' + subtotal.toFixed(2); // 保留两位小数，并添加¥符号
    }

    // 初始加载时计算小计
    items.forEach(item => {
        updateSubtotal(item);
    });



    //my
    function a() {
        const cartTotalElement = document.getElementById('cartTotal');

        function getSubtotal(item) {
            const priceElement = item.querySelector('.price');
            const quantityElement = item.querySelector('input[type="number"]');
            const subtotalElement = item.querySelector('.subtotal');

            // 计算小计
            const price = parseFloat(priceElement.innerText.substring(1)); // 去掉¥符号并转为浮点数
            const quantity = parseInt(quantityElement.value);
            const subtotal = price * quantity;
            return subtotal;

        }

        let cartTotal = 0;
        items.forEach(item => {
            cartTotal += getSubtotal(item);
        });
        cartTotalElement.innerText = cartTotal.toFixed(2) + '元'; // 保留两位小数，并添加元单位


    }
    a();

    // 监听数量输入框的变化事件，更新小计
    items.forEach(item => {
        const quantityElement = item.querySelector('input[type="number"]');
        quantityElement.addEventListener('change', function () {
            updateSubtotal(item);
            a();
        });
    });





</script>


</body>
</html>
