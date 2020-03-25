<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

<div id="signin">
<p>
  <s:actionerror />
  <s:form action="signin">
    <s:textfield name="mail" placeholder="E-Mail" requiredLabel="true" />
    <s:password name="password" placeholder="Mot de passe" requiredLabel="true" />
    <s:password name="confirmPassword" placeholder="Confirmation du mot de passe" requiredLabel="true" />
    <s:textfield name="nickname" placeholder="Nom d'utilisateur" requiredLabel="true" />
    <s:textfield name="firstname" placeholder="Prénom" requiredLabel="false" />
    <s:textfield name="lastname" placeholder="Nom" requiredLabel="false" />
    <s:textfield name="telephone" placeholder="Téléphone" requiredLabel="false" />
    <s:submit value="S'inscrire"/>
  </s:form>
</p>
</div>
</body>
</html>