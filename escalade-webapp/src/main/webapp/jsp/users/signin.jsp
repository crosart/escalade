<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

<h2>Créer un compte</h2>

<div class="debug"><s:actionerror />
<s:form action="signin">
  <s:textfield name="login" label="Login" requiredLabel="true" />
  <s:password name="password" label="Mot de passe" requiredLabel="true" />
  <s:textfield name="nickname" label="Pseudo" requiredLabel="true" />
  <s:textfield name="firstname" label="Prénom" requiredLabel="true" />
  <s:textfield name="lastname" label="Nom" requiredLabel="true" />
  <s:textfield name="mail" label="E-Mail" requiredLabel="true" />
  <s:textfield name="telephone" label="Téléphone" requiredLabel="false" />
  <s:submit value="S'inscrire"/>
</s:form>
</div>
</body>
</html>