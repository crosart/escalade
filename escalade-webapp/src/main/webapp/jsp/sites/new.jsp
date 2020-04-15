<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>

<div class="container-fluid pr-0 pl-0" style="overflow: hidden;height: 100vh;padding-top: 56px;background: url('${pageContext.request.contextPath}/resources/img/addsite_background.jpg') no-repeat fixed center;background-size: cover;">

  <div class="row h-100 justify-content-center align-items-center">

  <s:actionerror />
  <s:form action="site_new" cssClass="text-center" theme="simple">
    <s:textfield name="name" label="Nom" required="true" placeholder="Nom du site" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <s:select list="countries" label="Pays" name="country" required="true" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <s:select list="departments" label="Département" name="department" required="true" value="Département" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <s:textfield name="latitude" label="Latitude" required="true" placeholder="Latitude (45°0'0\"N)" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <s:textfield name="longitude" label="Longitude" required="true" placeholder="Longitude (0°0'0\"E)" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <s:textfield name="height" label="Hauteur" required="true" placeholder="Hauteur du site (en mètres)" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <s:textfield name="tracks" label="Voies" required="true" placeholder="Nombre de voies" cssClass="form-control mb-1" cssStyle="max-width: 300px;" />
    <div class="badge badge-info mb-2">
      Difficulté
    </div>
    <div class="form-group row w-100 justify-content-center mx-auto mb-1">
    <s:select list="cotations" name="cotationMin" label="Cotation Minimum" required="true" cssClass="col-3 form-control mb-1 mr-1 border-success custom-select" />
    <s:select list="reversedcotations" name="cotationMax" label="Cotation Maximum" required="true" cssClass="col-3 form-control mb-1 ml-1 border-danger custom-select" />
    </div>
      <s:textarea name="description" label="Description" placeholder="Description du site" required="true" cssClass="form-control mb-3" cssStyle="resize: none;max-width: 300px;" />

    <s:submit value="Ajouter" cssClass="btn btn-primary" />
  </s:form>

</div>
</div>


<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>