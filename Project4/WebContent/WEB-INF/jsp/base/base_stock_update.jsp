<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.title_td{color:#FFF; background-color:#00F; width:7%; text-align:center;}
</style>
<body>
库存添加
<form action="" method="post">
<input type="button" value="返回"/>
<input type="submit" value="保存"/>
<table style="width:100%;">
    <tr>
        <td class="title_td">编号</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td class="title_td">产品</td>
        <td>
            <select name="">
                <option value=""></option>
            </select>
        </td>
        <td class="title_td">仓库</td>
        <td><input name="" type="text" value=""/></td>
    </tr>
    <tr>
        <td class="title_td">货位</td>
        <td><input name="" type="text" value=""/></td>
        <td class="title_td">件数</td>
        <td><input name="" type="text" value=""/></td>
    </tr>  
    <tr>
        <td class="title_td">备注</td>
        <td colspan="3">
        <textarea style="width:100%; height:200px;"></textarea>
        </td>
    </tr>
</table>
</form>
</body>
</html>