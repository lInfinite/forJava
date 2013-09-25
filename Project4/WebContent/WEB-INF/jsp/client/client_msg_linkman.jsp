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
客户信息管理>客户信息>联系人<br/>
<input type="button" value="关于"/>
<a href='create_linkman?sell_chance.id=<s:property value="sell_chance.id"/>'><input type="button" value="新建"/></a>
<input type="button" value="返回"/>
<!--client_msg_linkman_input.html-->

<table style="width:100%;">
   <tr>
       <td style="background-color:#06F; color:#FFF;">姓名</td>
       <td style="background-color:#06F; color:#FFF;">性别</td>
       <td style="background-color:#06F; color:#FFF;">职位</td>
       <td style="background-color:#06F; color:#FFF;">办公电话</td>
       <td style="background-color:#06F; color:#FFF;">手机</td>
       <td style="background-color:#06F; color:#FFF;">备注</td>
       <td style="background-color:#06F; color:#FFF;">操作</td>
   </tr>
   
   <s:iterator value="link_man_list" id="link_man">
   <tr>
       <td><s:property value="name"/></td>
       <td><s:property value="sex"/></td>
       <td><s:property value="position"/></td>
       <td><s:property value="call"/></td>
       <td><s:property value="phone"/></td>
       <td><s:property value="remarks"/></td>
       <td>
           <a href='update_linkman?linkman.id=<s:property value="id"/>&&sell_chance.id=<s:property value="sell_chance.id"/>'>[编辑]</a>
           <a href='delteLinkman?linkman.id=<s:property value="id"/>'>[删除]</a>
       </td>
   </tr>
   </s:iterator>
</table>
</body>
</html>
