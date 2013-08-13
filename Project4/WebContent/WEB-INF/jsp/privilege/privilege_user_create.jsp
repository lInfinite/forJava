<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>

<body>
用户管理>添加用户<br/>
<form action="" method="post">
<input type="button" value="关于"/>
<input type="button" value="返回"/>
<input type="submit" value="保存"/>
<table>
    <tr>
        <td>用户名</td>
        <td><input name="user.name" type="text"/></td>
        <td>角色</td>
        <td>
            <select name="user.role.id">
            <s:iterator value="role_list" id="role_list">
                <option value='<s:property value="id"/>'><s:property value="name"/></option>
            </s:iterator>
            </select>
        </td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input name="user.password" id="user_password" type="text"/></td>
        <td>确认密码</td>
        <td><input id="user_password2" type="text" onBlur="check_pw('user_password', 'user_password2')"/></td>
    </tr>
</table>
</form>
</body>
<script>
    function check_pw(pw1, pw2){
		var p1 = document.getElementById(pw1).value;
		var p2 = document.getElementById(pw2).value;
		if(p1==p2){
		    return true;
		}else{
			alert("密码不匹配");
		    return false;
			
		}
	}
</script>
</html>