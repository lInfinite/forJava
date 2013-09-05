<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/js.js"></script>
<title>无标题文档</title>
</head>

<body>
客户开发计划>执行计划
<input type="button" value="关于" />
<input type="submit" value="终止开发" />
<input type="button" value="返回" />
<input type="submit" value="制定计划" />
<input type="submit" value="开发成功" />
<jsp:include page="sell_client_table.jsp"/>
<table width="100%">
    <tr>
        <td style="background-color:#00F;">日期</td>
        <td style="background-color:#00F;">计划</td>
        <td style="background-color:#00F;">执行效果</td>
    </tr>
    <% int i=0; %>
    <s:iterator value="clinet_list" id="clinet">
    <% i++; %>
    <tr>
        <td><s:property value="time"/></td>
        <td><s:property value="project"/></td>
        <s:if test='effect==""||effect==null'>
        <td><input id="sell_client_effect<%=i %>" type="text" /><input onClick="ajax_sell_saveClientExecute('sell_client_effect<%=i %>')" type="button" value="保存"/></td>
        </s:if>
        <s:else>
        <td><s:property value="effect"/></td>
        </s:else>
    </tr>
    </s:iterator>
</table>
</body>
</html>