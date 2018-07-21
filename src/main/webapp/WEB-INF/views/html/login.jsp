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
                //json遍历  success: function(data) {
                //            for(var p in data){//遍历json数组时，这么写p为索引，0,1
                //                data1[p]=data[p].data1;
                //                data2[p]=data[p].data2;
                //            }
                // Date类型转化
                // function compareNine(value) {
                //     return value > 9 ? value : '0' + value;
                // }
                // function formatNumToDate(value) {
                //     var now=new Date(value)
                //     //直接借助datapattern.js扩展 return now.pattern('yyyy-MM-dd hh:mm:ss');
                //     //或者使用下面方式计算
                //     var year = now.getYear() + 1900;//或者 now.getFullYear();
                //     var month = now.getMonth() + 1;
                //     var date = now.getDate();
                //     var hour = now.getHours();
                //     var minute = now.getMinutes();
                //     var second = now.getSeconds();
                //     return year + "-" + compareNine(month) + "-" + compareNine(date) + " " + compareNine(hour) + ":" + compareNine(minute) + ":" + compareNine(second);
                // }
            });
            $("#btn3").click(function () {
                var arr=["1","2","3"];
                console.log(arr);
                $.get("/total/array",{arr:arr},function () {

                })
            });
            $("#btn4").click(function () {
                var arr=["1","2","3"];
                console.log(arr);
                $.get("/total/array1",{arr:arr},function () {

                })
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
    <input type="button" id="btn3" value="提交数组">
    <input type="button" id="btn4" value="提交数组2">
</form>
</body>
</html>