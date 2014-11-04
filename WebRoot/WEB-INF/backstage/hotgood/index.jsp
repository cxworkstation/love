<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>热门商品</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/backstage/base.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/backstage/common/common.js"></script>
</head>

<body style="margin-left: 8 ;margin-top:  8">
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">

</table>

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="32" colspan="8" align="center" background="<%=basePath %>imgs/backstage/wbg.gif">&nbsp;热门商品列表</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="7%">ID</td>
	<td width="13%">商品编号</td>
	<td width="20%">商品名称</td>
	<td width="12%">商品原价</td>
	<td width="12">商品现价</td>
	<td width="12%">计价单位</td>
	<td width="12%">起订数量</td>
	<td width="12%">销售数量</td>
</tr>
<c:forEach var="list1" items="${list}">
<tr id="${list1[0]}">
<c:forEach var="attr" items="${list1}">
<td align="center">${attr}</td>
</c:forEach>
	</tr>
   </c:forEach>

<tr bgcolor="#FAFAF1">

<td colspan="8" valign="top">
  <!--  搜索表单  -->
<form name='from1' action='<%=basePath %>backstage/hotgood/search' method='get'>
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='<%=basePath %>imgs/backstage/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='colName' style='width:150'>
            <option value=''>选择类型...</option>
            <option value='product_id'>商品编号</option>
          	<option value='keyword'>商品关键字</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='key' size="40" />
        </td>
        <td align="center">
          <input type="image" src="<%=basePath %>imgs/backstage/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</td>
</tr>
</table>

</body>
</html>