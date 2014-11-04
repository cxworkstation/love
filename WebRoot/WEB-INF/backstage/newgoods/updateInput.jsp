<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改当季推荐</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>js/backstage/goods/index.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/backstage/common/common.js"></script>
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
  <iframe style="display:none" id="hiddenform" name="hiddenform"></iframe>
     <table align="center" width="820px;">
       <tr>
         <td>
         <form action="servlet/AddPictureServlet" method="post" id="myformphoto" target="hiddenform" enctype="multipart/form-data">
          <table>
           <tr>
             <td colspan="2">
               <img alt="图片展现区域" id="picture" name="picture" src="" height="300px" width="300px">
             </td>
           
           </tr>
           <tr>
  	         <td> 上传图片:</td>
  		     <td> 
		       <input type="file"  name="image"  size="30" class="selectinput" onblur="uploadImg();" > 
             </td>
  	      </tr>
         </table>
          </form>   
         </td>
         <td>
       
 <form action="<%=basePath%>backstage/newgoods/update" method="post" id="myform" name="myform">
         <table>
         <tr>
  		<td colspan="2"><input type="hidden"  name="img" id="img" size="40"  value="${list}"/></td>
   	   </tr>
   	   <tr>
  		<td colspan="2"><input type="hidden"  name="aid" id="aid" size="40"  /></td>
   	   </tr>
  	   <tr>
  		<td> 商品名称：</td>
  		<td><input type="text"  name="name"  size="40"  value="${list[1]"/></td>
   	   </tr>
   	   <tr>
  		<td> 商品原价： </td>
  		<td><input type="text"  name="oldprice"  size="40" /></td>
   	   </tr>
   	   <tr>
  		<td> 商品现价： </td>
  		<td><input type="text"  name="newprice"  size="40" /></td>
   	   </tr>
   	   <tr>
   	    <td>起订数量：</td>
   	    <td>
   	      <input type="text" name="start_number" size="40" >
   	    </td>
   	   </tr>
  	   <tr>
  		<td>价格单位:</td>
  		<td>
  		   <input type="text" name="unit" size="40" >
  		</td>
   	  </tr>
   	  <tr>
   	    <td>类型名称:</td>
  		<td>
  		      <input type="text" name="type_id" size="40" >
  		</td>
   	  </tr>
   	  <tr>
   	  <td></td>
   	  <td ><input type="submit"  value="提交内容"  onclick="return checking()"></td>
   	  </tr>
   	</table>
</form>
   	</td>
   	</tr>

  <tr>
  <td colspan="2">
	<div style="text-align: center;">
	<input type="button"  onclick="goback('<%=basePath%>backstage/newgoods/index');" value="返回" >
	</div>
	
	</td>
	</tr>
	  </table>
  </body>
</html>
