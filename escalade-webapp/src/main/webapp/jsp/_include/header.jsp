<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
<div class="box">
  <div id="title">
    <s:a action="index"><img src="${pageContext.request.contextPath}/resources/img/style_resources/logo_mini.png" alt="logo_mini" />&nbsp;LES AMIS DE L'ESCALADE</s:a>
  </div>

  <div id="search">
    <s:form action="quicksearch">
      <s:textfield name="search" placeholder="Recherche Rapide" theme="simple" /><s:submit value="Rechercher" theme="simple" />
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
      <span id="login_button"><s:a action="login">Se connecter</s:a></span>
      <span id="signin_button"><s:a action="signin">S'inscrire</s:a></span>
    </s:else>


  </nav>
</div>
</header>