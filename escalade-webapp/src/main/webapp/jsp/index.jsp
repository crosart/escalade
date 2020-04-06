<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body>

<%@ include file="./_include/header.jsp"%>

<div class="container-fluid" style="padding-top: 60px;">
  <div class="jumbotron">
    <img class="img_logo" src="${pageContext.request.contextPath}/resources/img/style_resources/logo.png" alt="logo" />
  </div>

  <div class="container">
    <div class="row row-cols-1 row-cols-md-3">
      <s:iterator value="listSite">
        <s:param name="id" value="id" />
        <div class="col mb-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">
              <s:a action="site_detail">
                <s:param name="id" value="id" />
                <s:property value="name" />
              </s:a>
              <s:if test="%{official}">
                <span class="badge badge-success">Site Officiel</span>
              </s:if>
            </h5>
            <h6 class="card-subtitle text-muted">
              <span class="badge badge-primary"><s:property value="country" /></span>
              <s:if test="%{department != null}">
                <span class="badge badge-secondary"><s:property value="department" /></span>
              </s:if>
            </h6>
            <p class="card-text text-truncate">
              <s:property value="description" />
            </p>
          </div>
        </div>
        </div>
      </s:iterator>
    </div>
  </div>

<!--
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
    -->
</div>
</body>
</html>
