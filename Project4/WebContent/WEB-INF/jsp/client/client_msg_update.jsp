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
<form action="updateMsg" method="post">
<input type="button" value="关于"/>
<a><input type="button" value="联系人"/></a>
<a><input type="button" value="交往记录"/></a>
<a><input type="button" value="历史订单"/></a>
<input type="button" value="返回"/>
<input type="submit" value="保存"/>
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
            <select name="sell_chance.region.id">
                <option value='<s:property value="sell_chance.region.id"/>'><s:property value="sell_chance.region.value"/></option>
                <option>----</option>
                <s:iterator value="region_list" id="region">
                <option value='<s:property value="id"/>'><s:property value="value"/></option>
                </s:iterator>
            </select>
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09C;">负责人</td>
        <td><input name="sell_chance.charge" type="text" value='<s:property value="sell_chance.charge"/>'/><font color="#FF0000">*</font></td>
    </tr>
    <tr>
        <td style="background-color:#09C;">客户等级</td>
        <td>
            <select name="sell_chance.clinet_level.id">
                <option value='<s:property value="sell_chance.clinet_level.id"/>'><s:property value="sell_chance.clinet_level.value"/></option>
                <option>----------</option>
               <s:iterator value="client_level_list" id="client_level">
                   <option value='<s:property value="id"/>'><s:property value="value"/></option>
               </s:iterator>
            </select>
            <font color="#FF0000">*</font>
        </td>
        <td style="background-color:#09C;">客户信誉度</td>
        <td>
            <select name="client_msg.client_credit">
                <option value='<s:property value="client_msg.client_credit"/>'><s:property value="client_msg.client_credit"/></option>
                <option>--------</option>
                <option value="☆">☆</option>
                <option value="☆☆">☆☆</option>
                <option value="☆☆☆">☆☆☆</option>
                <option value="☆☆☆☆">☆☆☆☆</option>
                <option value="☆☆☆☆☆">☆☆☆☆☆</option>
            </select>
            <font color="#FF0000">*</font>
        </td>
    </tr>
    <tr>
        <td style="background-color:#09C;">客户满意度</td>
        <td>
            <select name="client_msg.client_satisfaction">
             <option value='<s:property value="client_msg.client_msg.client_satisfaction"/>'><s:property value="client_msg.client_msg.client_satisfaction"/></option>
                <option>--------</option>
                <option value="☆">☆</option>
                <option value="☆☆">☆☆</option>
                <option value="☆☆☆">☆☆☆</option>
                <option value="☆☆☆☆">☆☆☆☆</option>
                <option value="☆☆☆☆☆">☆☆☆☆☆</option>
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
    <td><input name="client_msg.address" type="text" value='<s:property value="client_msg.address"/>'/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;">邮政编码</td>
    <td><input name="client_msg.postalcode" type="text" value='<s:property value="client_msg.postalcode"/>'/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">电话</td>
    <td><input name="sell_chance.phone" type="text" value='<s:property value="sell_chance.phone"/>'/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;">传真</td>
    <td><input name="client_msg.fax" type="text" value='<s:property value="client_msg.fax"/>'/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">网址</td>
    <td><input name="client_msg.url" type="text" value='<s:property value="client_msg.url"/>'/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;"></td>
    <td></td>
</tr>
</table>

<table>
<tr> 
    <td style="background-color:#09C;">营业执照注册号</td>
    <td><input name="client_msg.business_license" type="text" value='<s:property value="client_msg.business_license"/>'/></td>
    <td style="background-color:#09C;">法人</td>
    <td><input name="client_msg.legal_man" type="text" value='<s:property value="client_msg.legal_man"/>'/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">注册资金(万元)</td>
    <td><input name="client_msg.registered_capital" type="text" value='<s:property value="client_msg.registered_capital"/>'/></td>
    <td style="background-color:#09C;">年营业额</td>
    <td><input name="client_msg.year_money" type="text" value='<s:property value="client_msg.year_money"/>'/></td>
</tr>
<tr>
    <td style="background-color:#09C;">开户银行</td>
    <td><input name="client_msg.deposit_bank" type="text" value='<s:property value="client_msg.deposit_bank"/>'/><font color="#FF0000">*</font></td>
    <td style="background-color:#09C;">银行账号</td>
    <td><input name="client_msg.bank_account" type="text" value='<s:property value="client_msg.bank_account"/>'/><font color="#FF0000">*</font></td>
</tr>
<tr>
    <td style="background-color:#09C;">地税登记号</td>
    <td><input name="client_msg.government_rent" type="text" value='<s:property value="client_msg.government_rent"/>'/></td>
    <td style="background-color:#09C;">国税登记号</td>
    <td><input name="client_msg.national_tax" type="text" value='<s:property value="client_msg.national_tax"/>'/></td>
</tr>
</table>
    <input name="sell_chance.chance_describe" type="hidden" value='<s:property value="sell_chance.chance_describe"/>'/>
    <input name="sell_chance.chance_from" type="hidden" value='<s:property value="sell_chance.chance_from"/>'/>
    <input name="sell_chance.odds" type="hidden" value='<s:property value="sell_chance.odds"/>'/>
    <input name="sell_chance.state" type="hidden" value='<s:property value="sell_chance.state"/>'/>
    <input name="sell_chance.summary" type="hidden" value='<s:property value="sell_chance.summary"/>'/>
    <input name="sell_chance.create_man.id" type="hidden" value='<s:property value="sell_chance.create_man.id"/>'/>
    <input name="sell_chance.clinet_manage.id" type="hidden" value='<s:property value="sell_chance.clinet_manage.id"/>'/>
</form>
</body>
</html>