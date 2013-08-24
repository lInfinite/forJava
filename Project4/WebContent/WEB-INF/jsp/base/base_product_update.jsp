<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>
<style>
.title_td{color:#FFF; background-color:#00F; width:7%; text-align:center;}
</style>
<body>
商品编辑
<form action="" method="post">
    <input type="button" value="返回"/>
    <input type="submit" value="保存"/>
<table style="width:100%">
    <tr>
        <td class="title_td">编号</td>
        <td></td>
        <td class="title_td">名称</td>
        <td><input name="" type="text" value=""/></td>
    </tr>
    <tr>
        <td class="title_td">单位</td>
        <td><input name="" type="text" value=""/></td>
        <td class="title_td">单价</td>
        <td><input name="" type="text" value=""/></td>
    </tr>
    
    <tr>
        <td class="title_td">等级/批次</td>
        <td><input name="" type="text" value=""/></td>
        <td class="title_td">型号</td>
        <td><input name="" type="text" value=""/></td>
    </tr>
    <tr>
        <td class="title_td">备注</td>
        <td colspan="3">
        <textarea style="width:100%; height:200px;"></textarea>
        </td>
    </tr>
</table>
</form>
</body>
</html>