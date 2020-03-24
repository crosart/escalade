<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>
<article class="search">
<%@ include file="../_include/header.jsp"%>

  <div class="form">
<s:actionerror />
<s:form action="advanced_search">
  <s:textfield name="search" placeholder="Rechercher" requiredLabel="false" />
  <s:select list="countries" name="country" requiredLabel="false" />
  <s:select list="departments" name="department" requiredLabel="false" />
  <s:select list="cotations" name="cotationMin" requiredLabel="false" />
  <s:select list="reversedcotations" name="cotationMax" requiredLabel="false" value="9c+" />
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
