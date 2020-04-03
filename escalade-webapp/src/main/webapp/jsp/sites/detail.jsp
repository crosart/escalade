<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp"%>
<div class="contenu detail">
  <div id="site_title">
    <h1 class="center sitename"><s:property value="site.name" /></h1>
    <h1 class="center sitelocation"><s:property value="site.country" />
      <s:if test="site.country == 'France'">
        &nbsp;-&nbsp;<s:property value="site.department" />
      </s:if></h1>
  </div>
  <s:if test="site.isOfficial"><img src="${pageContext.request.contextPath}/resources/img/technical/official_stamp.png" alt="officialStamp" /></s:if>
  <s:elseif test="!site.isofficial && #session.user.isMember">
    [<s:a action="official_site">
    <s:param name="sId" value="site.id" />
    <s:param name="id" value="site.id" />
    RENDRE OFFICIEL</s:a>]
  </s:elseif>
  <div id="site_detail">
    <p>Ajouté le : <s:property value="site.creationDate" /></p>
    <p>Coordonnées GPS : <s:property value="site.latitude" /> - <s:property value="site.longitude" /></p>
    <p>Hauteur maximum : <s:property value="site.height" /></p>
    <p>Nombre de voies : <s:property value="site.tracks" /></p>
    <p>Cotation : de <s:property value="site.cotationMin" /> à <s:property value="site.cotationMax" /></p>

    <p><s:property value="site.description" /></p>
    <s:if test="listTopo == null">
      Aucun topo n'est disponible !
      <s:if test="#session.user">
        <s:a action="claim_topo">
          <s:param name="sId" value="sId" />
          Indiquer que vous le possédez !
        </s:a>
      </s:if>
    </s:if>
    <s:else>
      <ul>
        <s:iterator value="listTopo">
          <li>
            <s:if test="pending || reserved">

              Topo actuellement réservé !

            </s:if>

            <s:else>
              Topo publié le <s:property value="publishingDate" /> disponible !
              <s:if test="#session.user">
                &nbsp;&gt;&gt;&gt;&nbsp;
                <s:a action="reserve_topo">
                  <s:param name="topoId" value="id" />
                  <s:param name="sId" value="sId" />
                  RESERVER LE TOPO
                </s:a>
              </s:if>
            </s:else>
          </li>
        </s:iterator>
      </ul>
    </s:else>

    <hr>

    <h2>Commentaires</h2>

    <p>Ajouter Commentaire :
      <s:if test="#session.user">
        <s:actionerror />
        <s:form action="add_comment">
          <s:hidden name="siteId" value="%{ site.id }" />
          <s:textarea name="content" label="Commentaire" required="true" />
          <s:submit value="Ajouter" />
        </s:form>
      </s:if>
    </p>

    <ul>
      <s:iterator value="listComment" status="status">
        <li>
          Posté par <s:a action="user_detail">
          <s:param name="id" value="userId" />
          <s:property value="userNickname" />
        </s:a>&nbsp;le&nbsp;<s:property value="date"  />
          <p><s:property value="content" /></p>

          <s:if test="#session.user.isMember">
          <p>
            <s:a action="modify_comment">
            <s:param name="commentId" value="id" />
            modifier le commentaire
            </s:a>
          </p>
          <p>
            <s:a action="delete_comment">
            <s:param name="sId" value="%{ site.id }" />
            <s:param name="commentId" value="id" />
            supprimer le commentaire
            </s:a>
          </p>
          </s:if>


        </li>
      </s:iterator>
    </ul>
  </div>
</div>
</body>
</html>