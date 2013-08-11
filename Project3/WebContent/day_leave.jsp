<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
<script>
    date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDay();
	window.onload=function(){
	    document.getElementById("days_topTime").value = year+"-"+month+"-"+day;
	    document.getElementById("days_endTime").value = year+"-"+month+"-"+day;
	}
</script>
  <div class="action">
						<div class="t">
							休假申请
						</div>
						<div class="pages">
                        
<form action="days_saveleave" method="post" onsubmit="return submit_4('days_name','days_topTime','days_endTime','days_days')">
<table>
    <tr>
    <td>姓名:</td>
    <td><input type="text" name="days.name" id="days_name" onblur="notNullAndChar('days_name','nameErorr')" /></td>
    <td><font id="nameErorr" style="color:#F00; font-size:10px;"><s:fielderror><s:param>NameErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
    <td>开始时间:</td>
    <td><input type="text" name="days.topTime" id="days_topTime" onblur="checkTime('days_topTime','topErorr')" /></td>
    <td><font id="topErorr" style="color:#F00; font-size:10px;"><s:fielderror><s:param>TopTimeErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
    <td>结束时间:</td>
    <td><input type="text" name="days.endTime" id="days_endTime" onblur="checkTime('dats_endTime','endErorr')" /></td>
    <td><font id="endErorr" style="color:#F00; font-size:10px;"><s:fielderror><s:param>EndTimeErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
    <td>请假天数:</td>
    <td><input type="text" name="days.days" id="days_days" onblur="number('dyas_days','daysErorr')" /></td>
    <td><font id="dyasErorr" style="color:#F00; font-size:10px;"><s:fielderror><s:param>DaysErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
    <td>请假原因:</td>
    <td>
        <textarea name="days.cause">
        </textarea>
    </td>
    </tr>
    <tr>
    <td>申请人:</td>
    <td>
        <select name="days.read_id">
            <s:iterator value="user_list" id="user_list">
               <option value='<s:property value="id"/>'><s:property value="name"/></option>
            </s:iterator>
        </select>
    </td>
    </tr>
</table>
<input type="hidden" name="days.name_id" value="${session.user.id}" />
<input type="submit" value="提交" />
</form>
    
    
<jsp:include page="bady_bottom.jsp"/>
