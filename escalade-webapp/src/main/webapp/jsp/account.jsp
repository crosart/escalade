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
        <s:if test="pending && !reserved">
          <s:property value="reservedUserName" />&nbsp;a demandé l'accès au topo :&nbsp;
          [<s:a action="accept_topo"><s:param name="topoId" value="id" />CONFIRMER</s:a>]
        </s:if>
        <s:elseif test="!pending && reserved">
          Réservé par : <s:property value="reservedUserName" />&nbsp;
          [<s:property value="reservedUserMail" />]
          <s:if test="reservedUserTelephone != null">
            &nbsp;-&nbsp;<s:property value="reservedUserTelephone" />
          </s:if>
          <s:a action="unlock_topo">
            <s:param name="id" value="id" />
            Remettre ce topo à disposition
          </s:a>
        </s:elseif>
        <s:else>
          Topo disponible
        </s:else>

      </li>
    </s:iterator>
  </ul>
</s:else>
</body>
</html>
