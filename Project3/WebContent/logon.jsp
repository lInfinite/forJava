<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户登录</title>
  
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	
	body {
		font: 12px 宋体;
		background: #4BB8EF url(Images/bg.gif) repeat-x;
	}
	
	img {
		border: 0;
	}
	
	.login-top {
		width: 100%;
		height: 186px;
		margin: 147px auto 0;
		background: url(Images/login_01.gif) no-repeat center 0;
	}
	
	.login-area {
		width: 100%;
		height: 140px;
		margin: 0 auto;
		background: url(Images/login_02.gif) no-repeat center 0;
	}
	
	.login-area form {
		width: 290px;
		margin: 0 auto;
	}
	
	.login-area label {
		clear: left;
		float: left;
		margin-top: 13px;
		width: 60px;
		font: 600 14px 宋体;
	}
	
	.login-area  input {
		width: 122px;
		height: 16px;
		margin-top: 11px;
		border: 1px #767F94 solid;
		font: 12px/ 16px 宋体;
	}
	
	input.login-sub {
		width: 204px;
		height: 34px;
		border: 0;
		background: url(Images/login_sub.gif) no-repeat 90px 1px; *
		margin-top: 5px;
	}
	
	.login-copyright {
		width: 100%;
		height: 30px;
		margin: 18px auto 0;
		background: url(Images/copyright.gif) no-repeat center 0;
	}
</style>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/check.js"></script>
</head>
 
<body>
	<div class="login-top"></div>
	<div class="login-area">
		<form action="user_logon" method="post" onSubmit="return submit_2('user_name','user_password')">
			<label>
				工&nbsp;&nbsp;号：
			</label>
			    <input type="text" name="user.name" id="user_name" onBlur="notNullAndChar('user_name','nameErorr')" /><font id="nameErorr" style="color:#F00; font-size:10px;"></font>
			<label>
				密&nbsp;&nbsp;码：
			</label>
			    <input type="password" name="user.password" id="user_password" onBlur="notNullAndChar('user_name','passwordErorr')"  /><font id="passwordErorr"style="color:#F00; font-size:10px;"><s:fielderror><s:param>LogonErorr</s:param></s:fielderror></font>
			
			<input type="submit" class="login-sub" value="" id="submit" />
			<br/>
		</form>
	</div>
	<div class="login-copyright"></div>
	<div id="erorr"></div>
</body>
</html>
