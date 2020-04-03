<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

  <h2>Ajouter un Site</h2>

  <s:actionerror />
  <s:form action="site_new">
    <s:textfield name="name" label="Nom" requiredLabel="true" />
    <jsp:useBean id="departments" scope="request" type="fr.crosart.escalade.model.beans.Department"/>
    <s:doubleselect label="Pays" list="countries" doubleList="top == 'France' ? ${ departments } : {''}" name="country" doubleName="department" requiredLabel="true" />
    <s:select list="countries" label="Pays" name="country" requiredLabel="true" value="France" />
    <s:select list="departments" label="Département" name="department" requiredLabel="true" value="Département" />
    <s:textfield name="latitude" label="Latitude" requiredLabel="true" />
    <s:textfield name="longitude" label="Longitude" requiredLabel="true" />
    <s:textfield name="height" label="Hauteur" requiredLabel="true" />
    <s:textfield name="tracks" label="Voies" requiredLabel="true" />
    <s:select list="cotations" name="cotationMin" label="Cotation Minimum" />
    <s:select list="reversedcotations" name="cotationMax" label="Cotation Maximum" />
    <s:textarea name="description" label="Description" requiredLabel="true" />

    <s:submit value="Ajouter"/>
  </s:form>

</body>
</html>