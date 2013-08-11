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
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<%String num=request.getParameter("num"); %>
	<%String name=request.getParameter("name"); %>
	<%String describe=request.getParameter("describe"); %>
	<%String preson=request.getParameter("preson"); %>
	<%String phone=request.getParameter("phone"); %>
	<%String fax=request.getParameter("fax"); %>
	<%String address=request.getParameter("address"); %>
	<form id="form1" name="form1" method="post" action="ProviderManager" onsubmit="return provider_0('id1','id0','name1','name0','textarea','textt','user1','user0','phone1','phone0','Fax1','Fax0','address1','address0')">
		<div class="content">
		<font color="red"></font>
			<table class="box">
			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td><input name="proId" id="id1" class="text" type="text" onblur="mustNum2('id1','id0')" value="<%=num%>"> <font color="red">*<span id="id0"></span></font></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="proName" id="name1" value="<%=name%>" class="text" type="text" onblur="mustChar('name1','name0')" /> <font color="red">*<span id="name0"></span></font></td>

				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="proDesc" id="textarea" cols="45" rows="5" onblur="mustChar('textarea','textt')"><%=describe %></textarea><span id="textt"></span></td>
				</tr>
				<tr>
					<td class="field">联系人姓名：</td>

					<td><input name="contact" id="user1" value="<%=preson %>" class="text" type="text" onblur="mustChar('user1','user0')" /><font color="red"><span id="user0"></span></font></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="phone" id="phone1" value="<%=phone %>" class="text" type="text" onblur="mustPhone2('phone1','phone0')"/><font color="red"><span id="phone0"></span></font></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="fax" id="Fax1" value="<%=fax %>" class="text" type="text" onblur="mustFax('Fax1','Fax0')" /><font color="red"><span id="Fax0"></span></font></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="address" id="address1" value="<%=address %>" class="text" type="text" onblur="mustChar('address1','address0')" /><font color="red"><span id="address0"></span></font></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" onclick="window.history.go(-1);" value="返回" class="input-button" type="button"> 
			<input name="button" id="button" value="修改" class="input-button" type="submit"> 
			<input name="button" id="button" value="删除" onclick="return sureDelete()" class="input-button" type="submit"> 
			 <input type="hidden" name="it_number" value="<%=request.getParameter("number") %>" />
		</div>
	</form>
</div>
</body>
</html>
