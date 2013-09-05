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
客户开发计划>制定计划
<input type="button" value="关于" />
<input type="submit" value="执行计划" />
<input type="button" value="返回" />
<jsp:include page="sell_client_table.jsp"/>
<table style="width:100%;">
    <tr>
        <td align="center" style="background-color:#00F;">日期</td>
        <td align="center" style="background-color:#00F;">计划项</td>
    </tr>
    <s:iterator value="clinet_list" id="create_client">
    <tr>
        <td><s:property value="time"/></td>
        <td><input readonly type="text" value='<s:property value="project"/>' /><a href='deleteClient?sell_chance.id=<s:property value="sell_chance.id"/>&&create_clinet.id=<s:property value="id"/>'><input type="button" value="删除" /></a></td>
    </tr>
    </s:iterator>
</table>
<form action="insetClient" method="post">
<input type="submit" value="添加" />
<table style="width:100%;">
    <tr>
        <td style="background-color:#09F">日期</td>
        <td><s:property value="system_time"/><input name="create_clinet.time" type="hidden" value='<s:property value="system_time"/>'/></td>
        <td style="background-color:#09F">计划项</td>
        <td><input name="create_clinet.project" type="text" /><font color="#FF0000">*</font></td>
    </tr>
</table>
<input name="sell_chance.id" type="hidden" value='<s:property value="sell_chance.id"/>' />
</form>
</body>
</html>