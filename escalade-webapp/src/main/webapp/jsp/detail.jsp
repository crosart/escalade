<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
<head>
  <%@ include file="_include/head.jsp"%>
</head>
<body>

  <%@ include file="_include/header.jsp"%>

  <h1><s:property value="site.country" /> - <s:property value="site.department" /> - <s:property value="site.name" />
  <s:if test="site.isOfficial"><img src="${pageContext.request.contextPath}/resources/img/technical/official_stamp.png" alt="officialStamp" /></s:if>
  </h1>
  <p>Coordonnées : <s:property value="site.latitude" /> - <s:property value="site.longitude" /></p>
  <p>Hauteur maximum : <s:property value="site.height" /></p>
  <p>Nombre de voies : <s:property value="site.tracks" /></p>
  <p>Cotation : de <s:property value="site.cotationMin" /> à <s:property value="site.cotationMax" /></p>

  <p><s:property value="site.description" /></p>

  <p>Topo [[DISPONIBLE]] : Faire une demande de réservation</p>

<hr>

<h2>Commentaires</h2>
<strike>
  <p>Commentaire plus récent + Posté par [[COMMENT.USER]] le [[COMMENT.DATE]] à [[COMMENT.HEURE]]</p>
  <p>[[Réponse au commentaire précédent en insultant sa génitrice]]</p>
  <p>Commentaire plus ancien + Posté par [[COMMENT.USER]] le [[COMMENT.DATE]] à [[COMMENT.HEURE]]</p>
  <p>[[Commentaire spirituel sur une expérience passée]]</p>
</strike>
</body>
</html>