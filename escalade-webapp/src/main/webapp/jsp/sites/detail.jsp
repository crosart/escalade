<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body style="background: url('${pageContext.request.contextPath}/resources/img/detail_background.jpg') no-repeat fixed center;background-size: cover;">

<%@ include file="../_include/header.jsp"%>

<div class="container-fluid pr-0 pl-0" style="padding-top: 56px;height: 100vh;">

  <div class="container">
    <div class="jumbotron mt-5 pt-4">
      <s:if test="%{site.official}">
        <p class="btn btn-success mb-0">
          <i class="fas fa-check-square"></i>&nbsp;Officiel
        </p>
      </s:if>
      <s:elseif test="%{!site.isofficial && #session.user.isMember}">
        <s:a action="official_site">
          <s:param name="id" value="site.id" />
          <s:param name="sId" value="site.id" />
          <p class="btn btn-info mb-0">
            <i class="fas fa-toggle-on"></i>&nbsp;Rendre officiel
          </p>
        </s:a>
      </s:elseif>
      <h1 class="text-capitalize my-4">
        <s:property value="site.name" />
      </h1>
      <p>
        <span class="badge badge-primary">
          <s:property value="site.country" />
        </span>
        <s:if test="site.country == 'France'">
          <span class="badge badge-info">
            <s:property value="site.department" />
          </span>
        </s:if>
      </p>

      <hr>
      <div class="container p-1">
        <div class="card-deck">
          <div class="card py-3 mb-1" style="min-width: 275px;">
            <table class="my-auto">
              <tr>
                <td class="text-center" style="width: 50px;">
                  <i class="fas fa-location-arrow"></i>
                </td>
                <td>
                  <s:a href="%{'https://www.google.com/maps/place/' + site.latitude + '+' + site.longitude}" target="_blank">
                  <s:property value="site.latitude" />
                  -
                  <s:property value="site.longitude" />
                  </s:a>
                </td>
              </tr>
              <tr>
                <td class="text-center">
                  <i class="fas fa-layer-group"></i>
                </td>
                <td>
                  Difficulté de
                  <span class="badge badge-success">
              <s:property value="site.cotationMin" />
            </span>&nbsp;à
                  <span class="badge badge-danger">
              <s:property value="site.cotationMax" />
            </span>
                </td>
              </tr>
              <tr>
                <td class="text-center">
                  <i class="fas fa-arrows-alt-v"></i>
                </td>
                <td>
                  Hauteur maximale de
                  <span class="badge badge-secondary">
              <s:property value="site.height" />m
            </span>
                </td>
              </tr>
              <tr>
                <td class="text-center">
                  <i class="fas fa-hashtag"></i>
                </td>
                <td>
            <span class="badge badge-secondary">
              <s:property value="site.tracks" /> voies
            </span> sur le site
                </td>
              </tr>
              <tr>
                <td class="text-center">
                  <i class="fas fa-calendar-day"></i>
                </td>
                <td>
                  Site ajouté le <s:property value="site.parsedCreationDate" />
                </td>
              </tr>
            </table>
          </div>
          <div class="card" style="min-width: 275px;">
            <div class="card-header pb-1">
              <h5>Topos</h5>
            </div>
            <div class="card-body my-auto p-3 mb-1">
              <s:if test="%{listTopo.isEmpty()}">
                Aucun topo pour ce site.
              </s:if>
              <s:else>
                <ul class="list-unstyled m-0">
                  <s:iterator value="listTopo">
                    <li>
                      <s:if test="pending || reserved">
                      <span class="text-muted">
                        <del><s:property value="parsedPublishingDate" /></del>&nbsp;<span class="badge badge-danger">
                        <i class="fas fa-times"></i>&nbsp;&nbsp;Indisponible</span>
                      </span>
                      </s:if>
                      <s:else>
                        <s:property value="parsedPublishingDate" />
                        <s:if test="#session.user">
                          <s:a action="reserve_topo" cssClass="badge badge-success">
                            <s:param name="topoId" value="id" />
                            <s:param name="siteId" value="site.id" />
                            <i class="fas fa-check"></i>&nbsp;&nbsp;Réserver
                          </s:a>
                        </s:if>
                        <s:else>
                          <span class="badge badge-success"><i class="fas fa-check"></i>&nbsp;&nbsp;Disponible</span>
                        </s:else>
                      </s:else>
                    </li>
                  </s:iterator>
                </ul>
              </s:else>
            </div>
            <div class="card-footer text-center">
              <s:if test="#session.user">
              <s:a action="claim_topo" class="btn btn-info btn-sm m-0">
                <s:param name="id" value="%{ site.id }" />
                <i class="far fa-plus-square"></i>&nbsp;&nbsp;Je possède ce topo</s:a>
              </s:if>
              <s:if test="%{!#session.user && listTopo.isEmpty()}">
                <span class="badge badge-warning">Connectez-vous et ajoutez le vôtre</span>
              </s:if>
              <s:elseif test="%{!#session.user && !listTopo.isEmpty()}">
                <span class="badge badge-warning">Connectez-vous pour réserver</span>
              </s:elseif>
            </div>

          </div>

        </div>
      </div>

      <hr class="mb-0 mt-4 pb-0">

      <p class="mt-0 pt-0" style="white-space: pre-line;text-align: justify;">
        <s:property value="site.description" />
      </p>

      <hr class="my-4">


      <s:if test="#session.user">
        <h4 class="lead font-italic mt-0 pt-0" id="add-comment">Ajouter un commentaire</h4>
        <s:form action="add_comment" cssClass="container align-items-center text-center mt-4">
          <s:hidden name="siteId" value="%{ site.id }" />
          <s:textarea name="content" required="true" cssClass="form-control" cssStyle="resize: none;"/>
          <s:submit value="Commenter" cssClass="btn btn-primary mt-2 mx-auto" />
        </s:form>
        <hr>
      </s:if>

      <s:if test="%{!listComment.isEmpty()}">
        <h4 class="lead font-italic">Commentaires</h4>

        <div class="pt-2 mt-2">
          <s:iterator value="listComment" status="status">
            <p class="mb-0 pb-0">
              Posté par
              <s:a action="user_detail">
                <s:param name="id" value="userId" />
                <s:property value="userNickname" />
              </s:a>
            </p>
            <p class="text-muted mt-0 pt-0">
              <small>
                <s:property value="parsedDate" />
              </small>
            </p>
            <p class="text-justify"><s:property value="content" /></p>

            <p><s:if test="#session.user.isMember">
              <s:a action="modify_comment" cssClass="badge badge-warning">
                <s:param name="commentId" value="id" />
                Éditer
              </s:a>
              <s:a action="delete_comment" cssClass="badge badge-danger">
                <s:param name="siteId" value="%{ site.id }" />
                <s:param name="commentId" value="id" />
                Supprimer
              </s:a>
            </s:if>
            </p>

            <hr>
          </s:iterator>
        </div>
      </s:if>
      <s:else>
        <h4 class="lead font-italic">Aucun commentaire</h4>
        <hr class="my-4">
      </s:else>



    </div>
  </div>

</div>

<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
