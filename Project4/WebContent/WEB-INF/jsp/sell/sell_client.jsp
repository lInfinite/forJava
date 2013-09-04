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
        <td style="background-color:#03F;">状态</td>
        <td style="background-color:#03F;">操作</td>
    </tr>
    <s:iterator value="sell_list" id="sell_list">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="clinet_name"/></td>
        <td><s:property value="charge"/></td>
        <td><s:property value="phone"/></td>
        <td><s:property value="summary"/></td>
        <s:if test="state=='已指派'">
            <td>开发中</td>
        <td>
            <a href='client_inset?sell_chance.id=<s:property value="id"/>'>[定制计划]</a>&nbsp;
            <a href='client_execute?sell_chance.id=<s:property value="id"/>'>[执行计划]</a>&nbsp;
            <a>[开发成功]</a>
        </td>
        </s:if> 
        <s:else>
            <td>已归档</td>
        <td><a>[查看]</a></td>
        </s:else>
    </tr>
    </s:iterator>
</table>
<jsp:include page="../body/Body_Page.jsp"/>
</body>
</html>
