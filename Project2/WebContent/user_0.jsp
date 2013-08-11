<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script src="js.js" type="text/javascript" language="javascript">
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<% String name=request.getParameter("name"); %>
	<% String age=request.getParameter("age"); %>
	<% String phone=request.getParameter("phone"); %>
	<% String address=request.getParameter("address"); %>
	<% String type=request.getParameter("type"); %>
	<form id="form1" name="form1" method="post" action="UserManager" >
		<div class="content">
			<table class="box"><font color="red"></font>
			<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="username" class="text" id="user1" onBlur="mustChar('user1','user0')" value="<%=name %>" /> <font color="red">*<span id="user0"></span></font></td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
					<td><select name="sex" id="select">
    <option value="女">女</option>
    <option value="男">男</option>
  </select></td>
				</tr>

				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="age" class="text" id="age1" onBlur="mustAge2('age1','age0')" value="<%=age %>"/> <font color="red">*<span id="age0"></span></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="mobile" class="text" id="phone1" onBlur="mustPhone2('phone1','phone0')" value="<%=phone %>"/> <font color="red">*<span id="phone0"></span></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="address" id="textarea1" class="text" cols="45" rows="5" onBlur="mustChar('textarea1','textarea0')"><%=address %></textarea><font color="red"><span id="textarea0" ></span></font></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><%=type%></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="button" name="button" id="button" onClick="window.history.go(-1)" value="返回" class="input-button"/> 
			<input type="submit" name="submit" id="button" value="修改" class="input-button"/> 
			<input type="submit" name="submit" id="button" value="删除" onclick="return sureDelete()" class="input-button"/>
			<input type="submit" name="submit" id="button" value="修改密码" class="input-button" onClick=""/>
			<% int num=Integer.parseInt(request.getParameter("it_num")); %>
			<input type="hidden" name="it_num" id="button" value="<%=num %>" class="input-button" />
		</div>
            
	</form>
</div>
</body>
</html>
