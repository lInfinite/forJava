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
客户信息管理>客户信息>联系人>编辑联系人<br/>
<form action="createLinkman">
<input type="button" value="关于"/>
<input type="button" value="返回"/>
<input type="submit" value="保存"/>
<table>
    <tr>
        <td>姓名</td>
        <td><input type="text" name="linkman.name" /><font color="#FF0000">*</font></td>
        <td>性别</td>
        <td>
        <input type="radio" name="linkman.sex" value="man"/>男&nbsp;&nbsp;
        <input type="radio" name="linkman.sex" value="lady"/>女
        </td>
    </tr>
    <tr>
        <td>职位</td>
        <td><input type="text" name="linkman.position" /><font color="#FF0000">*</font></td>
        <td>办公电话</td>
        <td><input type="text" name="linkman.call"/></td>
    </tr>
    <tr>
        <td>手机</td>
        <td><input type="text" name="linkman.phone"/></td>
        <td>备注</td>
        <td><input type="text" name="linkman.remarks"/></td>
    </tr>
</table>
<input type="hidden" name="sell_chance.id" value='<s:property value="sell_chance.id"/>'/>
</form>
</body>
</html>
