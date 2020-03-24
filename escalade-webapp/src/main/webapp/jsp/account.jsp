<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>

<s:if test="user.id != #session.user.id">
  ACCES INTERDIT
</s:if>
<s:else>

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
      <s:property value="siteName" /> - <s:property value="siteDepartment"/>
      <s:if test="reserved">
        Réservé par : <s:a action="user_detail">
          <s:param name="topoOwner" value="true" />
          <s:param name="id" value="reservedUserId" />
          <s:property value="reservedUserName" />
        </s:a>
        <s:a action="unlock_topo">
          <s:param name="id" value="id" />
          Remettre ce topo à disposition
        </s:a>
      </s:if>
      <s:else>
        Topo disponible
      </s:else>

    </li>
  </s:iterator>
</ul>
</s:else>
</body>
</html>
