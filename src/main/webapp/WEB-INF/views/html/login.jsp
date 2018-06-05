<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="/resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btn1").click(function () {
               window.document.f.action="/total/user";
               window.document.f.submit();
            });
            $("#btn2").click(function () {
                window.document.f.action="/total/map";
                window.document.f.submit();
                // $.ajax({
                //     url: '/total/map',
                //     method: 'get',
                //     dataType: 'json',
                //     data: {"username": "1", "password": "2"},
                //     success: function(data) {
                //         console.log("success...");
                //     },
                //     error: function(data) {
                //         console.log("error...");
                //     }
                // });
            });
        });

    </script>
</head>
<body>
<form name="f"  method="get">

    <input type="text" name="username">
    <input type="text" name="password">
    <input type="button" id="btn1" value="提交user">
    <input type="button" id="btn2" value="提交map">

</form>
</body>
</html>