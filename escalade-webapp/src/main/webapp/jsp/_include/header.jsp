<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>

  <div id="title">
    <s:a action="index"><img src="${pageContext.request.contextPath}/resources/img/style_resources/logo_mini.png" alt="logo_mini" /></s:a>
    LES AMIS DE L'ESCALADE
  </div>

  <div id="search">
    <s:form action="search">
      <s:textfield name="search" placeholder="Rechercher un site" theme="simple" /><s:submit value="Rechercher" theme="simple" />
    </s:form>
  </div>

  <nav>
    <s:if test="#session.user">
      <s:a action="account">
        <s:param name="id" value="#session.user.id" />
        <img src="${pageContext.request.contextPath}/resources/img/style_resources/icon_account.png" alt="mon_compte" />
      </s:a>
      <s:a action="site_new"><img src="${pageContext.request.contextPath}/resources/img/style_resources/icon_site.png" alt="ajouter_site" /></s:a>
    </s:if>

    <s:if test="#session.user">
      <em><s:property value="#session.user.nickname" /></em>
      <s:a action="logout">Déconnexion</s:a>
    </s:if>
    <s:else>
      <s:a action="login">Connexion</s:a>
    </s:else>

  </nav>

</header>