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
客户等级管理>编辑客户等级<br/>
<form action="updateClintLevel" method="post">
<input type="button" value="关于"/>
<input type="button" value="返回"/>
<input type="submit" value="保存"/>
<input name="clint_level.id" type="hidden" value='<s:property value="clint_level.id"/>'/>
<table style="width:100%">
    <tr>
        <td>值</td>
        <td><input name="clint_level.value" type="text"  value='<s:property value="clint_level.value"/>'/></td>
    </tr>
</table>
</form>
</body>
</html>