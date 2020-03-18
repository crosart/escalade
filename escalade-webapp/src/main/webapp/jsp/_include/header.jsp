<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>


  <div id="login"><s:if test="#session.user">
    Connecté en tant que
    <s:property value="#session.user.nickname" />
    <s:a action="logout">[DECONNEXION]</s:a>
  </s:if>
  <s:else>
    <s:a action="login">[CONNEXION]</s:a>
  </s:else>
  </div>
  <div id="menu"><nav>
    <s:a action="index">[ACCUEIL]</s:a>
    <s:if test="#session.user">
      <s:a action="account">
        <s:param name="id" value="#session.user.id" />
        [Mon Compte]
      </s:a>
      <s:a action="site_new">[Ajouter un Site]</s:a>
    </s:if>
  </nav>

  <div id="search">
    <s:form action="search">
      <s:textfield name="search" placeholder="Rechercher un site" theme="simple" /><s:submit value="Rechercher" theme="simple" />
    </s:form>
  </div>
  </div>
  <h1 class="titre">LES AMIS DE L'ESCALADE</h1>
</header>