<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/js.js"></script>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="body/Body_Top.jsp"/>
 <br/>
 <table width="100%">
     <tr>
         <td style="background-color:#00F; width:25%;" valign="top"><jsp:include page="body/Body_Button.jsp"/></td>
         <td style="width:75%;"><jsp:include page="body/Body_main.jsp"/></td>
     </tr>
 </table>
</body>
</html>