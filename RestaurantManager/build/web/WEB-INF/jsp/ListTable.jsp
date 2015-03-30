<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="post" commandName="tableObj" action="addTable.html">
            Mã Bàn: <form:input path="tableId"/><br>
            Loại bàn: 

            <form:select path="categorizetable">
            <form:options items="${listCategorizeTable}" itemValue="categorizeTableId" itemLabel="categorizeTableId"/>
        </form:select>
        <br>
        Số người tối đa: <form:input path="maxPerson"/><br>
        <input type="submit" value="Save"/><br> 
    </form:form>
    <table BORDER=1 CELLPADDING=0 CELLSPACING=0>
        <tr>
            <td >Mã Bàn</td>
            <td>Số người tối đa</td>
            <td>Loại bàn</td>
            <td>Sua</td>
            <td>Xoa</td>
        </tr>

        <c:forEach var="t" items="${listTable}">    
            <tr>
                <td>${t.getTableId()}</td>
                <td>${t.getMaxPerson()}</td>
                <td>${(t.getCategorizetable()).getCategorizeTableId()}</td>
                <td>Sua</td>
                <td><a href="<%= request.getContextPath()%>/table/deletetable.html" onclick="return confirm('Are you sure?')" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
