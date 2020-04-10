<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>

  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerEscalade" aria-controls="navbarTogglerEscalade" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerEscalade">
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0 mb-sm-3 mb-lg-0">
        <li class="nav-item">
          <s:a action="index" cssClass="nav-link">
            <i class="fas fa-mountain"></i>&nbsp;&nbsp;Accueil
          </s:a>
        </li>
        <li class="nav-item">
          <s:a action="search" cssClass="nav-link">
            <i class="fas fa-search"></i>&nbsp;&nbsp;Rechercher
          </s:a>
        </li>
        <s:if test="#session.user">

          <li class="nav-item">
            <s:a action="site_new" cssClass="nav-link">
              <i class="far fa-plus-square"></i>&nbsp;&nbsp;Ajouter un site
            </s:a>
          </li>
        </s:if>
      </ul>
    </div>

    <s:if test="#session.user">
      <div class="btn-group" role="group" aria-label="Account">
        <s:a action="account" cssClass="btn btn-primary btn-sm mr-1">
          <s:param name="id" value="#session.user.id" />
          <i class="fas fa-user"></i>&nbsp;
          <s:property value="#session.user.nickname" />
        </s:a>
        <s:a action="logout" cssClass="btn btn-danger btn-sm">
          <i class="fas fa-user-times"></i>
        </s:a>
      </div>
    </s:if>

    <s:else>
      <span class="btn-group" role="group" aria-label="Sign-In">
        <s:a action="login" cssClass="btn btn-outline-primary btn-sm">
          Se connecter
        </s:a>
        <s:a action="signin" cssClass="btn btn-primary btn-sm">
          S'inscrire
        </s:a>
      </span>
    </s:else>

  </nav>
</header>