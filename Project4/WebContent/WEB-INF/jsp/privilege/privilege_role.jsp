<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>

<body>
用户管理<br/>
<input type="button" value="关于"/>
<input type="button" value="新建"/>
<input type="button" value="查询"/>
<table>
    <tr>
        <td>编号</td>
        <td><input type="text" /></td>
        <td>角色名</td>
        <td><input type="text" /></td>
    </tr>
</table>
<table style="width:100%;">
    <tr style="background-color:#00F; color:#FFF; width:100%;">
        <td>编号</td>
        <td>角色名</td>
        <td>操作</td>
    </tr>
    <tr>
        <td>编号</td>
        <td>角色名</td>
        <td>操作</td>
    </tr>
</table>
<jsp:include page="../body/Body_Page.jsp"/>
</body>
</html>