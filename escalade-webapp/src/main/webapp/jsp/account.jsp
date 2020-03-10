<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>

<h1>ACCOUNT</h1>

<s:property value="#session.user.firstname" />
<s:property value="#session.user.lastname" />

</body>
</html>
