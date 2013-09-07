<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<dl style="color:#FFF; width:250px;">
   <dt><a onClick="showButton(['system_main'])">客户关系管理系统</a></dt>
       <dd id="system_main">
           <dl>
           <dt><a onclick="showButton(['sell_chance','sell_develop'])">营销管理</a></dt>
               <dd id="sell_chance"><a href="<%=request.getContextPath() %>/sell/sell_chance" target="body_main">销售机会管理</a></dd>
               <dd id="sell_develop"><a href="<%=request.getContextPath() %>/sell/client" target="body_main">客户开发计划</a></dd>
           <dt><a onclick="showButton(['client_msg','client_runaway'])">客户管理</a></dt>
               <dd id="client_msg"><a href="<%=request.getContextPath() %>/client/msg" target="body_main">客户信息管理</a></dd>
               <dd id="client_runaway"><a href="#" target="body_main">客户流失管理</a></dd>
           <dt><a onclick="showButton(['service_create','service_allocation','service_handle','service_feedback','service_archive'])">服务管理</a></dt>
               <dd id="service_create"><a href="#" target="body_main">服务创建</a></dd>
               <dd id="service_allocation"><a href="#" target="body_main">服务分配</a></dd>
               <dd id="service_handle"><a href="#" target="body_main">服务处理</a></dd>
               <dd id="service_feedback"><a href="#" target="body_main">服务反馈</a></dd>
               <dd id="service_archive"><a href="#" target="body_main">服务归档</a></dd>
           <dt><a onclick="showButton(['statistik_client_contribution','statistik_client_constitute','statistik_client_service','statistik_client_runaway'])">统计报表</a></dt>
               <dd id="statistik_client_contribution"><a href="#" target="body_main">客户贡献分析</a></dd>
               <dd id="statistik_client_constitute"><a href="#" target="body_main">客户构成分析</a></dd>
               <dd id="statistik_client_service"><a href="#" target="body_main">客户服务分析</a></dd>
               <dd id="statistik_client_runaway"><a href="#" target="body_main">客户流失分析</a></dd>
           <dt><a onclick="showButton(['base_client_level','base_service_type','base_client_region','base_product','base_stock'])">基础管理</a></dt>
               <dd id="base_client_level"><a href="<%=request.getContextPath() %>/base/clintlevel" target="body_main">客户等级管理</a></dd>
               <dd id="base_service_type"><a href="<%=request.getContextPath() %>/base/service_type" target="body_main">服务类型管理</a></dd>
               <dd id="base_client_region"><a href="<%=request.getContextPath() %>/base/region" target="body_main">客户地区管理</a></dd>
               <dd id="base_product"><a href="<%=request.getContextPath() %>/base/product" target="body_main">查询产品信息</a></dd>
               <dd id="base_stock"><a href="<%=request.getContextPath() %>/base/stock" target="body_main">查询仓库</a></dd>
           <dt><a onclick="showButton(['privilege_user','privilege_role'])">权限管理</a></dt>
               <dd id="privilege_user"><a href="<%=request.getContextPath() %>/user/user_manage" target="body_main">用户管理</a></dd>
               <dd id="privilege_role"><a href="<%=request.getContextPath() %>/user/role_manage" target="body_main">角色管理</a></dd>
       </dl>
       </dd>
</dl>