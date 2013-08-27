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
<form action="stock" method="post">
<input type="button" value="关于"/>
<a href="create_stock"><input type="button" value="新建"/></a>
<input type="submit" value="查询"/>
</form>
<table>
    <tr>
        <td>产品</td>
        <td><input name="stock.product.name" type="text"/></td>
        <td>仓库</td>
        <td><input name="stock.repositories" type="text"/></td>
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
        <td>操作</td>
    </tr>
    <s:iterator value="stock_list" id="stock_list">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="product.name"/></td>
        <td><s:property value="repositories"/></td>
        <td><s:property value="cargo_space"/></td>
        <td><s:property value="number"/></td>
        <td><s:property value="remark"/></td>
        <td><a href='update_stock?stock.id=<s:property value="id"/>'>[编辑]</a>
            <a href='deleteStock?stock.id=<s:property value="id"/>'>[删除]</a>
            </td>
     </tr>
    </s:iterator>
</table>
</body>
</html>