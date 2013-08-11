<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="bady_Top.jsp"/>
<jsp:include page="bady_button.jsp"/>
  <div class="action">
						<div class="t">
							添加用户
						</div>
						<div class="pages">

<form action="user_login" method="post" onsubmit="return submit_5('user.name','user.password','user.names','user.age','user.phone')">
<table>

    <tr>
        <td>用户名:</td>
        <td><input type="text" name="user.name" id="user.name" onblur="notNullAndChar('user.name','nameErorr')"/><font id="nameErorr" color="#FF0000">*<s:fielderror><s:param>NameErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input type="password" name="user.password" id="user.password" onblur="notNullAndChar('user.password','passErorr')"/><font id="passErorr" color="#FF0000">*<s:fielderror><s:param>PasswordErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
        <td>昵称:</td>
        <td><input type="text" name="user.names" id="user.names" onblur="notNullAndChar('user.names','namesErorr')"/><font id="namesErorr" color="#FF0000">*<s:fielderror><s:param>NamesErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
        <td>年龄:</td>
        <td><input type="text" name="user.age" id="user.age" onblur="age('user.age','ageErorr')"/><font id="ageErorr" color="#FF0000"></font></td>
    </tr>
    <tr>
        <td>用户名:</td>
        <td>
            <select name="user.sex" id="user.sex">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>手机:</td>
        <td><input name="user.phone" id="user.phone" type="text" onblur="phone('user.phone','phoneErorr')" /><font id="phoneErorr" color="#FF0000">*<s:fielderror><s:param>PhoneErorr</s:param></s:fielderror></font></td>
    </tr>
    <tr>
        <td>地址:</td>
        <td><input name="user.address" id="user.address" type="text" /></td>
    </tr>
</table>
<input type="submit" value="保存数据" />
<a href="user_pageSelect"><input type="button" value="返回" /></a>
</form>
    
    
<jsp:include page="bady_bottom.jsp"/>