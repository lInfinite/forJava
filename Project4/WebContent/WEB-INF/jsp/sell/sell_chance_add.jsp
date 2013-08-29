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
销售机会管理>新建销售机会<br/>
<form action="" method="post">
    <input type="button" value="关于" />
    <input type="button" value="返回" />
    <input type="submit" value="保存" />
<table style="width:100%;">
    <tr>
        <td style="background-color:#09F;">客户名称</td>
        <td><input name="sell_chance.clinet_name" type="text"/><font color="#FF0000">*必填项</font></td>
        <td style="background-color:#09F;">负责人</td>
        <td><input name="sell_chance.charge" type="text"/><font color="#FF0000">*必填项</font></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会来源</td>
        <td><input name="sell_chance.chance_from" type="text"/></td>
        <td style="background-color:#09F;">成功机率(%)</td>
        <td><input name="sell_chance.odds" type="text"/><font color="#FF0000">*必填项</font></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">公司电话</td>
        <td><input name="sell_chance.phone" type="text"/><font color="#FF0000">*必填项</font></td>
        <td style="background-color:#09F;">客户等级</td>
        <td>
            <select name="sell_chance.clinet_level.id">
            <s:iterator value="client_level_list" id="client_level_list">
                <option value='<s:property value="id"/>'><s:property value="value"/></option>
            </s:iterator>
            </select>
            <font color="#FF0000">*必填项</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">概要</td>
        <td><input name="sell_chance.summary" type="text"/><font color="#FF0000">*</font></td>
        <td style="background-color:#09F;">地区</td>
        <td>
            <select name="sell_chance.region.id">
            <s:iterator value="region_list" id="region_list">
                <option value='<s:property value="id"/>'><s:property value="value"/></option>
            </s:iterator>
            </select>
            <font color="#FF0000">*</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会描述</td>
        <td colspan="3">
            <textarea name="sell_chance.chance_describe" style="width:100%; height:200px;"></textarea>
            <font color="#FF0000">*必填项</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">指派给</td>
        <td>
            <select name="sell_chance.clinet_manage.id">
            <s:iterator value="user_list" var="user_list">
                <option value='<s:property value="id"/>'><s:property value="name"/></option>
            </s:iterator>
            </select>  <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09F;">指派时间</td>
        <td><input name="sell_chance.appoint_time" type="text"/><font color="#FF0000">*</font></td>
    </tr>
</table>
</form>
</body>
</html>