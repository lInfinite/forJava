<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
    <tr>
        <td></td>
        <td></td>
        <td><input type="text" /><input type="submit" value="保存"/></td>
    </tr>
</table>
</body>
</html>