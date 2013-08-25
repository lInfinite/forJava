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
<form action="product" method="post">
<input type="button" value="关于"/>
<a href="product_create"><input type="button" value="新建"/></a>
<input type="submit" value="查询"/>
<table>
    <tr>
        <td>名称</td>
        <td><input name="product.name" type="text" /></td>
        <td>型号</td>
        <td><input name="product.model" type="text"/></td>
        <td>等级/批次</td>
        <td><input name="product.level" type="text"/></td>
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
    <s:iterator value="product_list" id="product_list">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="name"/></td>
        <td><s:property value="modle"/></td>
        <td><s:property value="level"/></td>
        <td><s:property value="unit"/></td>
        <td><s:property value="money"/></td>
        <td><s:property value="remark"/></td>
        <td><a href='product_update?product.id=<s:property value="product.id"/>'>[编辑]</a>
            <a href='deleteProduct?product.id=<s:property value="product.id"/>'>[删除]</a>
        </td>
    </tr>
    </s:iterator>
</table>
<!--body——page.html-->
</body>
</html>