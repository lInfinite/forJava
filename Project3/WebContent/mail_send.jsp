<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>

  <div class="action">
						<div class="t">
							发送邮件
						</div>
						<div class="pages">

<form action="mail_sendMail" method="post" enctype="multipart/form-data">
<font color="#FF0000"><s:actionmessage/></font>
<table>
    <tr>
        <td>收件人:</td>
        <td>
            <select name="mail.read_id">
            <s:iterator value="user_list" id="user_list">
               <option value='<s:property value="id"/>'><s:property value="name"/></option>
            </s:iterator>
            </select>
        </td>
    </tr>
    <tr>
        <td>邮件标题:</td>
        <td>
            <input id="title" name="mail.title" type="text" / ><font color="#FF0000">*<s:fielderror><s:param>TitleErorr</s:param></s:fielderror></font>
        </td>
    </tr>
    <tr>
        <td>邮件内容:</td>
        <td>
            <textarea id="text" name="mail.text"></textarea>
        </td>
    </tr>
    <tr>
        <td>上传附件:</td>
        <td>
            <input id="file" name="upload" type="file" /> <font color="#FF0000">*</font>(上传最大不能超过9M)
        </td>
    </tr>
</table>
<input type="hidden" name="mail.send_id" value="${session.user.id}" />
<input type="hidden" name="mail.send_name" value="${session.user.names}" />
            <input type="submit" value="发送邮件" id="submit"  />
</form>
 
    
<jsp:include page="bady_bottom.jsp"/>
