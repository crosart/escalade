<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>
<article class="search">
<%@ include file="../_include/header.jsp"%>

  <div id="search_page">
<s:actionerror />
<s:form action="search">

  <s:textfield name="search" placeholder="Nom du site" requiredLabel="false" theme="simple" />
  <s:select list="countries" name="country" requiredLabel="false" theme="simple" />
  <s:select list="departments" name="department" requiredLabel="false" theme="simple" />
  <s:select list="cotations" name="cotationMin" requiredLabel="false" theme="simple" />
  <s:select list="reversedcotations" name="cotationMax" requiredLabel="false" theme="simple" />
  <s:submit value="Rechercher" />

</s:form>
  </div>

  <div>
<h1>Résultats de votre recherche</h1>
  </div>
  <div>
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
  </div>
</article>
</body>
</html>
