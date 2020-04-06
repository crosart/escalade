<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="./_include/head.jsp"%>

<body style="background-color: #343A40;">

<%@ include file="./_include/header.jsp"%>

<div class="container-fluid pr-0 pl-0" style="padding-top: 56px;">
  <div class="jumbotron jumbotron-fluid" style="background: url('${pageContext.request.contextPath}/resources/img/logo_bg.jpg') no-repeat fixed center;">
    <div class="container">
      <img class="mx-auto d-block" src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo" />
    </div>
  </div>

  <div class="container">
    <div class="row row-cols-1 row-cols-xl-3">
      <s:iterator value="listSite">
        <s:param name="id" value="id" />
        <div class="col mb-5">
          <div class="card">
            <h5 class="card-header">
              <s:a action="site_detail">
                <s:param name="id" value="id" />
                <s:property value="name" />
              </s:a>
              <s:if test="%{official}">
                <span class="badge badge-success float-right"><i class="fas fa-check-square"></i>&nbsp;Officiel</span>
              </s:if>
            </h5>
            <div class="card-body">
              <div class="card-subtitle mb-2">
                <span class="badge badge-primary"><s:property value="country" /></span>
                <s:if test="%{department != null}">
                  <span class="badge badge-secondary"><s:property value="department" /></span>
                </s:if>
              </div>

              <p class="card-text">
                  <span class="text-justify" style="overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 5;">
                    <s:property value="description" />
                  </span>
              </p>
              <span class="float-right text-muted">
                <small>Difficulté de
                <span class="badge badge-success">
                  <s:property value="cotationMin" />
                </span> à
                <span class="badge badge-danger">
                  <s:property value="cotationMax" />
                </span>
                </small>
              </span>

            </div>
            <div class="card-footer">
              <s:a action="site_detail">
                <s:param name="id" value="id" />Plus de détails
              </s:a>
            </div>
          </div>
        </div>
      </s:iterator>
    </div>
  </div>

</div>
<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
