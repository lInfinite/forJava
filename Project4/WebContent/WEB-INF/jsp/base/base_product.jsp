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
产品查询<br/>
<form action="" method="post">
<input type="button" value="关于"/>
<a><input type="button" value="新建"/></a>
<input type="submit" value="查询"/>
<table>
    <tr>
        <td>名称</td>
        <td><input type="text" /></td>
        <td>型号</td>
        <td><input type="text"/></td>
        <td>等级/批次</td>
        <td><input type="text"/></td>
    </tr>
</table>
</form>
<table style="width:100%;">
    <tr style="background-color:#00F; color:#FFF;">
        <td>编号</td>
        <td>名称</td>
        <td>型号</td>
        <td>等级/批次</td>
        <td>单位</td>
        <td>单价(元)</td>
        <td>备注</td>
        <td>操作</td>
    </tr>
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>型号</td>
        <td>等级/批次</td>
        <td>单位</td>
        <td>单价(元)</td>
        <td>备注</td>
        <td><a>[编辑]</a><a>［删除］</a></td>
    </tr>
</table>
<!--body——page.html-->
</body>
</html>