<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
  <s:if test="#session.user">
    Utilisateur connecté :
    <s:property value="#session.user.firstname" />
    <s:property value="#session.user.lastname" />

    <s:a action="logout">[Déconnexion]</s:a>

  </s:if>
  <s:else>
    <s:a action="login">[Connexion]</s:a>
  </s:else>

  <nav>
    <s:a action="home">[Accueil]</s:a>
    <s:if test="#session.user">
      <s:a action="account">
        <s:param name="id" value="#session.user.id" />
        [Mon Compte]
      </s:a>
      <s:a action="site_new">[Ajouter un Site]</s:a>
    </s:if>

    <!-- A CABLER -->
    [Rechercher]
  </nav>
</header>