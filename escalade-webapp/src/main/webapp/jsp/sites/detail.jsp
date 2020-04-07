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
                <s:property value="site.latitude" />
                -
                <s:property value="site.longitude" />
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
                Site ajouté le <s:property value="site.creationDate"/>
              </td>
            </tr>
          </table>
        </div>
        <div class="card p-3 mb-1" style="min-width: 275px;">
          <div class="my-auto">
            <s:if test="listTopo == null">
              Aucun topo n'est disponible pour ce site.
            </s:if>
            <s:else>
              <h5>Topos</h5>
              <hr>
              <ul class="list-unstyled m-0">
                <s:iterator value="listTopo">
                  <li>
                    <s:if test="pending || reserved">
                      <span class="text-muted">
                        <del><s:property value="publishingDate" /></del>&nbsp;<span class="badge badge-danger">Indisponible</span>
                      </span>
                    </s:if>
                    <s:else>
                      <s:property value="publishingDate" />
                      <s:if test="#session.user">
                        <s:a action="reserve_topo" cssClass="badge badge-success">
                          <s:param name="topoId" value="id" />
                          <s:param name="sId" value="site.id" />
                          Réserver
                        </s:a>
                      </s:if>
                    </s:else>
                  </li>
                </s:iterator>
              </ul>
            </s:else>
          </div>
        </div>

      </div>
      </div>
      <hr>

      <p class="text-justify">
        <s:property value="site.description" />
      </p>

      <hr>

      <span class="float-right">
        <a href="#add-comment" role="button" class="btn btn-info btn-sm"><i class="far fa-plus-square"></i>&nbsp;&nbsp;Je commente</a>
      </span>

      <h4 class="lead font-italic">Commentaires</h4>

      <div class="pt-2 mt-2">
      <s:iterator value="listComment" status="status">
        Posté par
        <s:a action="user_detail">
          <s:param name="id" value="userId" />
          <s:property value="userNickname" />
        </s:a>&nbsp;le&nbsp;<s:property value="date"  />
        <p class="text-justify"><s:property value="content" /></p>

        <p><s:if test="#session.user.isMember">
            <s:a action="modify_comment" cssClass="badge badge-warning">
              <s:param name="commentId" value="id" />
              Éditer
            </s:a>
            <s:a action="delete_comment" cssClass="badge badge-danger">
              <s:param name="sId" value="%{ site.id }" />
              <s:param name="commentId" value="id" />
              Supprimer
            </s:a>
        </s:if>
        </p>

        <hr>
      </s:iterator>
      </div>

      <h4 class="lead font-italic mt-0 pt-0" id="add-comment">Ajouter un commentaire</h4>

      <s:if test="#session.user">
        <s:actionerror />
        <s:form action="add_comment" cssClass="container text-center">
          <s:hidden name="siteId" value="%{ site.id }" />
          <s:textarea name="content" required="true" cssClass="form-control" cssStyle="resize: none;"/>
            <s:submit value="Commenter" cssClass="btn btn-primary mt-2" cssStyle="margin: auto;width: 150px;"/>
        </s:form>
      </s:if>

    </div>
  </div>

</div>
<!--
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
-->
<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
