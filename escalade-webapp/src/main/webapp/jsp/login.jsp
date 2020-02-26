<!DOCTYPE html>
<html>
<head>
  <%@ include file="./_include/head.jsp" %>
</head>

<body>
<%@ include file="./_include/header.jsp" %>

<h2>Connexion</h2>

<s:actionerror />
<s:form action="login">
  <s:textfield name="login" label="Identifiant" requiredLabel="true" />
  <s:password name="password" label="Mot de passe" requiredLabel="true" />

  <s:submit value="Connexion"/>
</s:form>
</body>
</html>