<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All print requests</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>Ip Address</th>
        <th>Branch Code</th>
        <th>Personnel Code</th>
        <th>Card PAN</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${prints}" var="print">
        <tr>
            <td>${print.printId.ipAddress}</td>
            <td>${print.printId.branchCode}</td>
            <td>${print.personnelCode}</td>
            <td>${print.cardPAN}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<c:url var="add_print_url" value="/view/add"/>
<form:form action="${add_print_url}" method="get">
    <input type="submit" value="Add more!"/>
</form:form>
</body>
</html>