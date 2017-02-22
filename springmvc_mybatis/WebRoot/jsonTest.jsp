<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSON交互测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
      function requestJson(){
        $.ajax({
           type:'post',
           url:'${pageContext.request.contextPath}/requestJson.action',
           contentType:'application/json;charset=utf-8',
           data:'{"name":"3","price":30}',
           success:function(data){
              alert(data);
           }
        });          
      }
      
      function responseJson(){
        $.ajax({
           type:'post',
           url:'${pageContext.request.contextPath}/responseJson.action',
           data:'name=手机&price=999',
           success:function(data){
              alert(data);
           }
        });   
      }
    </script>
  </head>
  
  <body>
    <input type="button" onclick="requestJson()" value="请求JSON，输出JSON"/>
    <input type="button" onclick="responseJson()" value="请求Key/Value，输出JSON"/>
  </body>
</html>
