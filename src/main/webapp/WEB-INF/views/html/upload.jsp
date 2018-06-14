<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>Insert title here</title>
</head>
<body>
<form action="/total/upload" method="POST" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" />
</form>
<a href="/index/download">下载</a>
</body>
</html>