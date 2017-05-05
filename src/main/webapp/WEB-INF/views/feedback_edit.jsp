<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
    <title>Lz_CMS-后台管理中心</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css">
    <link rel="stylesheet" href="../css/global.css">
    <script type="text/javascript" src="../js/layui/layui.js"></script>
</head>
<body>
<div class="layui-tab layui-tab-brief main-tab-container">
    <ul class="layui-tab-title main-tab-title">
      <li class="layui-this">修改留言</li>
      <div class="main-tab-item">留言管理</div>
    </ul>
    <div class="layui-tab-content">
       <form class="layui-form">
        <div class="layui-tab-item layui-show">
          <input type="hidden" name="id" value="">
          <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline input-custom-width">
              <input type="text" name="title" value="试试" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">留言时间</label>
            <div class="layui-input-inline input-custom-width">
              <input type="text" name="create_time" value="2017-02-24 21:47:42" id="date" lay-verify="datetime" placeholder="YYYY-MM-DD hh:mm:ss" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this,istime: 1, format: 'YYYY-MM-DD hh:mm:ss' })">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">留言内容</label>
            <div class="layui-input-block">
              <textarea name="content" lay-verify="layedit" autocomplete="off" placeholder="请输入留言内容" class="layui-textarea layui-hide" id="content">试试</textarea>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">回复内容</label>
            <div class="layui-input-block">
              <textarea name="content" lay-verify="layedit" autocomplete="off" placeholder="请输入留言内容" class="layui-textarea layui-hide" id="content">试试</textarea>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">回复时间</label>
            <div class="layui-input-inline input-custom-width">
              <input type="text" name="create_time" value="2017-02-24 21:47:42" id="date" lay-verify="datetime" placeholder="YYYY-MM-DD hh:mm:ss" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this,istime: 1, format: 'YYYY-MM-DD hh:mm:ss' })">
            </div>
          </div>
         
          <div class="layui-form-item">
            <div class="layui-input-block">
              <button class="layui-btn" lay-submit="" lay-filter="feedback_edit">立即提交</button>
            </div>
          </div>
        </div>   
      </form>
    </div>
</div>
<script type="text/javascript">
layui.use(['element', 'form', 'upload', 'layedit', 'laydate'], function(){
  var element = layui.element()
  ,form = layui.form()
  ,layedit = layui.layedit
  ,laydate = layui.laydate
  ,jq = layui.jquery;

  //创建一个编辑器
  var content = layedit.build('content',{
    uploadImage: { url: '' ,type: 'post'  }
    ,height: 200
  });
  //创建一个编辑器
  var reply = layedit.build('reply',{
    uploadImage: { url: '' ,type: 'post'  }
    ,height: 150
  });
  //表单验证
  form.verify({
    //编辑器数据同步
    layedit: function(value){
      layedit.sync(content);
      layedit.sync(reply);
    }
  });
  
  
  //监听提交
  form.on('submit(feedback_edit)', function(data){
    loading = layer.load(2, {
      shade: [0.2,'#000'] //0.2透明度的白色背景
    });
    var param = data.field;
    jq.post('',param,function(data){
      if(data.code == 200){
        layer.close(loading);
        layer.msg(data.msg, {icon: 1, time: 1000}, function(){
          location.reload();//do something
        });
      }else{
        layer.close(loading);
        layer.msg(data.msg, {icon: 2, anim: 6, time: 1000});
      }
    });
    return false;
  });
  
})
</script>
</body>
</html>