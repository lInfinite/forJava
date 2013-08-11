<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							管理账户
						</div>
						<div class="pages">

<table style="width:500px;">
    <tr>
        <td width="15%">用户名</td>
        <td width="15%">昵称</td>
        <td width="30%">手机</td>
        <td width="40%">地址</td>
    </tr>
    <s:iterator value="user_list" id="user_list">
        <tr>
	        <td width="15%">[<s:property value="name"/>]</td>
	        <td width="15%">[<s:property value="names"/>]</td>
	        <td width="30%">[<s:property value="phone"/>]</td>
	        <td width="40%">[<s:property value="address"/>]</td>
        </tr>
    </s:iterator>
    <tr>
   
        <td width="15%"><a href="user_pageSelect?page=<s:property value="backPage"/>">上一页</a></td>
        <td width="15%"><a href="user_pageSelect?page=<s:property value="goPage"/>">下一页</a></td>
        <td width="30%"></td>
        <td width="40%"></td>
    </tr>
</table>

<a href="manager3.jsp"><input type="button" id="but" name="but" value="添加数据" /></a>
    
<jsp:include page="bady_bottom.jsp"/>
