<%@page import="java.sql.Clob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							收信箱
                        </div>
						<div class="pages">

    <table style="width:600px;">
        <tr>
            <td style="width:15%; height:15px;">邮件标题</td>
            <td style="width:30%; height:15px;">内容</td>
            <td style="width:15%; height:15px;">是否已读</td>
            <td style="width:20%; height:15px;">时间</td>
            <td style="width:20%; height:15px;">操作</td>
        </tr>

	     <s:iterator value="mail_check" id="mail_check">
	         <tr onmouseover="this.style.background='#999'" onmouseout="this.style.background='#fff'" onclick="location.href='mail_one?mail_id=<s:property value="id"/>'"/>
	            <td style="width:15%; height:15px;"><s:property value="title"/></td>
	            <td style="width:30%; height:15px;"><s:property value="text"/></td>
	            <td style="width:15%; height:15px;"><s:property value="read"/></td>
	            <td style="width:20%; height:15px;"><s:property value="time"/></td>
	            <td style="width:20%; height:15px;"><a href='mail_dele?mail_id=<s:property value="id" />&dele=1'>删除</a></td>
	        </tr>
	    </s:iterator>
	    
        <tr>
            <td style="width:15%; height:15px;"><a href="mail_check?page=<s:property value="backPage"/>">上一页</a></td>
            <td style="width:30%; height:15px;"><a href="mail_check?page=<s:property value="goPage"/>">下一页</a></td>
            <td style="width:15%; height:15px;"></td>
            <td style="width:20%; height:15px;"></td>
            <td style="width:20%; height:15px;"></td>
        </tr>
	    
    </table>
    
    
<jsp:include page="bady_bottom.jsp"/>