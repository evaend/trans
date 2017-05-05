<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
    <title>Trans_CMS-后台管理中心</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css">
    <link rel="stylesheet" href="../css/global.css">
    <script type="text/javascript" src="../js/layui/layui.js"></script>
</head>
<body>
<style type="text/css">html{background: #f3f3f3;}</style>
<div class="login_page">
    <img class="logo-login" src="./images/logo-login.png" alt="logo">
    <h1>欢迎使用 Trans</h1>
    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
                <input type="text" name="username" lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
                <input type="password" name="password" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
            </div>
        </div>
       <!--  <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
                <input type="text" name="captcha" lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
                <div class="captcha"><img src="{:captcha_src()}" alt="captche" title='点击切换' onclick="this.src='/captcha?id='+Math.random()"></div>
            </div>
        </div> -->
        <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
              <button class="layui-btn input-custom-width" lay-submit="" lay-filter="login">立即登陆</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
layui.use('form',function(){
    var form = layui.form()
    ,jq = layui.jquery;

    //监听提交
      form.on('submit(login)', function(data){
        loading = layer.load(2, {
          shade: [0.2,'#000'] //0.2透明度的白色背景
        });
        var param = data.field;
        jq.post('',param,function(data){
        	location.href = '../home/index';
         /*  if(data.code == 200){
            layer.close(loading);
            layer.msg(data.msg, {icon: 1, time: 1000}, function(){
            	location.href = '../home/index';
            });
          }else{
            layer.close(loading);
            layer.msg(data.msg, {icon: 2, anim: 6, time: 1000});
             jq('.captcha img').attr('src','/captcha?id='+Math.random());
          } */
        });
        return false;
      });
});
</script>
</body>
</html>