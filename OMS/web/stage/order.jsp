<%--
  Created by IntelliJ IDEA.
  User: Xiaocheng
  Date: 2023/6/26
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f8f8;
        }
        .container {
            background-color: #fff;
            width: 1000px;
            margin: 20px auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h1 {
            font-size: 22px;
            margin: 0;
            padding: 0;
            line-height: 40px;
            border-bottom: 1px solid #ccc;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ccc;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
        .total {
            text-align: right;
            margin-top: 20px;
        }
        .total p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>订单编号：12345678，购买时间：2022-09-01 10:30:00</h1>
    <table>
        <thead>
        <tr>
            <th>商品</th>
            <th>价格</th>
            <th>数量</th>
            <th>总价</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>商品1</td>
            <td>¥100.00</td>
            <td>1</td>
            <td>¥100.00</td>
        </tr>
        <tr>
            <td>商品2</td>
            <td>¥50.00</td>
            <td>2</td>
            <td>¥100.00</td>
        </tr>
        <tr>
            <td colspan="3">总计</td>
            <td>¥200.00</td>
        </tr>
        </tbody>
    </table>
    <div class="total">
        <p>商品金额：<span>¥200.00</span></p>
        <p>优惠金额：<span>¥0.00</span></p>
        <p>运费：<span>¥10.00</span></p>

        <p>订单金额：<span>¥210.00</span></p>
        <p>订单时间：2022-09-01 10:30:00</p>
    </div>
</div>
</body>
</html> 