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
客户等级管理<br/>
<form action="queryClintLevel" method="post">
    <input type="button" value="关于"/>
    <a href="base/create_clintlevel"><input type="button" value="新建"/></a>
    <input type="submit" value="查询"/>
<table>
    <tr>
        <td>编号</td>
        <td><input name="clint_level.id" type="text"/></td>
        <td>值</td>
        <td><input name="clint_level.value" type="text"/></td>
    </tr>
</table>
</form>

<table style="width:100%">
    <tr style="background-color:#00F; color:#FFF;">
        <td>编号</td>
        <td>值</td>
        <td>操作</td>
    </tr>
    <s:iterator value="clint_level_list" id="clint_level_list">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="value"/></td>
        <td><a href='base/update_clintlevel?clint_level.id=<s:property value="id"/>'>[编辑]</a>&nbsp;
            <a href='base/deleteClintLevel?clint_level.id=<s:property value="id"/>'>[删除]</a></td>
    </tr>
    </s:iterator>
</table>
<!--body_page.html-->
</body>
</html>