<%@ page contentType="text/html;charset=UTF-8"  %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="   css/style.css">
    <title>Document</title>
</head>


<body>
<!-- 导航栏 -->
<div class="nav">
    <div class="nav-header">
        <h1>网上商城管理系统</h1>
    </div>
    <div class="nav-menu">
        <ul>
            <li><a href="#" data-url="order.html">管理订单</a></li>
            <li><a href="#">管理类别</a>
                <ul>
                    <li><a href="" data-url="./addItem.jsp">添加类别</a></li>
                    <li><a href="#" data-url="./viewItem.jsp">查看类别</a></li>
                </ul>
            </li>
            <li><a href="#">商品管理</a>
                <ul>
                    <li><a href="#" data-url="./viewGoods.jsp">查看商品</a></li>
                    <li><a href="#" data-url="./addGoods.jsp">添加商品</a></li>
                </ul>
            </li>
            <li><a href="#">订单管理</a>
                <ul>
                    <li><a href="#" data-url="view_order.html">查看订单</a></li>
                </ul>
            </li>
            <li><a href="#">用户管理</a>
                <ul>
                    <li><a href="#" data-url="./viewUser.jsp">查看用户</a></li>
                    <li><a href="#" data-url="set_permission.html">设置权限</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="nav-tools">
        <ul>
            <li><a href="#">修改密码</a></li>
            <li><a href="../stage/index.jsp">回到主页</a></li>
            <li><a href="#">退出登录</a></li>
        </ul>
    </div>
</div>
<!-- 内容区域 -->
<div class="content">

    <div class="content-body">
        a
        <p>选择左侧菜单进入不同的功能模块。</p>
    </div>

</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha384-/1ZOwN1ITnhufCZoHSO1tGh2MjskCEmJ+OGx/3jZTCBmPOw1GSTYIMPeNjljBnUr"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.0.1/js/bootstrap.min.js"
        integrity="sha384-GfQenXdBCylYvow2LN/ur+1+n5nLdLlOxHbXDmByFrz9UXcZUIc5wZ2B31fsgeDx"
        crossorigin="anonymous"></script>
<script>


    // 获取所有带有 data-url 属性的菜单项
    let menuItems = document.querySelectorAll('.nav a[data-url]');
    console.info(menuItems);

    // 给每个菜单项添加点击事件响应函数
    menuItems.forEach(function (menuItem) {
        menuItem.onclick = function () {
            // 获取该菜单项的 data-url 属性值
            let url = this.getAttribute('data-url');

            // 在内容区域加载对应URL的页面内容
            let contentBody = document.querySelector('.content-body');
            contentBody.innerHTML = 'Loading...';
            let xhr = new XMLHttpRequest();
            xhr.open('GET', url);
            xhr.onload = function () {
                contentBody.innerHTML = xhr.responseText;
            };
            xhr.send();

            // 在菜单项上添加 “active” 类，用于高亮显示当前选中项
            menuItems.forEach(function (item) {
                item.classList.remove('active');
            });
            this.classList.add('active');

            // 阻止默认的跳转行为
            return false;
        };
    });


</script>

</body>
</html>