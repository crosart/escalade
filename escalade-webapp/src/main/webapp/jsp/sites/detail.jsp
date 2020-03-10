<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

  <%@ include file="../_include/head.jsp"%>

<body>

  <%@ include file="../_include/header.jsp"%>

  <h1><s:property value="site.country" /> - <s:property value="site.department" /> - <s:property value="site.name" />
  <s:if test="site.isOfficial"><img src="${pageContext.request.contextPath}/resources/img/technical/official_stamp.png" alt="officialStamp" /></s:if>
  </h1>
  <p>Ajouté le : <s:property value="site.creationDate" /></p>
  <p>Coordonnées GPS : <s:property value="site.latitude" /> - <s:property value="site.longitude" /></p>
  <p>Hauteur maximum : <s:property value="site.height" /></p>
  <p>Nombre de voies : <s:property value="site.tracks" /></p>
  <p>Cotation : de <s:property value="site.cotationMin" /> à <s:property value="site.cotationMax" /></p>

  <p><s:property value="site.description" /></p>

  <p>Topo [[DISPONIBLE]] : Faire une demande de réservation</p>

<hr>

<h2>Commentaires</h2>

  <ul>
    <s:iterator value="listComment" status="status">
      <li>

        Posté par <s:property value="userNickname" /> le <s:property value="date"  />
        <p><s:property value="content" /></p>

      </li>
    </s:iterator>
  </ul>

</body>
</html>