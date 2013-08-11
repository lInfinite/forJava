<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/check.js"></script>
	</head>
	
	<body>
		<div class="top">
			<div class="global-width">
				<img src="Images/logo.gif" class="logo" />
			</div>
		</div>
		<div class="status">
			<div class="global-width">欢迎你, <span id="ShowNames">${session.user.names}</span><span><a href="#" style="float:right" onclick="location.href='user_loginOut'";>注销</a></span>
			</div>
		</div>
        
		<div class="main">
			<div class="global-width">
				
