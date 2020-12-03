<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .content{
            width: 800px;
            height:800px;
            /*background:no-repeat,fixed,*/
            /*url(images/吃.jpg);*/
            /*background-size:100% 100% ;*/
        }
        .yonghuming{

        }
    </style>
</head>
<body>
<div class="content">
    <form role="form" method="post" action="/admin/admin/index">
    <div class="yonghuming">
<label >用户名：</label>
<input name="username" type=text" value="${(productInfo.productDescription)!''}" />
    </div>
    <div class="mima">
    <label >密码：</label>
    <input name="password" type=text" value="${(productInfo.productDescription)!''}" />
    </div>
<button type="submit" >提交</button>
</form>
</div>

</body>
</html>