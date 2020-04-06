<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>

  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">Les Amis de l'escalade</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a class="waves-effect waves-light btn">SEARCH</a></li>
        <li>NEW SITE</li>
        <li>ACCOUNT</li>
        <li>LOGIN</li>
        <li>SIGNIN</li>
        <li>DISCONNECT</li>
      </ul>
    </div>
  </nav>


    <div id="title">
      <s:a action="index"><img src="${pageContext.request.contextPath}/resources/img/style_resources/logo_title.png" alt="logo_titre" /></s:a>
    </div>

    <div id="quicksearch">
      <s:form action="search">
        <s:textfield name="search" placeholder="Recherche Rapide" theme="simple" autocomplete="off" /><s:submit value="Rechercher" theme="simple" />
      </s:form>

    </div>

   <!-- <nav>
      <span id="search_button">
        <s:a action="search">
          Recherche avancée
        </s:a>
      </span>
      <s:if test="#session.user">


        <s:a action="site_new"><img src="${pageContext.request.contextPath}/resources/img/style_resources/icon_site.png" alt="ajouter_site" /></s:a>
      </s:if>

      <s:if test="#session.user">
        <s:a action="account">
          <s:param name="id" value="#session.user.id" />
          <em><s:property value="#session.user.nickname" /></em>
        </s:a>
        <s:a action="logout">Déconnexion</s:a>
      </s:if>
      <s:else>
        <span id="login_button"><s:a action="login">Se connecter</s:a></span>
        <span id="signin_button"><s:a action="signin">S'inscrire</s:a></span>
      </s:else>


    </nav>-->
</header>