<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.manager.ModifyDao,user.manager.Modify,java.util.List,page.c.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script language="javascript" type="text/javascript" src="js.js">
 
</script>
</head>
<body>
<div class="menu">
	<form method="post" action="admin_bill_list.jsp">
		商品名称：<input type="text" name="productname" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="paystatus">
			<option value="">请选择</option>
			<option value="已付">已付款</option>
			<option value="未付">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="and" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
    <!-- onclick="window.location.href='mt?button=1'"-->
		<em><form action="modify.jsp" method="post">
		<input type="submit" name="button" value="添加数据" class="input-button" /></form></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
			</tr>
			<% 
		       int ye=1;
			   if(request.getParameter("ye")!=null){
			   ye=Integer.parseInt(request.getParameter("ye"));
			   }
			   Page pag=new Page();
			   int pageSize=8;
			   ModifyDao mdao=new ModifyDao();
			   int all=mdao.all();
			   int al=pag.totalPage(all, pageSize);
			   List<Modify> mlist=null;
			   Modify m=null;
			   if(request.getParameter("and")!=null){
			   String productname="%"+request.getParameter("productname")+"%";
			   String paystatus=request.getParameter("paystatus");
			   mlist=mdao.selectLike(ye, pageSize, productname, paystatus) ;
			   }else{
				   mlist=mdao.select(ye,pageSize);
			   }
			   %>
             <% 
             for(int i=0;i<mlist.size();i++){
            	   m=mlist.get(i);
            	   %>
			<tr>
				<td><%=i+1 %></td>
				<% String name=URLEncoder.encode(m.getName(),"UTF-8");
				   String describe=URLEncoder.encode(m.getDescribe(), "UTF-8"); %>
				<td><a href="modify_0.jsp?number=<%=m.getId()%>&sum=<%=m.getSum()%>
				&quantity=<%=m.getQuantity()%>&name=<%=name%>&describe=<%=describe%>"><%=m.getName() %></a></td>
				<td><%=m.getQuantity() %></td>
				<td><%=m.getSum() %></td>
				<td><%=m.getPayment() %></td>
				<td><%=m.getProvider() %></td>
				<td><%=m.getDescribe() %></td>
				<td><%=m.getTime() %></td>
			</tr>
			<%  }  %>
		</table>
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

</body>
</html>
