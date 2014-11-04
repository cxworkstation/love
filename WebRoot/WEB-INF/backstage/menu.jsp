<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" href="<%=basePath%>css/backstage/base.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/backstage/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="<%=basePath%>js/backstage/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>商品管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li>
                <a href="<%=basePath%>backstage/goods/index"   target='main'>商品总览</a>
            </li>
            
            <li>
            	<a href="<%=basePath%>backstage/current/index"  target='main'>当季推荐</a>
            </li>
            <li>
            	<a href="<%=basePath%>backstage/newgoods/index"   target='main'>新品上市</a>
            </li>
            <li>
            	<a href="<%=basePath%>backstage/todayfree/index"   target='main'>今日免费</a>
            </li>
             <li>
                <a href="<%=basePath%>backstage/hotgood/index"   target='main'>查看热门商品</a>
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 1 End -->
      
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>事务管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
			<li><a href="<%=basePath%>backstage/orders/index" target='main'>订单管理</a></li>
			<li><a href="<%=basePath%>backstage/users/index" target='main'>用户管理</a></li>
			<li><a href="<%=basePath%>backstage/evaluates/index" target='main'>评论管理</a></li>
			<li><a href="<%=basePath%>backstage/messages/index" target='main'>留言管理</a></li>
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
      
      
       <!-- Item 3 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items3_1")'><b>内容管理</b></dt>
        <dd style='display:block' class='sitem' id='items3_1'>
          <ul class='sitemu'>
			<li><a href="<%=basePath%>attri" target='main'>关于我们</a></li>
			<li><a href="<%=basePath%>backstage/servlet/GetAllStuServlet" target='main'>商品类目</a></li>
          </ul>
        </dd>
      </dl>
      <!-- Item 3 End -->
      
	  </td>
  </tr>
</table>
</body>
</html>