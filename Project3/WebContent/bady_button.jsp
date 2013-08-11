<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="nav" id="nav">
					<div class="t"></div>
					<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理 
						</dt>
						<dd>
							<a href="user_msg.jsp" target="_parent">个人信息</a>
						</dd>
					</dl>
					<dl>
						<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							邮件管理
						</dt>
						<dd>
							<a href="mail_send?userId=${session.user.id }" target="_parent">写邮件</a>
						</dd>
						<dd>
							<a href="mail_check?userId=${session.user.id }" target="_parent">收邮件</a>
						</dd>
						<dd>
							<a href="mail_maildelete?userId=${session.user.id }" target="_parent">垃圾邮件</a>
						</dd>
					</dl>
					<dl>
						<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							考勤管理
						</dt>
						<dd>
							<a href="days_gotoday?read_id=${session.user.id }" target="_parent">休假</a>
						</dd>
					</dl>
					
					<dl >
					
						<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							权限管理
						</dt>
						<dd>
							<a href="user_manager1.jsp" target="_parent">个人账户</a>
						</dd>
						<dd>
							<a href="user_pageSelect" target="_parent">管理账户</a>
						</dd>
						
					</dl>
	</div>
	        
