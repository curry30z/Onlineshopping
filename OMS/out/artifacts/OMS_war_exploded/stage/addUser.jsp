<%--
  Created by IntelliJ IDEA.
  User: 冉毓
  Date: 2023/6/21
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>User Registration</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
  <link rel="stylesheet" href="css/style2.css">
</head>
<body>
<div class="header">

</div>
<form name="registrationForm" action="${pageContext.request.contextPath}/ServletAddUser" method="post" enctype="multipart/form-data">
 <h1>注册</h1>
  <label for="username">Username</label>
  <input type="text" id="username" name="username" required>

  <label for="password">Password</label>
  <input type="password" id="password"  name="password" required>

  <label for="realname">Full Name</label>
  <input type="text" id="realname" name="realname" required>

  <label for="phone">Phone</label>
  <input type="tel" id="phone" name="phone" required>

  <label for="email">Email</label>
  <input type="email" id="email" name="email" required>

  <label for="address">Address</label>
  <textarea name="address" id="address"  required></textarea>

  <label for="sex">Gender</label>
  <select name="sex" id="sex" required>
    <option value="">--Please choose an option--</option>
    <option value="男">Male</option>
    <option value="女">Female</option>
    <option value="其他">Other</option>
  </select>

  <label for="avatar">Avatar</label>
  <input type="file" id="avatar" name="file" accept="image/*" required>

  <button type="submit">Submit</button>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="">
    // 表单验证
    const form = document.forms.registrationForm;
    form.addEventListener('submit', function(event) {
      event.preventDefault(); // 停止表单提交
      const fields = ['username', 'password', 'fullname', 'phone', 'email', 'address', 'gender', 'avatar'];
      let isError = false;
      fields.forEach(function(field) {
        const input = form.elements[field];
        const value = input.value.trim();
        if (!value) {
          input.classList.add('error');
          isError = true;
        } else {
          input.classList.remove('error');
        }
      });
      if (!isError) {
        form.submit(); // 提交表单
      }
    });

    // 移除错误样式
    form.addEventListener('input', function(event) {
      const input = event.target;
      const value = input.value.trim();
      if (value) {
        input.classList.remove('error');
      }
    });
  </script>
</form>
</body>
</html>
