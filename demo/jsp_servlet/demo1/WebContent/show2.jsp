<%@ page isELIgnored="false" %>
<%@ page import="demo.models.Image" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="/common/header.jsp" %> --%>
	<%! String name = "aaaaa"; %>
	<jsp:include page="/common/header.jsp">
		<jsp:param value="<%= name %>" name="param1"/>
	</jsp:include>
	
	
	<%-- The image name is: <%= request.getAttribute("imageName") %>  --%>
	<br/>
	image mane: <%= ((Image)request.getAttribute("imageName")).get_name() %>
	<br/>
	<img alt="image" src="images/kitty.jpg">
	<br/>
	<% pageContext.setAttribute("scope", "Page context"); %>
	Scope of the attribute : <%= pageContext.getAttribute("scope") %>
	<br/>
	Scope of the attribute 2 : ${pageScope.scope }
	<br/>
	Scope of the attribute : <%= pageContext.findAttribute("scope1") %>
	<br/>
	Scope of the attribute : <%= pageContext.getAttribute("scope1", pageContext.APPLICATION_SCOPE) %>
	<br/>
	<%-- student Name : ${requestScope.student.name } --%>
	<br/>
	student Name 2:
	
	
	 <jsp:useBean id="student" class="demo.models.student" scope="request"></jsp:useBean> 
	<jsp:setProperty property="name" name="student" value="bbbbbb"/>
	infor: <jsp:getProperty property="name" name="student"/> 
	<br/>
	parameter : <%= application.getInitParameter("connection_str") %>
	<br/>
	parameter 2 : ${initParam.connection_str }
	<br/>
	<%-- Scope of the attribute : <%= pageContext.getAttribute("languages") %> --%>
	 ${requestScope.languages[1] }
	
	<%-- Scope of the attribute : <%= pageContext.getAttribute("scope1") %> --%>
</body>
</html>