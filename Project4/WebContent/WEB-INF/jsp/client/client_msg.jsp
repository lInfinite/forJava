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
客户信息管理
<input type="button" value="关于" />
<input type="submit" value="查询" />
<table>
    <tr>
       <td style="background-color:#09F;">客户名称</td>
       <td><input name="" type="text" /></td>
       <td style="background-color:#09F;">客户编号</td>
       <td><input name="" type="text" /></td>
       <td style="background-color:#09F;">地区</td>
       <td>
           <select name="">
               <option>--请选择--</option>
           <s:iterator value="region_list" id="region">
               <option value='<s:property value="id"/>'><s:property value="value"/></option>
           </s:iterator>
           </select>
       </td>
    </tr>
    <tr>
       <td style="background-color:#09F;">客户经理/负责人</td>
       <td><input type="text" /></td>
       <td style="background-color:#09F;">客户等级</td>
       <td>
           <select name="">
               <option>--请选择--</option>
           <s:iterator value="client_level_list" id="client_level">
               <option value='<s:property value="id"/>'><s:property value="value"/></option>
           </s:iterator>
           </select>
       </td>
       <td style="background-color:#09F;"></td>
       <td></td>
    </tr>
</table>
<table>
    <tr>
        <td style="background-color:#03C; color:#FFF;">序号</td>
        <td style="background-color:#03C; color:#FFF;">客户名称</td>
        <td style="background-color:#03C; color:#FFF;">客户编号</td>
        <td style="background-color:#03C; color:#FFF;">地区</td>
        <td style="background-color:#03C; color:#FFF;">客户经理/负责人</td>
        <td style="background-color:#03C; color:#FFF;">客户等级</td>
        <td style="background-color:#03C; color:#FFF;">操作</td>
    </tr>
    
    <s:iterator value="sell_chance_list" id="sell_list">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="clinet_name"/></td>
        <td><s:property value="id"/></td>
        <td><s:property value="region.value"/></td>
        <td><s:property value="clinet_manage.name"/></td>
        <td><s:property value="clinet_level.value"/></td>
        <td>
            <a href='update_msg?sell_chance.id=<s:property value="id"/>'>［编辑］</a>
            <a>［联系人］</a>
            <a>［交往纪录］</a>
            <a>［历史订单］</a>
            <a>［删除］</a>
        </td>
    </tr>
    </s:iterator>
    
</table>
</body>
</html>
