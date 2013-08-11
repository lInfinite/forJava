<%@page import="user.manager.*,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js.js" type="text/javascript" language="javascript">
</script>
</head>
<body>

<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="ModifyManager" onsubmit="return modify_0('sum1','sum2','s1','s2','name1','name2','tex1','tex2')">
		<div class="content">
			<table class="box">
				<tr>
                 <% String name=request.getParameter("name"); %>
                 <% String quantity=request.getParameter("quantity"); %>
                 <% String sum=request.getParameter("sum"); %>
                 <% String describe=request.getParameter("describe"); %>
					<td class="field">交易金额：</td>
					<td><input id="sum1" type="text" name="sum" class="text" onblur="mustNum2('sum1','sum2')" value="<%=sum %>" /><font color="red"><span id="sum2"></span></font></td>
				</tr>
                <tr>
					<td class="field">交易单位：</td>
					<td>
					<select name="type">
						<option value="人民币">人民币</option>
                        <option value="港币">港币</option>
                        <option value="英镑">英镑</option>
                        <option value="澳元">澳元</option>
                        <option value="美元">美元</option>
                        <option value="日元">日元</option>
                        <option value="欧元">欧元</option>
					</select>
					</td>
				</tr>
                 <tr>
					<td class="field">交易数量：</td>
					<td><input id="s1" type="text" name="quantity" class="text" onblur="mustNum2('s1','s2')" value="<%=quantity %>" /><font color="red"><span id="s2"></span></font></td>
				</tr>
                <tr>
					<td class="field">商品名称：</td>
					<td><input id="name1" type="text"  name="username" class="text" onblur="mustChar('name1','name2')"  value="<%=name %>"/><font color="red"><span id="name2"></span></font></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea id="tex1" name="describe" onblur="mustChar('tex1','tex2')"><%=describe%></textarea><font color="red"><span id="tex2"></span></font></td>
				</tr>
                <tr>
					<td class="field">所属供应商：</td>
					<td>
                    <select name="provider">
						<option value="">名称</option>
                        <%
                          ModifyDao md=new ModifyDao();
						  List<Provider> list=md.selectSP();
						  for(int i=0;i<list.size();i++){
						  Provider p=list.get(i);
						 
						%>
                        <option value="<%=p.getName()%>"><%=p.getName()%></option>
                        <% } %>
					</select>
                    </td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td>
                    <select name="payment">
						<option value="已付">是</option>
                        <option value="未付">否</option>
					</select>
                    </td>
				</tr>
			</table>
		</div>
		<div class="buttons">
		<% String number=request.getParameter("number"); %>
			<input type="button" name="button" value="返回" class="input-button" onclick="window.history.go(-1)" />
			<input type="submit" name="submit" value="修改" class="input-button" />
			<input type="submit" name="submit" onclick="return sureDelete()" value="删除" class="input-button" />
            <input type="hidden" name="it_number" value="<%=number %>" />
		</div>
	</form>
	
</div>
</body>
</html>
