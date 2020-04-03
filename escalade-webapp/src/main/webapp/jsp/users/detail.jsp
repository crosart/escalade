<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

<h1><s:property value="user.nickname" />

</h1>
<s:if test="user.isMember"><img src="${pageContext.request.contextPath}/resources/img/technical/member_stamp.png" alt="memberStamp" /></s:if>

<s:property value="user.firstName" />&nbsp;<s:property value="user.lastName" />

<hr>

</body>
</html>