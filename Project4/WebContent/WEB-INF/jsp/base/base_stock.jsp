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
仓库查询<br/>
<form action="" method="post">
<input type="button" value="关于"/>
<a><input type="button" value="新建"/></a>
<input type="submit" value="查询"/>
</form>
<table>
    <tr>
        <td>产品</td>
        <td><input type="text"/></td>
        <td>仓库</td>
        <td><input type="text"/></td>
        <td></td>
        <td></td>
    </tr>
</table>
<table style="width:100%;">
    <tr style="background-color:#00F; color:#FFF;">
        <td>序号</td>
        <td>产品</td>
        <td>仓库</td>
        <td>货位</td>
        <td>件数</td>
        <td>备注</td>
    </tr>
    <tr>
        <td>序号</td>
        <td>产品</td>
        <td>仓库</td>
        <td>货位</td>
        <td>件数</td>
        <td>备注</td>
    </tr>
</table>
</body>
</html>