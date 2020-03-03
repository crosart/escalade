<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>

<h2><s:text name="error.title" /></h2>

<s:actionerror />

<s:bean name="java.util.Date" var="now" />
<s:text name="error.metadata">
  <s:param value="now" />
</s:text>
</body>
</html>
