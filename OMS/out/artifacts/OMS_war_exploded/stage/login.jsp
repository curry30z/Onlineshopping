<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/20
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apple Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>
<div class="header">

</div>
<div class="login-container">
    <h1>Sign in to your Apple Account</h1>

    <form method="post" action="${pageContext.request.contextPath}/ServletLogin">
        <label for="username">UseName ID</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        <div>
            <img id="codeImg" src="${pageContext.request.contextPath}/ImageCodeServlet" />
            <a href="javascript:void(0);" onclick="document.getElementById('codeImg').src='${pageContext.request.contextPath}/ImageCodeServlet?'+Math.random()">换一张</a>
        </div>
        <div>
            <input type="text" name="code" id="code" />
        </div>
        <p><a href="addUser.jsp">没有账号去注册?</a></p>
        <button type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
        <p class="terms">By signing in to your ID account, you agree to our <a href="#">Terms of Service</a>.</p>
    </form>
</div>

<div class="footer">
    <p>&copy; 2023 RY Inc.</p>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="">
    $('form').submit(function (e) {
        e.preventDefault();
        alert('Sorry, this is just a sample login page. No actual login is possible!');
    });

</script>
</body>
</html>
