<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							个人信息
						</div>
						<div class="pages">

    
         <table width="90%" border="0" cellspacing="0" cellpadding="0">
                <tr >
                    <td align="right" width="30%">昵称：</td>
                    <td align="left"><input type="text" name="u.nickname" value="${session.user.names}" readonly="true" id="msg_name" onblur="notNullAndChar('msg_name','nameErorr')"/></td>
                    <td id="nameErorr"></td>
                </tr>
                <tr >
                    <td align="right" width="30%">年龄：</td>
                    <td align="left"><input type="text" name="u.age" value="${session.user.age}" readonly="true" id="msg_age" onblur="age('msg_age','ageErorr')"/></td>
                    <td id="ageErorr"></td>
                </tr>
                <tr >
                    <td align="right" width="30%">性别：</td>
                    <td align="left">
                        <input type="text" name="u.sex" value="${session.user.sex}" readonly="true" id="msg_sex" onblur="sex('msg_sex','sexErorr')"/>
                    </td>
                    <td id="sexErorr"></td>
                </tr>
                <tr >
                    <td align="right" width="30%">手机：</td>
                    <td align="left"><input type="text" name="u.phone" value="${session.user.phone}" readonly="true" id="msg_phone" onblur="phone('msg_phone','phoneErorr')"/></td>
                    <td id="phoneErorr"></td>
                </tr>
                <tr >
                    <td align="right" width="30%">地址：</td>
                    <td align="left"><input type="text" name="u.address" value="${session.user.address}" readonly id="msg_address"/></td>
                    <td id="addressErorr"></td>
                </tr>
                <tr >
                    <td align="center" colspan="2">
                    <br/>
                    <input type="button"  id="msg_set" value="编辑数据" onclick="msg_setit()" style="display:block" />
                    <input type="button"  id="msg_save" value="保存数据" onclick="msg_saveit()" style="display:none" />
                    <input type="button"  id="msg_back" value="返回" onclick="msg_comeback()" style="display:none" />
                    </td>
                </tr>
		</table>
	<script type="text/javascript">
		 name = document.getElementById("msg_name").value;
		 age = document.getElementById("msg_age").value;
		 sex =  document.getElementById("msg_sex").value;
		 phone = document.getElementById("msg_phone").value;
		 address =  document.getElementById("msg_address").value;
    </script>
    
    
<jsp:include page="bady_bottom.jsp"/>