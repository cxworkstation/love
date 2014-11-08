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
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/backstage/base.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/backstage/common/common.js"></script>

</head>
<body>
<table id="toptable" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td align="center" height="30" colspan="11" background="<%=basePath %>imgs/backstage/wbg.gif">&nbsp;订单列表</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="3%">选 择</td>
	<td width="8%">订单号</td>
	<td width="9%">用户名</td>
	<td width="10%">产品名称</td>
	<td width="6%">产品数量</td>
	<td width="8%">产品单价</td>
	<td width="8%">总金额</td>
	<td width="12%">下单时间</td>
	<td width="22%">收货地址</td>
	<td width="8%">收件电话</td>
	<td width="6%">操作</td>
</tr>
<c:forEach var="list1" items="${list}">
<tr id="${list1[0]}">
<td align="center"><input name="id" type="checkbox" id="ID" class="np" value="ID"></td>
<c:forEach var="attr" items="${list1}">
<td align="center">${attr}</td>
</c:forEach>
	<td align="center">
	<a href="javascript:del('<%=basePath %>backstage/orders/delete?order_id=${list1[0]}');">删除</a>
	</td>
	</tr>
   </c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="4" align="left">
	&nbsp;
	<a href="javascript:selAll()" class="coolbg">全选</a>
	<a href="javascript:noSelAll()" class="coolbg">取消</a>
	<a href="javascript:openWin('<%=basePath %>backstage/users/addInput');"  class="coolbg" >&nbsp;删除&nbsp;</a>
</td>
<td colspan="7" valign="top">
  <!--  搜索表单  -->
<form name='from1' action='<%=basePath %>backstage/orders/search' method='post'>
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='<%=basePath %>imgs/backstage/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='colName' style='width:150'>
            <option value=''>选择类型...</option>
          	<option value='order_id'>订单号</option>
          	<option value='state'>订单状态</option>
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