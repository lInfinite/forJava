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
客户开发计划<br/>
<input type="button" value="关于" />
<input type="submit" value="查询" />
<table>
    <tr>
        <td style="background-color:#09F;">客户名称</td>
        <td><input type="text" name="user_name" /></td>
        <td style="background-color:#09F">负责人</td>
        <td><input type="text" name="" /></td>
        <td style="background-color:#09F;">概要</td>
        <td><input type="text" name="summary" /></td>
    </tr>
</table>

<table style="width:100%;">
    <tr>
        <td style="background-color:#03F;">编号</td>
        <td style="background-color:#03F;">客户名称</td>
        <td style="background-color:#03F;">负责人</td>
        <td style="background-color:#03F;">公司电话</td>
        <td style="background-color:#03F;">概要</td>
        <td style="background-color:#03F;">操作</td>
    </tr>
    <s:iterator value="client_level_list" id="client_level_list">
    <tr>
        <td>编号<s:property value="id"/></td>
        <td>客户名称<s:property value=""/></td>
        <td>负责人<s:property value=""/></td>
        <td>公司电话<s:property value="phone"/></td>
        <td>概要<s:property value=""/></td>
        <td><a>[编辑]</a>&nbsp;<a>[删除]</a></td>
    </tr>
    </s:iterator>
</table>
<jsp:include page="../body/Body_Page.jsp"/>
</body>
</html>
