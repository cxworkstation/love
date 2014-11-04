<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>操作</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		操作成功！
		<br>
		<div id="inf">
			该页面将在5秒钟之后跳转到首页
		</div>
		<input type="button" value="关闭窗口" onclick="window.close();" />
		
		<script type="text/javascript">
  	      function clock(){
        	 i = i-1;
             if(document.getElementById("inf")){
              document.getElementById("inf").innerHTML = "本窗口将在"+i+"秒后自动关闭";
             }
      
             if(i>0){
                setTimeout("clock()",1000);
             }else{
        	     window.close();
              }
           }
             var i=6;
             clock();
         </script>
	</body>
</html>

