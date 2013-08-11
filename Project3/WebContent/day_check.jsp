<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							休假审批
						</div>
						<div class="pages">

<form action="days_changeStatus" method="post">
<table>
    <tr>
    <td>姓名:</td>
    <td><input readonly type="text" value="<s:property value="days.name"/>" /></td>
    </tr>
    <tr>
    <td>开始时间:</td>
    <td><s:property value="days.topTime"/> </td>
    </tr>
    <tr>
    <td>结束时间:</td>
    <td><s:property value="days.endTime"/> </td>
    </tr>
    <tr>
    <td>请假天数:</td>
    <td><input readonly type="text" value="<s:property value="days.days"/>" /></td>
    </tr>
    <tr>
    <td>请假原因:</td>
    <td>
        <textarea>
        <s:property value="days.name"/>
        </textarea>
    </td>
    </tr>
    <tr>
    <td>申请人:</td>
    <td><input readonly type="text" value="<s:property value="days.name"/>" /></td>
    </tr>
</table>
<input name="day_submit" type="submit" value="审批通过" />
<input name="day_submit" type="submit" value="审批不通过" />
</form>
    
    
<jsp:include page="bady_bottom.jsp"/>
