<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<table>
    <tr>
        <td style="background-color:#09F;">客户名称</td>
        <td><input name="" type="text"/><font color="#FF0000">*必填项</font></td>
        <td style="background-color:#09F;">负责人</td>
        <td><input name="" type="text"/><font color="#FF0000">*必填项</font></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会来源</td>
        <td><input name="" type="text"/></td>
        <td style="background-color:#09F;">成功机率(%)</td>
        <td><input name="" type="text"/><font color="#FF0000">*必填项</font></td>
    </tr>
    <tr>
        <td style="background-color:#09F;">公司电话</td>
        <td><input name="" type="text"/><font color="#FF0000">*必填项</font></td>
        <td style="background-color:#09F;">客户等级</td>
        <td>
            <select>
            <s:iterator value="" id="">
                <option value=""><s:property value=""/></option>
            </s:iterator>
            </select>
            <font color="#FF0000">*必填项</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">概要</td>
        <td><input name="" type="text"/><font color="#FF0000">*</font></td>
        <td style="background-color:#09F;">地区</td>
        <td>
            <select>
            <s:iterator value="" id="">
                <option value=""><s:property value=""/></option>
            </s:iterator>
            </select>
            <font color="#FF0000">*</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">机会描述</td>
        <td colspan="3">
            <textarea></textarea>
            <font color="#FF0000">*必填项</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09F;">指派给</td>
        <td>
            <select>
            <s:iterator value="" id="">
                <option value=""><s:property value=""/></option>
            </s:iterator>
            </select>
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09F;">指派时间</td>
        <td><input name="" type="text"/><font color="#FF0000">*</font></td>
    </tr>
</table>
</form>
</body>
</html>