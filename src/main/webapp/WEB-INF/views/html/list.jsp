<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
    <style type="text/css">
        #test{
            height:100px;
            position: relative;
        }
        #test ul{
            position: absolute;
            top:50%;
            left:50%;
            transform:translate(-50%,-50%);
        }
    </style>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            function GetQueryString(name)
            { var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]);
                return null;
            }
            var id=GetQueryString("id");
            if(id!=0)
            {
                $("#find").val(id);
            }
          $("#search").click(function () {
              var id=$(this).siblings("input").val();
              // $.ajax({
              //     type:"GET",
              //     url:"/total/pagehelper",
              //     dataType:"json",
              //     data:{"id":parseInt(id)},
              //     success:function (data) {
              //         console.log("$.ajax发送成功！")
              //     },
              //     error:function () {
              //
              //     }
              // });
             $.get("/total/pagehelper",{id:id},function () {
                 console.log("使用get发送！");
                 window.location.href="/total/pagehelper?id="+id;
             })
          })
      })
    </script>
</head>
<body>
<div class="container">
    <div class="search"><input class="setext" type="text" id="find">&nbsp;<button class="btn btn-info" id="search">搜索</button></div>
    <div class="panel panel-default">
        <div class="panel-heading text-center"><h2>商品列表</h2></div>
        <div class="panel-body">
            <table class="table" id="table">
                <thead>
                <tr>
                    <th>商品名</th>
                    <th>单价</th>
                    <th>首页图片</th>
                    <th>库存数量</th>
                    <th>物品页图片</th>
                    <th>放大镜图片</th>
                    <th>创建时间</th>
                    <th>商品编号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hotsale" items="${hotsale}">
                    <tr>
                        <td>${hotsale.name}</td>
                        <td>${hotsale.price}</td>
                        <td>${hotsale.img}</td>
                        <td>${hotsale.number}</td>
                        <td>${hotsale.wimg}</td>
                        <td>${hotsale.bimg}</td>
                        <td><fmt:formatDate value="${hotsale.createTime}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
                        <td class="hotid">${hotsale.id}</td>
                        <td class="href"><a href="/shop/delhot?hotid=${hotsale.id}" target="hidden" onclick="if(confirm('确定删除吗?')==false)return false;else{deleteRow(this);return true}">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--分页实现--%>
            <p>每页${page.pageSize}条  当前页${page.size}条${page.pageNum}/${page.pages}页
                记录数${page.total}
            </p>
            <div id="test">
            <ul class="pagination">
                <c:if test="${page.isFirstPage==true}"><li><a>首页</a></li></c:if>
                <c:if test="${page.isFirstPage==false}">
                    <li><a href="/total/pagehelper?page=${page.firstPage}">首页</a></li></c:if>
                <c:if test="${page.hasPreviousPage==true}">
                    <li><a href="/total/pagehelper?page=${page.prePage}">&laquo;</a></li></c:if>
                <c:if test="${page.hasPreviousPage==false}">
                    <li><a>&laquo;</a></li></c:if>

                <c:set var="index" value="0" />
                <c:forEach begin="1" end="${page.pages}">
                    <c:set var="index" value="${index+1}" />
                    <c:if test="${page.pageNum==index}"><li>
                        <a style="background-color: #337ab7;color:#fff">${index}</a></li>
                    </c:if>
                    <c:if test="${page.pageNum!=index}">
                        <li><a href="/total/pagehelper?page=${index}">${index}</a></li></c:if>
                </c:forEach>
                <c:if test="${page.hasNextPage==true}">
                    <li><a href="/total/pagehelper?page=${page.nextPage}">&raquo;</a></li></c:if>
                <c:if test="${page.hasNextPage==false}">
                    <li><a>&raquo;</a></li></c:if>
                <c:if test="${page.isLastPage==true}">
                    <li><a >末页</a></li></c:if>
                <c:if test="${page.isLastPage==false}">
                    <li><a href="/total/pagehelper?page=${page.lastPage}">末页</a></li></c:if>
            </ul>
            </div>
</body>
</html>