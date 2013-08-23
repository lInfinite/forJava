<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<script type="text/javascript" src="/Project4/js/js.js"></script>
</head>

<body>
角色管理>编辑角色<br/>
<form action="updateRole" method="post">
<input type="button" value="关于"/>
<input type="button" value="返回"/>
<input type="submit" value="保存"/>
<table>
    <tr>
        <td style="background-color:#00F; color:#FFF">编号</td>
        <td>
            <s:property value="role.id"/>
            <input name="role.id" type="hidden" value='<s:property value="role.id"/>'/>
        </td>
        <td style="background-color:#00F; color:#FFF">角色名</td>
        <td><input name="role.name" type="text" value='<s:property value="role.name"/>' /></td>
    </tr>
    <tr>
        <td style="background-color:#00F; color:#FFF">
        指定权限
        </td>
        <td colspan="3">
                    <dl id="checkboxes">
           <dt>营销管理
               <input onChange="handelCheckbox(['sell_chance_checkbox','sell_develop_checkbox'])" type="checkbox"/></dt>
                   <dd>销售机会管理<input id="sell_chance_checkbox" name="Manages_name" value="销售机会管理" type="checkbox"/></dd>
                   <dd>客户开发计划<input id="sell_develop_checkbox" name="Manages_name" value="客户开发计划" type="checkbox"/></dd>
           <dt>客户管理
               <input onChange="handelCheckbox(['client_msg_checkbox','client_runaway_checkbox'])" type="checkbox"/></dt>
                   <dd>客户信息管理<input id="client_msg_checkbox" name="Manages_name" value="客户信息管理" type="checkbox"/></dd>
                   <dd>客户流失管理<input id="client_runaway_checkbox" name="Manages_name" value="客户流失管理" type="checkbox"/></dd>
           <dt>服务管理
               <input onChange="handelCheckbox(['service_create_checkbox','service_allocation_checkbox','service_handle_checkbox','service_feedback_checkbox','service_archive_checkbox'])" value="" type="checkbox"/></dt>
                   <dd>服务创建<input id="service_create_checkbox" name="Manages_name" value="服务创建" type="checkbox"/></dd>
                   <dd>服务分配<input id="service_allocation_checkbox" name="Manages_name" value="服务分配" type="checkbox"/></dd>
                   <dd>服务处理<input id="service_handle_checkbox" name="Manages_name" value="服务处理" type="checkbox"/></dd>
                   <dd>服务反馈<input id="service_feedback_checkbox" name="Manages_name" value="服务反馈" type="checkbox"/></dd>
                   <dd>服务归档<input id="service_archive_checkbox" name="Manages_name" value="服务归档" type="checkbox"/></dd>
           <dt>统计报表
               <input onChange="handelCheckbox(['statistik_client_contribution_checkbox','statistik_client_constitute_checkbox','statistik_client_service_checkbox','statistik_client_runaway_checkbox'])" value="" type="checkbox"/></dt>
                   <dd>客户贡献分析<input id="statistik_client_contribution_checkbox" name="Manages_name" value="客户贡献分析" type="checkbox"/></dd>
                   <dd>客户构成分析<input id="statistik_client_constitute_checkbox" name="Manages_name" value="客户构成分析" type="checkbox"/></dd>
                   <dd>客户服务分析<input id="statistik_client_service_checkbox" name="Manages_name" value="客户服务分析" type="checkbox"/></dd>
                   <dd>客户流失分析<input id="statistik_client_runaway_checkbox" name="Manages_name" value="客户流失分析" type="checkbox"/></dd>
           <dt>基础管理
               <input onChange="handelCheckbox(['base_client_level_checkbox','base_service_type_checkbox','base_client_region_checkbox','base_product_query_checkbox','base_storage_query_checkbox'])" value="" type="checkbox"/></dt>
                   <dd>客户等级管理<input id="base_client_level_checkbox" name="Manages_name" value="客户等级管理" type="checkbox"/></dd>
                   <dd>服务类型管理<input id="base_service_type_checkbox" name="Manages_name" value="服务类型管理" type="checkbox"/></dd>
                   <dd>客户地区管理<input id="base_client_region_checkbox" name="Manages_name" value="客户地区管理" type="checkbox"/></dd>
                   <dd>查询产品信息<input id="base_product_query_checkbox" name="Manages_name" value="查询产品信息" type="checkbox"/></dd>
                   <dd>查询仓库<input id="base_storage_query_checkbox" name="Manages_name" value="查询仓库" type="checkbox"/></dd>
           <dt>权限管理
               <input onChange="handelCheckbox(['privilege_user_checkbox','privilege_role_checkbox'])" value="" type="checkbox"/></dt>
                   <dd>用户管理<input id="privilege_user_checkbox" name="Manages_name" value="用户管理" type="checkbox"/></dd>
                   <dd>角色管理<input id="privilege_role_checkbox" name="Manages_name" value="角色管理" type="checkbox"/></dd>
       </dl>
        </td>
    </tr>
    <tr>
        <td></td>
        <td colspan="3">
        <input id="allTrue" type="button" value="全选" onclick="checkedAll('checkboxes','allTrue')" />
        <input id="allFalse" type="button" value="全不选" onclick="checkedAll('checkboxes','allFalse')" /></td>
    </tr>
</table>
</form>
</body>
</html>