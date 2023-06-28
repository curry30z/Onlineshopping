<%--
  Created by IntelliJ IDEA.
  User: Xiaocheng
  Date: 2023/6/26
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>结算页面</title>
  <style>
    * {
      box-sizing: border-box;
    }

    body {
      margin: 0;
      padding: 0;
      font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
      font-size: 16px;
      line-height: 1.6;
      color: #333;
    }

    .checkout-form {
      max-width: 600px;
      margin: 0 auto;
      padding: 40px;
      background-color: #f2f2f2;
      border-radius: 12px;
      box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
    }

    .form-group {
      margin-bottom: 24px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      color: #333;
      font-size: 16px;
      font-weight: 600;
    }

    input[type="text"],
    input[type="tel"],
    textarea {
      width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 6px;
      background-color: #fff;
      color: #333;
      font-size: 16px;
      font-weight: 400;
      outline: none;
    }

    input[type="text"]:focus,
    input[type="tel"]:focus,
    textarea:focus {
      border-color: #007aff;
      box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
    }

    button.submit-btn {
      display: block;
      width: 100%;
      margin-top: 24px;
      padding: 12px;
      background-color: #007aff;
      color: #fff;
      font-size: 16px;
      font-weight: 600;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      outline: none;
    }

    .payment-overlay {
      display: none;
      width: 100%;
      height: 100%;
      position: fixed;
      top: 0;
      left: 0;
      background-color: rgba(0, 0, 0, 0.8);
      justify-content: center;
      align-items: center;
      z-index: 100;
    }

    .payment-content {
      background-color: #fff;
      border-radius: 6px;
      padding: 40px;
      box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    .payment-title {
      font-size: 24px;
      font-weight: 600;
      margin-top: 0;
      margin-bottom: 16px;
    }

    .qr-code-container {
      display: inline-block;
      margin-right: 24px;
    }

    .qr-code {
      width: 150px;
      height: 150px;
      margin-bottom: 12px;
    }

    .qr-description {
      font-size: 14px;
      color: #999;
      margin: 0;
    }

    .payment-buttons {
      margin-top: 24px;
      display: flex;
      justify-content: center;
      align-items: center;

    }

    .payment-buttons button {
      margin: 0 8px;
      padding: 12px;
      background-color: #007aff;
      color: #fff;
      font-size: 16px;
      font-weight: 600;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      outline: none;
    }

    .payment-buttons button:hover {
      background-color: rgba(0, 122, 255, 0.8);
    }
  </style>
</head>
<body>
<div class="checkout-form">
  <div class="form-group">
    <label for="name">收货人</label>
    <input type="text" id="name" name="name" required>
  </div>
  <div class="form-group">
    <label for="phone">电话</label>
    <input type="tel" id="phone" name="phone" pattern="[0-9]{11}" required>
  </div>
  <div class="form-group">
    <label for="address">地址</label>
    <textarea id="address" name="address" required></textarea>
  </div>
  <div class="form-group">
    <label for="note">备注</label>
    <textarea id="note" name="note"></textarea>
  </div>
  <div class="form-group">
    <label for="total">商品总额</label>
    <input type="text" id="total" name="total" readonly>
  </div>
  <button class="submit-btn" onclick="showPaymentOverlay()">提交</button>
</div>

<div class="payment-overlay">
  <div class="payment-content">
    <h2 class="payment-title">付款信息</h2>
    <div class="qr-code-container">
      <img class="qr-code" src="payimg/QQ图片20230628083725.jpg">
      <p class="qr-description">微信支付</p>
    </div>
    <div class="qr-code-container">
      <img class="qr-code" src="payimg/QQ图片20230628083716.jpg">
      <p class="qr-description">支付宝支付</p>
    </div>
    <div class="payment-buttons">
      <button onclick="completePayment()">我已完成付款</button>
      <button onclick="hidePaymentOverlay()">取消</button>
    </div>
  </div>
</div>

<script>
  function showPaymentOverlay() {
    // 显示支付界面
    document.querySelector('.payment-overlay').style.display = 'flex';
  }

  function hidePaymentOverlay() {
    // 隐藏支付界面
    document.querySelector('.payment-overlay').style.display = 'none';
  }

  function completePayment() {
    // 完成支付后跳转到其他页面
    window.location.href = 'https://example.com/success';
  }
</script>
</body>
</html>