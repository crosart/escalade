<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>
<div class="contenu">
  <div id="logo_home">
    <img class="img_logo" src="${pageContext.request.contextPath}/resources/img/style_resources/logo.png" alt="logo" />
  </div>

  <article>
    <h1 class="center">Derniers Sites ajoutés</h1>

    <ul class="liste">
      <s:iterator value="listSite">
        <li class="site_card">
          <s:param name="id" value="id" />
          <s:a action="site_detail">
            <s:param name="id" value="id" />
            <s:property value="name"/>
          </s:a> -
          <s:property value="country" />
          <s:if test="%{department != 'NC'}"><s:property value="department"  /></s:if>
          <p><s:property value="description" /></p>
          <p class="details"><s:a action="site_detail">
            <s:param name="id" value="id" />Plus de détails
          </s:a></p>
        </li>
      </s:iterator>
    </ul>
  </article>
</div>
</body>
</html>
