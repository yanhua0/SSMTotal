<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>test</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        #login{ width:450px; height:100px; margin:50px auto;}
        #btn{ margin-left:100px; margin-top:-25px; width: 120px;height: 25px; font-size: 11px; }
        body{ background-color: #ecfcf9;}
    </style>
</head>
<!-- 图片验证码  -->
<script src="/resources/js/gVerify.js"></script>
<script>
    $(function(){
        var verifyCode = new GVerify("v_container");
        document.getElementById("code_input").onblur = function(){
            var res = verifyCode.validate(document.getElementById("code_input").value);
            if(res){
                alert("验证正确");
            }else{
                alert("验证码错误");
            }
        }
    })

</script>
<!-- 发送短信验证码倒计时-->
<script type="text/javascript">
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    function sendMessage(){curCount = count;
        $("#btn").attr("disabled", "true");
        $("#btn").val(curCount + "秒后可重新发送");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次请求后台发送验证码 TODO
    }
    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#btn").removeAttr("disabled");//启用按钮
            $("#btn").val("重新发送验证码");
        }
        else {
            curCount--;
            $("#btn").val(curCount + "秒后可重新发送");
        }
    }
</script>
<body>
<div class="container">
    <div  id="login">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-2 control-label">验证码</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="code_input" placeholder="请输入验证码"  required autofocus>
                    <span id="v_container"></span>
                </div>
            </div>
            <%--其他验证码--%>
            <div class="form-group" style="position: relative;top:50px;">
                <label class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入您的手机号"  required autofocus>

                </div>
            </div>

            <div class="form-group" style="position: relative;top:50px;">
                <label class="col-sm-2 control-label">验证码</label>
                <div class="col-sm-3">
                    <input type="code" class="form-control" id="code" name="code" placeholder="验证码" required>
                    <input class="btn btn-default" id="btn" name="btn" value="发送验证码" onclick="sendMessage()" />
                </div>
            </div>
            <div class="form-group" style="position: relative;top:50px;">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-info" id="lo">验证</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<!-- 发送短信验证码并验证  -->
<script type="text/javascript">
    var sms="";
    $("#btn").click(function(){
        var phone=$("#phone").val();
        console.log(phone);
        if(phone!="")
        {
            $.ajax({
                url:"/total/sendSMS",
                type:"POST",
                data:{"phone":phone},
                dataType:"json",
                success:function(result){
                    if(result.status==1){
                        sms=result.data;
                    }
                }
            });

        }else{
            alert("请输入手机号");
            return false;
        }

    });
    $("#lo").click(function(){
        var code=$("#code").val();
        if(code==""){
            alert("请输入验证码");
        }else{
            if(sms==code){
                window.location.href="http://localhost:8866/TestCode/jsp/success.jsp";
            }else{
                alert("验证码错误");
            };
        };
    });
</script>
</html>