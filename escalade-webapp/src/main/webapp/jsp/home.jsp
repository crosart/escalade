<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
<head>
  <%@ include file="_include/head.jsp"%>
</head>
<body>

<%@ include file="_include/header.jsp"%>

<h1>Derniers Sites ajoutés</h1>

<ul>
  <s:iterator value="listSite">
    <li>
      <s:param name="id" value="id" />
      <s:property value="id" /> :
      <s:property value="name"/> -
      <s:property value="country" />
    </li>
  </s:iterator>
</ul>

</body>
</html>
