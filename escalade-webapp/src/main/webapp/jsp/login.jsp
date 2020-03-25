<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>

<div id="login">
  <p>
    <s:actionerror />
    <s:form action="login">
      <s:textfield name="mail" placeholder="E-Mail" requiredLabel="true" />
      <s:password name="password" placeholder="Mot de passe" requiredLabel="true" />

      <s:submit value="Connexion"/>
    </s:form>

  </p>
</div>
</body>
</html>