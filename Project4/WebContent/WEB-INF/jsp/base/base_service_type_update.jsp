<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>

<body>
服务类型管理>编辑服务类型
<form action="updateServiceType" method="post">
	<input type="button" value="关于"/>
	<input type="button" value="返回"/>
	<input type="submit" value="保存"/>
	<table>
	    <tr>
	        <td>值</td>
	        <td><input name="service_type.id" type="hidden" value='<s:property value="service_type.id"/>'/><input name="" type="text" value='<s:property value="service_type.value"/>' /></td>
	    </tr>
	</table>
</form>
</body>
</html>