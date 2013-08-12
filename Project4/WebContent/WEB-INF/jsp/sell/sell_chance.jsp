<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<title>无标题文档</title>
</head>

<body>
销售机会管理<br/>
<input type="button" value="关于" />
<input type="submit" value="新建" />
<input type="submit" value="查询" />
<table>
    <tr>
        <td style="background-color:#09F;">客户名称</td>
        <td><input type="text" name="user_name" /></td>
        <td style="background-color:#09F;">概要</td>
        <td><input type="text" name="summary" /></td>
    </tr>
</table>

<table>
    <tr>
        <td style="background-color:#03F;">编号</td>
        <td style="background-color:#03F;">客户名称</td>
        <td style="background-color:#03F;">负责人</td>
        <td style="background-color:#03F;">公司电话</td>
        <td style="background-color:#03F;">概要</td>
        <td style="background-color:#03F;">操作</td>
    </tr>
    <tr>
        <td>编号</td>
        <td>客户名称</td>
        <td>负责人</td>
        <td>公司电话</td>
        <td>概要</td>
        <td>
            <a href="">指派</a>&nbsp;
            <a href="">编辑</a>&nbsp;
            <a href="">删除</a>&nbsp;
        </td>
    </tr>
    <tr>
        <td></td>
        <td>共?条记录</td>
        <td>每页<input class="page" type="text" value="" /></td>
        <td>第<input class="page" type="text" value="" />页/共?页</td>
        <td>
            <a href="">第一页</a>
            <a href="">上一页</a>
            <a href="">下一页</a>
            <a href="">最后一页</a>
        </td>
        <td>转到第<input class="page" type="text" value=""/>页<input type="submit" value="GO"/></td>
    </tr>
</table>
</body>
</html>
