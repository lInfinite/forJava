<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							读取邮件
						</div>
						<div class="pages">

<table>
    <tr>
        <td>邮件标题:</td>
        <td>
            <input id="title" name="title" type="text" value="<s:property value="mail.title"/>" readonly / >
        </td>
    </tr>
    <tr>
        <td>邮件内容:</td>
        <td>
            <textarea id="text" name="text" readonly>
            <s:property value="mail.text"/>
            </textarea>
        </td>
    </tr>
      <tr>
        <td>发布时间:</td>
        <td>
            <s:property value=""/>
        </td>
    </tr>
    <tr>
        <td>来自:</td>
        <td>
            <input id="title" name="title" type="text" value="<s:property value="mail.send_name"/>" readonly / >
        </td>
    </tr>
     <tr>
        <td>文件:</td>
        <td>
            <a href="mail_download?mail_id=<s:property value="mail.id" />">下载</a>
        </td>
    </tr>
</table>
    
    
<jsp:include page="bady_bottom.jsp"/>