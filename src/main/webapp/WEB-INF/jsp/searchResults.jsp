<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Concejalía de Mujer</title>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
</head>
<body id="main">
<my:cabecera />
<my:menu />
<my:searchForm busq="${busq}" />
<br />
<div align="center">
<table width="85%" border="0" align="center">
	<tr>
		<td><label class="dlabel">Resultados de la Búsqueda:&nbsp;<c:out value="${fn:length(mujeres)}" /></label></td>
	</tr>
	<c:forEach var="mujer" items="${mujeres}">
		<tr>
			<td height="94"><my:mujerListItem mujer="${mujer}" /></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>