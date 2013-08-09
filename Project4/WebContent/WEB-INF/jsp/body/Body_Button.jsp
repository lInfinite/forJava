<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<dl style="background-color:#00F; color:#FFF; width:250px;">
   <dt><a href="#" onClick="showButton(['system_main'])">客户关系管理系统</a></dt>
       <dd id="system_main">
           <dl>
           <dt><a href="#" onclick="showButton(['sell_chance','sell_develop'])">营销管理</a></dt>
               <dd id="sell_chance"><a href="#">销售机会管理</a></dd>
               <dd id="sell_develop"><a href="#">客户开发计划</a></dd>
           <dt><a href="#" onclick="showButton(['client_msg','client_runaway'])">客户管理</a></dt>
               <dd id="client_msg"><a href="#">客户信息管理</a></dd>
               <dd id="client_runaway"><a href="#">客户流失管理</a></dd>
           <dt><a href="#" onclick="showButton(['service_create','service_allocation','service_handle','service_feedback','service_archive'])">服务管理</a></dt>
               <dd id="service_create"><a href="#">服务创建</a></dd>
               <dd id="service_allocation"><a href="#">服务分配</a></dd>
               <dd id="service_handle"><a href="#">服务处理</a></dd>
               <dd id="service_feedback"><a href="#">服务反馈</a></dd>
               <dd id="service_archive"><a href="#">服务归档</a></dd>
           <dt><a href="#" onclick="showButton(['statistik_client_contribution','statistik_client_constitute','statistik_client_service','statistik_client_runaway'])">统计报表</a></dt>
               <dd id="statistik_client_contribution"><a href="#">客户贡献分析</a></dd>
               <dd id="statistik_client_constitute"><a href="#">客户构成分析</a></dd>
               <dd id="statistik_client_service"><a href="#">客户服务分析</a></dd>
               <dd id="statistik_client_runaway"><a href="#">客户流失分析</a></dd>
           <dt><a href="#" onclick="showButton(['base_client_level','base_service_type','base_client_region','base_query_product','base_query_storage'])">基础管理</a></dt>
               <dd id="base_client_level"><a href="#">客户等级管理</a></dd>
               <dd id="base_service_type"><a href="#">服务类型管理</a></dd>
               <dd id="base_client_region"><a href="#">客户地区管理</a></dd>
               <dd id="base_product_query"><a href="#">查询产品信息</a></dd>
               <dd id="base_storage_query"><a href="#">查询仓库</a></dd>
           <dt><a href="#" onclick="showButton(['privilege_user','privilege_role'])">权限管理</a></dt>
               <dd id="privilege_user"><a href="#">用户管理</a></dd>
               <dd id="privilege_role"><a href="#">角色管理</a></dd>
       </dl>
       </dd>
</dl>