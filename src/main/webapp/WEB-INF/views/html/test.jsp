<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="test1?username=中文名字">中文传递</a>
<a href="test1?username=ssss">英文传递</a>
<a href="test2">对象传递</a>
<form action="test2" method="post">
<input type="text" name="username" value="中文">
<input type="submit" value="提交">
</form>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    $.ajax({
        cache: false,
        type: "get",
        url:"form",	//把表单数据发送到ajax.jsp
        data:$('#ajaxFrm').serialize(),	//要发送的是ajaxFrm表单中的数据
        async: false,
        error: function(request) {
            alert("发送请求失败！");
        },
        success: function(data) {
           console.log(data);	//将返回的结果显示到ajaxDiv中
        }
    });
})
</script>
<form id="ajaxFrm" action="/datas" method="post">
    <input type="text" name="username" value="1">
    <input type="text" name="password" value="1">
</form>
</body>
</html>