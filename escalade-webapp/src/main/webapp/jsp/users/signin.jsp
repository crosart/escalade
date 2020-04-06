<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>
<div class="container-fluid pr-0 pl-0" style="overflow: hidden;height: 100vh;padding-top: 56px;background: url('${pageContext.request.contextPath}/resources/img/signin_background.jpg') no-repeat fixed center;background-size: cover;">

  <div class="row h-100 justify-content-center align-items-center">

  <s:form action="signin" cssStyle="width: 250px;">
    <div class="alert alert-danger" role="alert">
      <s:actionerror cssClass="tsxt-justify" cssStyle="list-style-type: none" />
    </div>
    <s:textfield cssClass="form-control" name="mail" placeholder="E-Mail" requiredLabel="true" type="email" />
    <s:password cssClass="form-control" name="password" placeholder="Mot de passe" requiredLabel="true" />
    <s:password cssClass="form-control" name="confirmPassword" placeholder="Confirmation" requiredLabel="true" />
    <s:textfield cssClass="form-control" name="nickname" placeholder="Nom d'utilisateur" requiredLabel="true" />
    <s:textfield cssClass="form-control" name="firstname" placeholder="Prénom" requiredLabel="false" />
    <s:textfield cssClass="form-control" name="lastname" placeholder="Nom" requiredLabel="false" />
    <s:textfield cssClass="form-control mb-3" name="telephone" placeholder="Téléphone" requiredLabel="false" />
    <s:submit cssClass="btn btn-primary w-100" value="S'inscrire"/>



  </s:form>

  </div>

</div>
<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>