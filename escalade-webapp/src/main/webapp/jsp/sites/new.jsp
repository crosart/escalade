<!DOCTYPE html>
<html>
  <%@ include file="../_include/head.jsp" %>

<body>
<%@ include file="../_include/header.jsp" %>

<h2>Ajouter un Site</h2>

<s:actionerror />
<s:form action="site_new">
  <s:textfield name="name" label="Nom" requiredLabel="true" />

  <s:textfield name="country" label="Pays" requiredLabel="true" />
  <s:textfield name="department" label="D\u00e9partement" requiredLabel="true" />
  <s:textfield name="latitude" label="Latitude" requiredLabel="true" />
  <s:textfield name="longitude" label="Longitude" requiredLabel="true" />
  <s:textfield name="height" label="Hauteur" requiredLabel="true" />
  <s:textfield name="tracks" label="Voies" requiredLabel="true" />
  <s:select list="cotations" name="cotationMin" label="Cotation Minimum" />
  <s:select list="cotations" name="cotationMax" label="Cotation Maximum" />
  <s:textarea name="description" label="Description" requiredLabel="true" />

  <s:submit value="Ajouter"/>
</s:form>
</body>
</html>