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
	<form id="form1" name="form1" method="post" action="UserManager" onSubmit="return user1('pass1','pass0','pass2','pass20');">
		<div class="content">
			<table class="box"><font color="red"></font>
			<tr>
					<td class="field">旧的密码：</td>
					<td><input type="password" name="user_pass" id="textfield" class="text"/> <font color="red">*<% if(request.getAttribute("oldpass")!=null){out.print(request.getAttribute("oldpass").toString());} %></font></td>
				</tr>
		<tr>
					<td class="field">新的密码：</td>
					<td><input type="password" name="user_newpass" id="pass1" class="text" onBlur=" mustChar('pass1','pass0')"/> <font color="red">*<span id="pass0"></span></font></td>
				</tr>
                		<tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="user_pass" id="pass2" class="text" onBlur="pass('pass1','pass2','pass20')"/> <font color="red">*<span id="pass20"></span></font></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="button" name="button" id="button" onClick="window.history.go(-1)" value="返回" class="input-button"/>
		    <input type="submit" name="button" id="button" value="修改密码" class="input-button"/>
		</div>
		<% int id=Integer.parseInt(request.getAttribute("it_num").toString()); %>
            <input type="hidden" name="submit" value="修改密码二" />
            <input type="hidden" name="it_num" value="<%=id %>" />
	</form>
</div>
</body>
</html>
