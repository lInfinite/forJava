<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.manager.*,java.util.List,page.c.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
 function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
} 
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="userAdmin.jsp">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" name="like" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<!--onClick="window.location.href='mt?button=3'" -->
<div class="optitle clearfix">
		<em><form action="userAdd.html" method="post"><input type="submit" name="button" value="添加数据" class="input-button" />
		<input type="hidden" value="user" name="it" /></form></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
  </tr>
  <%
     int ye=1;
      if(request.getParameter("ye")!=null){
       ye=Integer.parseInt(request.getParameter("ye"));
      }
	   Page pag=new Page();
	   int pageSize=8;
       UserDao ud=new UserDao();
	   int all=ud.all();
	   int al=pag.totalPage(all, pageSize);
	   List<User> list=null;
	   if(request.getParameter("like")!=null){
		   String userName="%"+request.getParameter("userName")+"%";
		   list=ud.selectLike(ye, pageSize, userName);
	   }else{
	   list=ud.select(ye,pageSize);
	   }
  %>
  <% for(int i=0;i<list.size();i++){
	  User u=list.get(i);
	  %>
  <tr>
  <% String name=URLEncoder.encode(u.getName(), "UTF-8"); 
     String address=URLEncoder.encode(u.getAddress(), "UTF-8");
     String type=URLEncoder.encode(u.getType(), "UTF-8");
  %>
    <td height="23"><span class="STYLE1"><%=i+1 %></span></td>
    <td><span class="STYLE1"><a href="user_0.jsp?it_num=<%=u.getId() %>&name=<%=name%>&age=<%=u.getAge()%>&phone=<%=u.getPhone() %>&address=<%=address%>&type=<%=type%>"><%=u.getName() %></a></span></td>
    <td><span class="STYLE1"><%=u.getSex() %></span></td>
    <td><span class="STYLE1"><%=u.getAge() %></span></td>
    <td><span class="STYLE1"><%=u.getPhone() %></span></td>
    <td><span class="STYLE1"><%=u.getAddress() %></span></td>
    <td><span class="STYLE1"><%=u.getType() %> </span></td>
  </tr>
  <% } %>
</tbody></table>
        <ul id="page">
        <% if(ye>1){ %>
		  <li> <a href="admin_bill_list.jsp?ye=1">首页</a> </li>
          <li><a href="admin_bill_list.jsp?ye=<%=ye-1%>">上一页</a> </li>
          <%} 
            if(ye<al){  %>
          
          <li><a href="admin_bill_list.jsp?ye=<%=ye+1%>">下一页</a> </li>
          <li><a href="admin_bill_list.jsp?ye=<%=al%>">最后页</a> </li>
          <%} %>
          <li>当前页：<%=ye %>/<%=al %> </li>
         </ul>
</div>
</div>
</body></html>