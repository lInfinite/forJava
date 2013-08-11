<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.manager.*,java.util.List,page.c.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script src="js.js" type="text/javascript" language="javascript">
</script>
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="providerAdamin.jsp">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input name="and" value="组 合 查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<!-- onClick="window.location.href='mt?button=2'" -->
		<em><form action="providerAdd.html" method="post"><input type="submit" name="button" value="添加数据" class="input-button" />
		<input type="hidden" value="provider" name="it" /></form></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
  <tbody>
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">传真</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
  </tr>
		  <%
		  int ye=1;
		  if(request.getParameter("ye")!=null){
		  ye=Integer.parseInt(request.getParameter("ye"));
		  }
		  Page pag=new Page();
		  int pageSize=8;
		  ProviderDao providerD=new ProviderDao();
		  int all=providerD.all();
		  int al=pag.totalPage(all, pageSize);
		  List<Provider> list=null; 
		  if(request.getParameter("and")!=null){
			  String  providerName="%"+request.getParameter("providerName")+"%";
			  String  providerDesc="%"+request.getParameter("providerDesc")+"%";
			  list=providerD.selectLike(ye, pageSize, providerName, providerDesc);
		  }else{
		  list=providerD.select(ye,pageSize);
		  }
		  for(int i=0;i<list.size();i++){
		  Provider provider=list.get(i);
		  %>
	  <tr>
	  <% String name=URLEncoder.encode(provider.getName(), "UTF-8");
	     String describe=URLEncoder.encode(provider.getDescribe(), "UTF-8");
	     String preson=URLEncoder.encode(provider.getPreson(), "UTF-8");
	     String address=URLEncoder.encode(provider.getAddress(), "UTF-8");
	  %>
	    <td width="70" height="29"><div class="STYLE1" align="center"><%=provider.getNum()%></div></td>
	    <td width="80"><div class="STYLE1" align="center"><a href="provider_0.jsp?number=<%=provider.getId()%>
	    &num=<%=provider.getNum()%>&name=<%=name%>&describe=<%=describe%>&preson=<%=preson%>
	    &phone=<%=provider.getPhone() %>&fax=<%=provider.getFax()%>&address=<%=address%>"><%=provider.getName() %></a></div></td>
	    <td width="100"><div class="STYLE1" align="center"><%=provider.getDescribe() %></div></td>
	    <td width="100"><div class="STYLE1" align="center"><%=provider.getPreson() %></div></td>
	    <td width="100"><div class="STYLE1" align="center"><%=provider.getPhone() %></div></td>
	    <td width="100"><div class="STYLE1" align="center"><%=provider.getFax()%></div></td>
	    <td width="100"><div class="STYLE1" align="center"><%=provider.getAddress() %></div></td>
	  </tr>
	  <!-- 
	<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
	   -->
  <%} %>
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