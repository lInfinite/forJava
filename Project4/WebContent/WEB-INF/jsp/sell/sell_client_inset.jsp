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
        <td></td>
        <td><input readonly type="text" name="" value='<s:property value="project"/>' /><input type="button" value="删除" /></td>
    </tr>
    </s:iterator>
</table>
<form action="insetClient" method="post">
<input type="submit" value="添加" />
<table style="width:100%;">
    <tr>
        <td style="background-color:#09F">日期</td>
        <td></td>
        <td style="background-color:#09F">计划项</td>
        <td><input name="create_clinet.project" type="text" /><font color="#FF0000">*</font></td>
    </tr>
</table>
<input name="sell_chance.id" type="hidden" value='<s:property value="sell_chance.id"/>' />
</form>
</body>
</html>