<%--
  Created by IntelliJ IDEA.
  User: Xiaocheng
  Date: 2023/6/25
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>添加商品</title>
  <style>
    * {
      box-sizing: border-box;
    }

    html, body {
      height: 100%;
    }

    body {
      margin: 0;
      font-family: "Helvetica Neue", sans-serif;
      font-size: 16px;
      line-height: 1.4em;
    }

    header {
      background-color: #000;
      color: #fff;
      text-align: center;
      padding: 0.75rem 1rem;
      position: relative;
    }

    header img {
      display: inline-block;
      height: 3rem;
      vertical-align: middle;
      margin-right: 1rem;
    }

    header nav {
      display: inline-block;
      vertical-align: middle;
    }

    header nav ul {
      list-style: none;
      margin: 0;
      padding: 0;
      text-align: right;
    }

    header nav ul li {
      display: inline-block;
      margin-left: 1rem;
    }

    header nav ul li:first-child {
      margin-left: 0;
    }

    header nav ul li a {
      color: #fff;
      text-decoration: none;
      font-size: 0.9em;
      transition: all 0.3s;
    }

    header nav ul li a:hover {
      color: #c1c1c1;
    }

    .container {
      margin: 0 auto;
      max-width: 960px;
      padding: 1rem;
    }

    h1 {
      margin-bottom: 1rem;
    }

    form {
      background-color: #f9f9f9;
      padding: 1rem;
      border-radius: 5px;
    }

    .form-row {
      display: flex;
      justify-content: space-between;
      align-items: center;
      flex-wrap: wrap;
      margin-bottom: 1rem;
    }

    .form-col {
      flex: 1 1 45%;
    }

    .form-col label {
      display: block;
      margin-bottom: 0.5rem;
    }

    .form-col input[type=“text”],
    .form-col input[type=“file”],
    .form-col select,
    .form-col textarea {
      display: block;
      width: 100%;
      padding: 0.5rem;
      border-radius: 3px;
      border: 1px solid #ccc;
      margin-bottom: 0.5rem;
      border: none;
    }

    button[type="submit"] {
      display: inline-block;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      background-color: #007aff;
      color: #fff;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    button[type="submit"]:hover {
      background-color: #0056b3;
    }

    footer {
      background-color: #f9f9f9;
      text-align: center;
      padding: 0.75rem 1rem;
      position: absolute;
      bottom: 0;
      width: 100%;
    }

    @media only screen and (max-width: 768px) {
      header img {
        height: 2rem;
      }

      header nav {
        display: block;
        text-align: center;
      }

      header nav ul li {
        display: block;
      }

      .form-col {
        flex: 1 1 100%;
      }
    }
  </style>
</head>
<body>
<header>
  <div class="container">

    <nav>

    </nav>
  </div>
</header>
<main>
  <div class="container">
    <h1>添加商品</h1>
    <form id="product-form" action="${pageContext.request.contextPath}/ServletAddGoods" method="post" enctype="multipart/form-data">
      <div class="form-row">
        <div class="form-col">
          <label for="product-number">商品编号</label>
          <input type="text" name="goodsno" id="product-number" required>
        </div>
        <div class="form-col">
          <label for="product-name">商品名称</label>
          <input type="text" name="gname" id="product-name" required>
        </div>
      </div>
      <div class="form-row">
        <div class="form-col">
          <label for="product-price">商品价格</label>
          <input type="text" name="price" id="product-price" required>
        </div>
        <div class="form-col">
          <label for="product-quantity">数量</label>
          <input type="text" name="amount" id="product-quantity" required>
        </div>
      </div>
      <div class="form-row">
        <div class="form-col">
          <label for="product-image">图片</label>
          <input type="file" name="file" id="product-image" accept="image/*" required>
        </div>
        <div class="form-col">
          <label for="product-seller">卖家</label>
          <input type="text" name="seller" id="product-seller" required>
        </div>
      </div>
      <div class="form-row">
        <div class="form-col">
          <label for="product-seller">类别</label>
          <input type="text" name="name" id="product-seller" required>
        </div>
        <div class="form-col">
          <label for="product-discount">折扣 (0~1)</label>
          <input type="text" name="discount" id="product-discount">
        </div>
      </div>
      <div class="form-row">
        <div class="form-col">
          <label for="product-description">商品描述</label>
          <textarea name="describe" id="product-description"></textarea>
        </div>
      </div>
      <button type="submit">添加</button>
    </form>
  </div>
</main>
<!-- <footer>
  <p>&copy; 2023 Apple Inc. All rights reserved.</p>
</footer> -->
</body>
</html>