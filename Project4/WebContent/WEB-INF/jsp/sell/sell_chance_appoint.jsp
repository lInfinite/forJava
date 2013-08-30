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
销售机会管理>指派销售机会<br/>
<input type="button" value="关于" />
<input type="submit" value="返回" />
<input type="submit" value="保存" />
<table style="width:100%;">
    <tr>
        <td style="background-color:#09F;">编号</td>
        <td><s:property value="sell_chance.id"/><input name="sell_chance.id" type="hidden" value='<s:property value="sell_chance.id"/>'/></td>
        <td style="background-color:#09F;">客户名称</td>
        <td><s:property value="sell_chance.clinet_name"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">客户等级</td>
        <td><s:property value="sell_chance.clinet_level.value"/></td>
        <td style="background-color:#09F;">地区</td>
        <td><s:property value="sell_chance.region.value"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会来源</td>
        <td><s:property value="sell_chance.chance_from"/></td>
        <td style="background-color:#09F;">成功机率(%)</td>
        <td><s:property value="sell_chance.odds"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">负责人</td>
        <td><s:property value="sell_chance.charge"/></td>
        <td style="background-color:#09F;">公司电话</td>
        <td><s:property value="sell_chance.phone"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">概述</td>
        <td colspan="3"><s:property value="sell_chance.summary"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会描述</td>
        <td colspan="3">
        <s:property value="sell_chance.chance_describe"/>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">指派给</td>
        <td> 
        <select name="sell_chance.clinet_manage.id">
            <s:iterator value="user_list" var="user_list">
                <option value='<s:property value="id"/>'><s:property value="name"/></option>
            </s:iterator>
        </select> 
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09F;">指派时间</td>
        <td><input name="" type="text"/><font color="#FF0000">*</font></td>
    </tr>
</table>
</body>
</html>