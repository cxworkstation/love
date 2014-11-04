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
<title>今日免费</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/backstage/base.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/backstage/common/common.js"></script>
</head>

<body style="margin-left: 8 ;margin-top:  8">
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center" background="<%=basePath %>imgs/backstage/wbg.gif">
     <a href="javascript:openWin('<%=basePath %>backstage/todayfree/addInput');" class="coolbg np">添加今日免费商品</a>
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="<%=basePath %>imgs/backstage/wbg.gif">&nbsp;今日免费列表</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选 择</td>
	<td width="4%">ID</td>
	<td width="12%">商品编号</td>
	<td width="18%">商品名称</td>
	<td width="10%">商品原价</td>
	<td width="10">商品现价</td>
	<td width="8%">计价单位</td>
	<td width="8%">起订数量</td>
	<td width="8%">销售数量</td>
	<td width="18%">操作</td>
</tr>
<c:forEach var="list1" items="${list}">
<tr id="${list1[0]}">
<td align="center"><input name="id" type="checkbox" id="ID" class="np" value="ID"></td>
<c:forEach var="attr" items="${list1}">
<td align="center">${attr}</td>
</c:forEach>
	<td align="center">
	<a href="javascript:openWin('<%=basePath %>backstage/todayfree/updateInput?id=${list1[0]}');">编辑</a> |
	<a href="javascript:del('<%=basePath %>backstage/todayfree/delete?id=${list1[0]}');">删除</a> | 
	<a href="javascript:openWin('<%=basePath %>backstage/todayfree/remarkInput?id=${list1[0]}');">备注</a> 
	</td>
	</tr>
   </c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="3" align="left">
	&nbsp;
	<a href="javascript:selAll()" class="coolbg">全选</a>
	<a href="javascript:noSelAll()" class="coolbg">取消</a>
	<a href="javascript:bulkdel('<%=basePath %>backstage/todayfree/delBatch')" class="coolbg">&nbsp;删除&nbsp;</a>
</td>
<td colspan="7" valign="top">
  <!--  搜索表单  -->
<form name='from1' action='<%=basePath %>backstage/todayfree/search' method='post'>
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='<%=basePath %>imgs/backstage/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='colName' style='width:150'>
            <option value=''>选择类型...</option>
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