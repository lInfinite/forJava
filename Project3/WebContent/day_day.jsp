<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							休假
						</div>
						<div class="pages">

  <table style="width:600px;">
        <tr>
            <td style="width:10%; height:15px;">申请人</td>
            <td style="width:15%; height:15px;">开始时间</td>
            <td style="width:15%; height:15px;">结束时间</td>
            <td style="width:12%; height:15px;">天数</td>
            <td style="width:13%; height:15px;">审批状态</td>
            <td style="width:15%; height:15px;">原因</td>
            <td style="width:20%; height:15px;">操作</td>
        </tr>
        
    <s:iterator value="days_list" id="days_list">
        <tr>
            <td style="width:10%; height:15px;"><s:property value="name"/></td>
            <td style="width:15%; height:15px;"><s:property value="topTime"/></td>
            <td style="width:15%; height:15px;"><s:property value="endTime"/></td>
            <td style="width:12%; height:15px;"><s:property value="days"/></td>
            <td style="width:13%; height:15px;"><s:property value="status"/></td>
            <td style="width:15%; height:15px;"><s:property value="cause"/></td>
            <td style="width:20%; height:15px;"><a href="days_check?day_id=<s:property value="id"/>">[审核]</a></td>
        </tr>
    </s:iterator>
    
         <tr>
            <td style="width:10%; height:15px;"><a href="days_gotoday?page=<s:property value="backPage"/>">上一页</a></td>
            <td style="width:15%; height:15px;"><a href="days_gotoday?page=<s:property value="goPage"/>">下一页</a></td>
            <td style="width:15%; height:15px;"></td>
            <td style="width:12%; height:15px;"></td>
            <td style="width:13%; height:15px;"></td>
            <td style="width:15%; height:15px;"></td>
            <td style="width:20%; height:15px;"></td>
        </tr>
    </table>

<a href="days_gotoleave"><input type="button" value="申请休假" id="but" name="but" /></a>
    
    
<jsp:include page="bady_bottom.jsp"/>
