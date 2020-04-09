<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>
<div class="container-fluid pr-0 pl-0" style="overflow: hidden;height: 100vh;padding-top: 56px;background: url('${pageContext.request.contextPath}/resources/img/signin_background.jpg') no-repeat fixed center;background-size: cover;">

  <div class="row h-100 justify-content-center align-items-center">

  <s:form theme="simple" action="signin" cssClass="text-center">
    <s:actionerror cssClass="text-center btn btn-danger btn-sm" cssStyle="list-style-type: none;" />
    <div class="input-group mb-1">
      <div class="input-group-prepend">
        <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-at mx-auto"></i>
        </div>
      </div>
      <s:textfield cssClass="form-control" name="mail" placeholder="E-Mail" required="true" type="email" />
    </div>
    <div class="input-group mb-1">
      <div class="input-group-prepend">
        <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-key mx-auto"></i>
        </div>
      </div>
      <s:password cssClass="form-control" name="password" placeholder="Mot de passe" required="true" />
    </div>
    <div class="input-group mb-1">
      <div class="input-group-prepend">
        <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-key text-warning mx-auto"></i>
        </div>
      </div>
      <s:password cssClass="form-control" name="confirmPassword" placeholder="Confirmation" required="true" />
    </div>
    <div class="input-group mb-1">
      <div class="input-group-prepend">
        <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-user mx-auto"></i>
        </div>
      </div>
    <s:textfield cssClass="form-control" name="nickname" placeholder="Nom d'utilisateur" required="true" />
    </div>
    <div class="input-group mb-1">
      <div class="input-group-prepend">
        <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-id-card mx-auto"></i>
        </div>
      </div>
    <s:textfield cssClass="form-control" name="firstname" placeholder="Prénom" required="true" />
    </div>
    <div class="input-group mb-1">
            <div class="input-group-prepend">
              <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-id-card mx-auto"></i>
        </div>
      </div>
    <s:textfield cssClass="form-control" name="lastname" placeholder="Nom" required="true" />
    </div>


    <div class="input-group mb-1">
      <div class="input-group-prepend">
        <div class="input-group-text" style="width: 45px;">
          <i class="fas fa-phone mx-auto"></i>
        </div>
      </div>
    <s:textfield cssClass="form-control" name="telephone" placeholder="Téléphone" />
    </div>

    <s:submit cssClass="btn btn-primary mt-3" value="S'inscrire" />



  </s:form>

  </div>

</div>
<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>