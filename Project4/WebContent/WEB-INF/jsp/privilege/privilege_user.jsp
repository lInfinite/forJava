<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>

<body>
用户管理<br/>
<input type="button" value="关于"/>
<a href="add_use"><input type="button" value="新建"/></a>
<input type="button" value="查询"/>
<table>
    <tr>
        <td>编号</td>
        <td><input type="text" /></td>
        <td>用户名</td>
        <td><input type="text" /></td>
    </tr>
</table>
<table width="100%">
    <tr style="background-color:#00F; color:#FFF; ">
        <td>编号</td>
        <td>用户名</td>
        <td>操作</td>
    </tr>
    <s:iterator value="user_list" id="user_list">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="name"/></td>
        <td><a>[编辑]</a> &nbsp; <a>[删除]</a></td>
    </tr>
    </s:iterator>
</table>
<jsp:include page="../body/Body_Page.jsp"/>
</body>
</html>