<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <base href="<%=basePath%>">
    
    <title>添加备注</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<style type="text/css">
table { margin-top:10px;background-color:#eef4ea; 
}
td {
border:1px solid #cbd8ac; border-collapse:collapse; font-size:14px; text-align:left; padding:10px; }
.finput input{ background:#f1fbb4;}
table img{ float:left;}
table .floatLeft{float:left; }
</style>
	
  </head>
  <body>
  <form action="<%=basePath %>backstage/current/updateremark" method="post">
  <table align="center" width="820px;">
   	  <tr>
   	    <td>商品备注:</td>
  		<td>
  		     <textarea rows="18" cols="50" name="remark">${remark}</textarea>
  		</td>
   	  </tr>
   	  <tr>
   	  <td colspan="2"><input type="hidden" name="aid" value="${aid}"/></td>
   	  </tr>
  </table>
  <div style="text-align: center;">
	  <input type="submit"  value="提交内容">
	  <input type="button"  onclick="window.close();" value="关闭窗口" >
	</div>
	 </form>
  </body>
</html>
