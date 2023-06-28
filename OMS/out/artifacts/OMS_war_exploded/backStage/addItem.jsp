<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/24
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* body */
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica,
            Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
            background: #f4f6f8;
            color: #333;
        }

        /* header */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 80px;
            padding: 0 80px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .logo {
            font-size: 24px;
            font-weight: 600;
        }

        /* form */
        form {
            max-width: 800px;
            margin: 40px auto;
            padding: 0 60px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            font-size: 28px;
            margin-bottom: 20px;
            margin-left: 350px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: none;
            border-radius: 4px;
            background-color: #f6f6f6;
            resize: none;
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
    </style>
</head>
<body>

<h1>类别添加</h1>
<form action="${pageContext.request.contextPath}/ServletAddItemdesc" method="post">
    <span>类别名</span>   <input type="text" name="name" >
    <p>类别描述</p>
    <textarea id="message" name="itemdesc" rows="10" cols="40"></textarea>

    <button type="submit">添加</button>
</form>


</body>
</html>
