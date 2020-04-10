<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

<div class="container-fluid pr-0 pl-0" style="overflow: hidden;height: 100vh;padding-top: 56px;background: url('${pageContext.request.contextPath}/resources/img/addsite_background.jpg') no-repeat fixed center;background-size: cover;">
  <div class="container">
    <div class="jumbotron py-4 mt-5">

      <s:actionerror />
      <s:form action="search" theme="simple">
        <div class="form-group row justify-content-center align-items-center mx-auto my-1 flex-column flex-lg-row">
          <s:textfield name="search" cssClass="form-control col-12 col-lg-2 mr-1 my-1 my-lg-0" placeholder="Nom du site" requiredLabel="false" value="%{ researchBean.textSearch }" />
          <s:select list="countries" cssClass="form-control custom-select col-12 col-lg-2 mr-1 my-1 my-lg-0" name="country" requiredLabel="false" value="%{ researchBean.country }"/>
          <s:select list="departments" cssClass="form-control custom-select col-12 col-lg-2 mr-1 my-1 my-lg-0" name="department" requiredLabel="false" value="%{ researchBean.department }" />
          <div class="flex-row col-lg-2 my-1 my-lg-0 p-0 text-center">
            <s:select list="cotations" cssClass="form-control custom-select col-5 border-success" name="cotationMin" requiredLabel="false" value="%{ researchBean.cotationMin }" />
            <s:select list="reversedcotations" cssClass="form-control custom-select col-5 border-danger" name="cotationMax" requiredLabel="false" value="%{ researchBean.cotationMax }" />
          </div>
          <s:submit type="button" cssClass="btn btn-primary col-6 col-lg-2 ml-1 mt-3 mt-lg-0"><i class="fas fa-search"></i>&nbsp;&nbsp;Rechercher</s:submit>
        </div>
      </s:form>

      <s:if test="%{!listSite.isEmpty()}">
        <hr class="mt-4">

        <h4 class="lead font-italic mb-3">Résultats de votre recherche</h4>

        <s:iterator value="listSite">
          <div class="card mb-2">
            <div class="card-header">
              <h5><s:property value="name" /></h5>
              <span class="badge badge-primary"><s:property value="country" /></span>
              <s:if test="%{department != null}">
                <span class="badge badge-secondary"><s:property value="department" /></span>
              </s:if>
            </div>
            <div class="card-body px-5">
              <div class="card-deck">
                  <div class="card py-3 my-2" style="min-width: 300px">
                    <table class="my-auto">
                      <tr>
                        <td class="text-center" style="width: 50px;">
                          <i class="fas fa-location-arrow"></i>
                        </td>
                        <td>
                          <s:property value="latitude" />
                          -
                          <s:property value="longitude" />
                        </td>
                      </tr>
                      <tr>
                        <td class="text-center">
                          <i class="fas fa-layer-group"></i>
                        </td>
                        <td>
                          Difficulté de
                          <span class="badge badge-success">
              <s:property value="cotationMin" />
            </span>&nbsp;à
                          <span class="badge badge-danger">
              <s:property value="cotationMax" />
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
              <s:property value="height" />m
            </span>
                        </td>
                      </tr>
                      <tr>
                        <td class="text-center">
                          <i class="fas fa-hashtag"></i>
                        </td>
                        <td>
            <span class="badge badge-secondary">
              <s:property value="tracks" /> voies
            </span> sur le site
                        </td>
                      </tr>
                      <tr>
                        <td class="text-center">
                          <i class="fas fa-calendar-day"></i>
                        </td>
                        <td>
                          Site ajouté le <s:property value="creationDate"/>
                        </td>
                      </tr>
                    </table>
                  </div>
                  <div class="card px-3 py-3 my-2" style="min-width: 300px">
                    <span class="text-justify" style="overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 5;">
                    <s:property value="description" />
                  </span>
                  </div>
              </div>
            </div>
          </div>
        </s:iterator>

      </s:if>
    </div>
  </div>
</div>
<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>