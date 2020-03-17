<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>

<h1>ACCOUNT</h1>

<s:property value="#session.user.firstname" />
<s:property value="#session.user.lastname" />
<s:property value="#session.user.nickname" />

<hr>

<h2>Mes topos :</h2>

<ul>
  <s:iterator value="listTopo">
    <li>
      <s:param name="id" value="id" />
      <s:property value="siteName" /> :
      <s:property value="siteDepartment"/>
      <s:if test="isReserved == true">
        Réservé par [UTILISATEUR]
      </s:if>
      <s:else>
        Topo disponible
      </s:else>
    </li>
  </s:iterator>
</ul>

</body>
</html>
