<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>
<div class="container-fluid pr-0 pl-0" style="overflow: hidden;height: 100vh;padding-top: 56px;background: url('${pageContext.request.contextPath}/resources/img/modif_background.jpg') no-repeat fixed center;background-size: cover;">
  <div class="row h-100 justify-content-center flex-column text-center">

    <s:form action="modify_comment" cssClass="container mx-auto" theme="simple">
      <h4>Édition du commentaire</h4>
      <s:hidden name="commentId" value="%{ comment.id }" />
      <s:hidden name="commentStatus" value="true" />
      <s:hidden name="siteId" value="%{ comment.siteId }" />
      <s:textarea disabled="true" value="%{ comment.content }" cssClass="form-control w-100 mx-auto" cssStyle="max-width: 550px;resize: none;height: 9.6em" />
      <i class="fas fa-arrow-down fa-3x my-4"></i>
      <s:textarea name="content" value="%{ comment.content }" cssClass="form-control w-100 mx-auto" cssStyle="max-width: 550px;resize: none;height: 9.6em"/>
      <s:submit value="Modifier" cssClass="btn btn-primary mt-2" />
    </s:form>
  </div>
</div>

<script src="https://kit.fontawesome.com/20a90a2927.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>