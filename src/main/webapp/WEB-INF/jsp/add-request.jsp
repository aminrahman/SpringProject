<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add print request</title>
</head>
<body>
<h2>Add print request</h2>

<br>
<c:url var="add_print_url" value="/view/add"/>
<form:form action="${add_print_url}" method="post" modelAttribute="print">
    <form:label path="printId.ipAddress">Ip Address: </form:label> <form:input type="text" path="printId.ipAddress"/>
    <form:label path="printId.branchCode">Branch Code: </form:label> <form:input type="text" path="printId.branchCode"/>
    <form:label path="personnelCode">Personnel Code: </form:label> <form:input type="text"  path="personnelCode"/>
    <form:label path="cardPAN">Card PAN: </form:label> <form:input type="text"  path="cardPAN"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>