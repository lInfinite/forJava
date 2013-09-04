<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table style="width:100%;">
    <tr>
        <td style="background-color:#09F;">编号</td>
        <td><s:property value="sell_chance.id"/></td>
        <td style="background-color:#09F">机会来源</td>
        <td><s:property value="sell_chance.chance_from"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">客户名称</td>
        <td><s:property value="sell_chance.clinet_name"/></td>
        <td style="background-color:#09F">成功机率(%)</td>
        <td><s:property value="sell_chance.odds"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">负责人</td>
        <td><s:property value="sell_chance.charge"/></td>
        <td style="background-color:#09F">公司电话</td>
        <td><s:property value="sell_chance.phone"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">概要</td>
        <td colspan="3"><s:property value="sell_chance.summary"/></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会描述</td>
        <td colspan="3"><s:property value="sell_chance.chance_describe"/></td>
    </tr>
</table>
