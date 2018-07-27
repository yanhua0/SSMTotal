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
	$.post("test2",{},function(result){
		console.log(result);
	});
})
</script>
</body>
</html>