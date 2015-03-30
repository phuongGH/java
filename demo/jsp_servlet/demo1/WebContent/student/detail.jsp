<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student"  class="demo.models.student" >
	<jsp:setProperty property="name" name="student" param="txtname"/>
	</jsp:useBean> 
	infor: <jsp:getProperty property="name" name="student"/> 
	student name: <%= request.getParameter("txtname") %>
	<br/>
	Region: <%= request.getParameter("region") %>
	<br/>
	student name 2: ${param.txtname }
	<br/>
	Region 2: ${param.region }
</body>
</html>