<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body style="background: url('${pageContext.request.contextPath}/resources/img/account_background.jpg') no-repeat fixed center;background-size: cover;">

<%@ include file="../_include/header.jsp"%>

<div class="container-fluid pr-0 pl-0" style="padding-top: 56px;height: 100vh;">

  <s:if test="user.id != #session.user.id">
    <div class="alert alert-danger text-center w-50 mx-auto mt-2"><i class="fas fa-exclamation-triangle"></i>&nbsp;&nbsp;ACCES INTERDIT&nbsp;&nbsp;<i class="fas fa-exclamation-triangle"></i></div>
  </s:if>
  <s:else>

    <div class="container">
      <div class="jumbotron mt-5 pt-4">
        <s:if test="user.isMember">
            <span class="btn btn-outline-success float-right disabled">
            <i class="fa fa-check"></i>&nbsp;&nbsp;Membre
          </span>
        </s:if>
        <h1 class="text-capitalize display-4">
          <s:property value="#session.user.nickname" />
        </h1>

        <span class="text-uppercase lead"><s:property value="#session.user.lastname" /></span>
        <span class="text-capitalize lead"><s:property value="#session.user.firstname" /></span>

        <hr>

        <h3 class="mb-4">Topos possédés</h3>

        <s:iterator value="listTopo">
          <s:param name="id" value="id" />
          <div class="card bg-dark mb-2">
            <div class="card-header text-light">
              <h5><s:property value="siteName" /></h5>
              <div class="mb-2">
                <s:if test="%{!pending && !reserved}">
                  <span class="badge badge-info">Disponible</span>
                </s:if>
                <s:if test="%{pending || reserved}">
                  <span class="badge badge-danger">Réservé</span>
                </s:if>
              </div>
            </div>
            <div class="card-body">
              <s:if test="%{!pending && !reserved}">
                <p class="text-light m-0">
                  Ce topo est actuellement disponible.
                </p>
              </s:if>
              <s:if test="%{pending || reserved}">
                <p class="text-light m-0">
                  Ce topo est actuellement réservé.
                </p>
              </s:if>

            </div>
            <div class="card-footer">
                <s:a action="site_detail">
                  <s:param name="id" value="siteId" />
                  Accéder au détail du site
                </s:a>
            </div>
          </div>
        </s:iterator>

      </div>
    </div>
  </s:else>
</div>
<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
