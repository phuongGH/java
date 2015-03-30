<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="entities.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table Manager</title>
    </head>
    <body>
        <%@include file="common/header.jsp" %>
        <h1>Table Manager</h1><br>
        <form:form method="post" commandName="tableObj" action="addTable.html">
            Mã Bàn: <form:input path="tableId"/><br>
            Loại bàn: 

            <form:select path="categorizetable.categorizeTableId">
                <form:options items="${listCategorizeTable}" itemValue="categorizeTableId" 
                              itemLabel="categorizeTableName"/>
            </form:select>
            <br>
            Số người đa: <form:input path="maxPerson"/><br>
            <input type="submit" value="Save"/><br> 
        </form:form>

        ${result}
        
        <table BORDER=1 CELLPADDING=0 CELLSPA0>
            <tr>
                <td >Mã Bàn</td>
                <td>Số người tối đa</td>
                <td>Loại bàn</td>
                <td>Sua</td>
                <td>Xoa</td>
            </tr>
            <c:forEach var="t" items="${listTable}">    
                <form:form method="post"  commandName="tableObj"  action="edittable.html">
                    <tr>
                        <td><form:input path="tableId" value="${t.getTableId()}"/> </td>
                        <td><form:input path="maxPerson" value="${t.getMaxPerson()}"/></td>
                        <td>
                            <form:select  path="categorizetable.categorizeTableId">
                                <c:forEach var="cate" items="${listCategorizeTable}">
                                    <c:choose>
                                        <c:when test="${(t.getCategorizetable()).getCategorizeTableId() eq cate.categorizeTableId}">
                                    <option value="${cate.categorizeTableId}" selected="true">${cate.categorizeTableName}</option>
                                </c:when >
                                <c:otherwise>
                                    <option value="${cate.categorizeTableId}" >${cate.categorizeTableName}</option>
                                </c:otherwise>

                            </c:choose>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <input type="submit" name="submit" value="update" 
                           onclick="return confirm('are you sure update \n table ${t.getTableId()}')" />
                </td>
                <td>
                    <input type="submit" name="submit" value="delete" 
                           onclick="return confirm('are you sure delete table ${t.getTableId()}')" />
                </td>
            </tr>
        </form:form>
    </c:forEach>
</table>

</body>
</html>
