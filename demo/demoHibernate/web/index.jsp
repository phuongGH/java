<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="themdanhmuc.jsp">them danh muc</a><br>
        <% DanhMucModel dmm = new DanhMucModel();%>
        <c:forEach var="dm" items="<%=dmm.danhsach()%>">
            * Ma danh muc: ${dm.madanhmuc} <br>
            * Ten danh muc: ${dm.tendanhmuc} <br>
            * <a href="DanhMucServlet?madanhmuc=${dm.madanhmuc}&action=xoa" onclick="return confirm('xat nhan xoa?')">Xoa</a> <br>
            ***************************************<br>
        </c:forEach>
    </body>
</html>
