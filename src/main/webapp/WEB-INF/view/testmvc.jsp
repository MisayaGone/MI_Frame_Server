<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test mvc jsp</title>
</head>
<body>
    我是mvc1
    <c:forEach var="address" items="${rows}">
        <br />${address.id} - ${address.addrName}
    </c:forEach>

    <br/>当前第 ${pageNumber} 页，每页 ${pageSize} 条， 共 ${totalPageSize} 页
</body>
</html>