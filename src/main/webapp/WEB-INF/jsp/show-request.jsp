<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Saved print request</title>
</head>
<body>
<c:if test="${addSuccess}">
    <div>Successfully added Book with</div>
    <br>
    <div>Ip Address: ${savedRequest.printId.ipAddress}</div>
    <div>Branch Code: ${savedRequest.printId.branchCode}</div>
    <div>Personnel Code: ${savedRequest.personnelCode}</div>
    <div>cardPAN: ${savedRequest.cardPAN}</div>
    <br>
    <c:url var="add_print_url" value="/view/add"/>
    <form:form action="${add_print_url}" method="get">
        <input type="submit" value="Add more!"/>
    </form:form>
    <c:url var="show_all_url" value="/view/all-requests"/>
    <form:form action="${show_all_url}" method="get">
        <input type="submit" value="Show all!"/>
    </form:form>
</c:if>
</body>
</html>