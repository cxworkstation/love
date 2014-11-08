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
<title>商品总览</title>
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
     <a href="javascript:openWin('<%=basePath %>backstage/goods/addInput');" class="coolbg np">添加商品</a>
 </td>
 </tr>
</table>
</td>
</tr>
</table>
<table id="toptable" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="<%=basePath %>imgs/backstage/wbg.gif">&nbsp;商品列表</td>
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
<c:if test="${! empty pm.list}">
<c:forEach var="list" items="${pm.list}">
<tr id="${list[0]}">
<td align="center"><input name="id" type="checkbox" id="ID" class="np" value="ID"></td>
<c:forEach var="attr" items="${list}">
<td align="center">${attr }</td>
</c:forEach>
	<td align="center">
	<a href="javascript:openWin('<%=basePath %>backstage/goods/updateInput?id=${list[0]}');">编辑</a> |
	<a href="javascript:del('<%=basePath %>backstage/goods/delete?id=${list[0]}');">删除</a> | 
	<a href="javascript:openWin('<%=basePath %>backstage/goods/remarkInput?id=${list[0]}');">备注</a> 
	</td>
	</tr>
   </c:forEach>
</c:if>
<c:if test="${empty pm.list}">
  <tr>
    <td colspan="10" align="center">数据库暂时没有数据</td>
  </tr>
</c:if>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="3" align="left">
	&nbsp;
	<a href="javascript:selAll()" class="coolbg">全选</a>
	<a href="javascript:noSelAll()" class="coolbg">取消</a>
	<a href="javascript:openWin('<%=basePath %>backstage/goods/addInput');"  class="coolbg" >&nbsp;删除&nbsp;</a>
</td>
<td colspan="7" valign="top">
  <!--  搜索表单  -->
<form name='from1' action='<%=basePath %>backstage/goods/search' method='post'>
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
          	<option value='name'>商品名称</option>
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
<tr bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center">
	   <pg:pager  url="search"  items="${pm.totalCount}" maxPageItems="${pm.pageSize}" maxIndexPages="7" export="currentPageNumber = pageNumber">
	   <pg:param name="colName" value="${colName}"/>
	   <pg:param name="key" value="${key}"/>
      <pg:first>
         <a href="${pageUrl}">首页</a>
      </pg:first>
      
      <pg:prev>
       <a href="${pageUrl}">上一页</a>
      </pg:prev>
     
      <pg:pages>
       <c:choose>
        <c:when test="${currentPageNumber eq pageNumber}">
         <font color="red"> ${pageNumber }</font>
        </c:when>
        <c:otherwise><a href="${pageUrl }">${pageNumber }</a></c:otherwise>
       </c:choose>   
      </pg:pages>
      
      <pg:next>
       <a href="${pageUrl }">下一页</a>
      </pg:next>
      <pg:last>
       <a href="${pageUrl }">尾页</a>
      </pg:last>
    </pg:pager>
	</td>
</tr>


</table>

</body>
</html>