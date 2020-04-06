<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>

  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerEscalade" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerEscalade">
      <s:a action="index" cssClass="navbar-brand"><i class="fas fa-mountain"></i>&nbsp;&nbsp;LES AMIS DE L'ESCALADE</s:a>

      <s:if test="#session.user">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
          <li class="nav-item">
            <s:a action="search" cssClass="nav-link">
              <i class="fas fa-search"></i>&nbsp;&nbsp;Rechercher
            </s:a>
          </li>
          <li class="nav-item">
            <s:a action="site_new" cssClass="nav-link">
              <i class="far fa-plus-square"></i>&nbsp;&nbsp;Ajouter un site
            </s:a>
          </li>
        </ul>
      </s:if>

    </div>

    <s:if test="#session.user">
      <div class="btn-group">
      <s:a action="account" cssClass="btn btn-primary btn-sm mr-1">
        <s:param name="id" value="#session.user.id" />
        <s:property value="#session.user.nickname" />
      </s:a>
      <s:a action="logout" cssClass="btn btn-danger btn-sm">
        Déconnexion&nbsp;<i class="fas fa-user-times"></i>
      </s:a>
    </div>
    </s:if>

    <s:else>
      <div class="btn-group" role="group" aria-label="Sign-In">
        <s:a action="login" cssClass="btn btn-outline-primary btn-sm">
          Se connecter
        </s:a>
        <s:a action="signin" cssClass="btn btn-primary btn-sm">
          S'inscrire
        </s:a>
      </div>
    </s:else>



  </nav>
  <!--
              <s:form action="search">
            <div class="input-group">
              <div class="input-group-prepend">
                <div class="input-group-text"><i class="fas fa-search"></i></div>
              </div>
              <s:textfield name="search" placeholder="Recherche Rapide" autocomplete="off" cssClass="form-control" cssId="inlineFormInputGroupUsername" />
            </div>
            </s:form>


    <div id="title">
      <s:a action="index"><img src="${pageContext.request.contextPath}/resources/img/style_resources/logo_title.png" alt="logo_titre" /></s:a>
    </div>

    <div id="quicksearch">
      <s:form action="search">
        <s:textfield name="search" placeholder="Recherche Rapide" theme="simple" autocomplete="off" /><s:submit value="Rechercher" theme="simple" />
      </s:form>

    </div>

    <nav>
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


    </nav>
    -->
</header>