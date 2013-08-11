<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							个人账号
						</div>
						<div class="pages">

<table>
    <tr>
        <td>用户名:</td>
        <td><input readonly type="text" id="manager1_name" name="user.name" value="${user.name}" onblur="notNullAndChar('manager1_name','nameErorr')" /><font color="#FF0000" style="display:none">*<div id="nameErorr"></div></font></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input readonly type="password" id="manager1_password" name="user.password" value="${user.password}" onblur="notNullAndChar('manager1_password','passErorr')" /><font color="#FF0000" style="display:none">*<div id="passErorr"></div></font></td>
    </tr>
</table>
        <input type="button"  id="manager1_set" value="编辑数据" onclick="manager1_setit()" style="display:block" />
        <input type="button"  id="manager1_save" value="保存数据" onclick="manager1_saveit()" style="display:none" />
        <input type="button"  id="manager1_back" value="返回" onclick="manager1_comeback()" style="display:none" />

	<script type="text/javascript">
		 name = document.getElementById("manager1_name").value;
		 password = document.getElementById("manager1_password").value;
    </script>
    
    
<jsp:include page="bady_bottom.jsp"/>
