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
服务类型管理<br/>
<form action="service_type" method="post">
    <input type="button" value="关于"/>
    <a href="create_service_type"><input type="button" value="新建"/></a>
    <input type="submit" value="查询"/>
<table>
    <tr>
        <td>编号</td>
        <td><input name="service_type.id" type="text"/></td>
        <td>值</td>
        <td><input name="service_type.value" type="text"/></td>
    </tr>
</table>
</form>
<table style="width:100%">
    <tr style="background-color:#00F; color:#FFF;">
       <td>编号</td>
       <td>值</td>
       <td>操作</td>
    </tr>
    <s:iterator value="service_type_list" id="service_type_list">
    <tr>
       <td><s:property value="id"/></td>
       <td><s:property value="value"/></td>
       <td>
            <a href='update_service_type?service_type.id=<s:property value="id"/>'>[编辑]</a>&nbsp;
            <a href='deleteServiceType?service_type.id=<s:property value="id"/>'>[删除]</a>
       </td>
    </tr>
    </s:iterator>
</table>
<!--body_page.html-->
</body>
</html>