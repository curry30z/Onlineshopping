    <%@ page contentType="text/html;charset=UTF-8"  %>

    <!doctype html>
    <html lang="en">
    <head>
    <meta charset="UTF-8">
                 <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
                        <li><a href="#" data-url="add_category.html">添加类别</a></li>
                        <li><a href="#" data-url="view_category.html">查看类别</a></li>
                    </ul>
                </li>
                <li><a href="#">商品管理</a>
                    <ul>
                        <li><a href="#" data-url="index.jsp">查看商品</a></li>
                        <li><a href="#" data-url="add_product.html">添加商品</a></li>
                    </ul>
                </li>
                <li><a href="#">订单管理</a>
                    <ul>
                        <li><a href="#" data-url="view_order.html">查看订单</a></li>
                    </ul>
                </li>
                <li><a href="#">用户管理</a>
                    <ul>
                        <li><a href="#" data-url="view_user.html">查看用户</a></li>
                        <li><a href="#" data-url="set_permission.html">设置权限</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="nav-tools">
            <ul>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">回到主页</a></li>
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
    <script>    $(document).ready(function () {
        // 点击导航栏链接时阻止页面跳转，并异步加载内容
        $('.nav-link').click(function (e) {
            e.preventDefault();
            let url = $(this).attr('href');
            $('#page-content').load(url);
        });
    });
    </script>

    </body>
    </html>