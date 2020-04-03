<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<%@ include file="../_include/head.jsp"%>

<body>

<%@ include file="../_include/header.jsp"%>


<div class="contenu">
  <s:form action="modify_comment">
    <s:hidden name="commentId" value="%{ comment.id }" />
    <s:hidden name="commentStatus" value="true" />
    <s:textarea name="content" label="Nouveau commentaire" value="%{ comment.content }" />
    <s:submit value="Modifier" />
  </s:form>
</div>
</body>
</html>
