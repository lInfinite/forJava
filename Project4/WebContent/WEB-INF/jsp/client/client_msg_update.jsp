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
客户信息管理>客户信息<br/>
<input type="button" value="关于"/>
<input type="button" value="联系人"/>
<input type="button" value="交往记录"/>
<input type="button" value="历史订单"/>
<input type="button" value="返回"/>
<input type="button" value="保存"/>
<table>
    <tr>
        <td style="background-color:#09C;">客户名称</td>
        <td><input name="sell_chance.clinet_name" type="text" value='<s:property value="sell_chance.clinet_name"/>'/><font color="#FF0000">*</font></td>
        <td style="background-color:#09C;">客户编号</td>
        <td><input name="sell_chance.id" type="text" value='<s:property value="sell_chance.id"/>'/><font color="#FF0000">*</font></td>
    </tr>
    <tr>
        <td style="background-color:#09C;">地区</td>
        <td>
            <select>
                <option>北京</option>
            </select>
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09C;">负责人</td>
        <td><input type="text" value=""/><font color="#FF0000">*</font></td>
    </tr>
    <tr>
        <td style="background-color:#09C;">客户等级</td>
        <td>
            <select>
                <option>重点开发客户</option>
            </select>
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09C;">客户信誉度</td>
        <td>
            <select>
                <option>☆☆☆</option>
            </select>
            <font color="#FF0000">*</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09C;">客户满意度</td>
        <td>
            <select>
                <option>☆☆☆</option>
            </select>
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09C;"></td>
        <td></td>
    </tr>
</table>

<table>
<tr>
    <td style="background-color:#09C;">地址</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;">邮政编码</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">电话</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;">传真</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">网址</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;"></td>
    <td></td>
</tr>
</table>

<table>
<tr> 
    <td style="background-color:#09C;">营业执照注册号</td>
    <td><input type="text" value=""/></td>
    <td style="background-color:#09C;">法人</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">注册资金(万元)</td>
    <td><input type="text" value=""/></td>
    <td style="background-color:#09C;">年营业额</td>
    <td><input type="text" value=""/></td>
</tr>
<tr>
    <td style="background-color:#09C;">开户银行</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;">银行账号</td>
    <td><input type="text" value=""/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">地税登记号</td>
    <td><input type="text" value=""/></td>
    <td style="background-color:#09C;">国税登记号</td>
    <td><input type="text" value=""/></td>
</tr>
</table>
</body>
</html>