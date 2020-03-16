<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

<h1>Résultats de votre recherche</h1>

<ul>
  <s:iterator value="listSite">
    <li>
      <s:param name="id" value="id" />
      <s:property value="id" /> :
      <s:a action="site_detail">
        <s:param name="id" value="id" />
        <s:property value="name"/>
      </s:a> -
      <s:property value="country" />
    </li>
  </s:iterator>
</ul>

</body>
</html>
