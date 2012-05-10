<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<br />
<my:detalleMujer mujer="${details}"/>
<br />

<my:tabpannel target="/aula/resumen">
<br />
<!-- Tabla a los que esta apuntado pero aún no han comenzado -->
<div align="left">
	<label class="dlabel">Talleres sin comenzar a los que está inscrit@:</label>
</div>

<table border="1px" cellpadding="0" cellspacing="0"
	class="box3" align="center" width="100%">

	<tr>
		<th height="21" align="center"><label class="dlabel">Taller</label></th>
		<th align="center"><label class="dlabel">Fecha Inicio</label></th>
		<th align="center"><label class="dlabel">Fecha Fin</label></th>
		<th align="center"><label class="dlabel">Nº de Plazas</label></th>
		<th align="center"><label class="dlabel">Alumnos</label></th>
		<th align="center"><label class="dlabel">Libres</label></th>
		<th align="center"><label class="dlabel">Acciones</label></th>
	</tr>
	<c:forEach var="taller" items="${inscritos}">
		<tr>
			<td width="36%" height="21"><label class="label0"><c:out
				value="${taller.taller}" /></label></td>
			<td width="14%"><label class="label0">
				<fmt:formatDate value="${taller.inicio}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="14%"><label class="label0">
				<fmt:formatDate value="${taller.fin}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="8%" align="right"><label class="label0"><c:out
				value="${taller.numPlazas}" /></label></td>
			<td width="8%" align="right"><label class="label0"><c:out
				value="${taller.numAlumnos}" /></label></td>
			<td width="8%" align="right"><label class="label0"><c:out
				value="${taller.plazasLibres}" /></label></td>
			<td width="12%" align="center"><img src="<c:url value="/resources/img/remove-user-red.gif" />" alt="Borrase" align="middle" />
				<a class="dhref" href="<c:url value="/aula/cancel-join">
				<c:param name="aulaId" value="${taller.id}"/>
				<c:param name="mujerId" value="${details.id}"/></c:url>">Cancelar inscripción</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<!-- Tabla ofertados aún no comenzados y a los cuales no está apuntado -->
<div align="left">
	<label class="dlabel">Talleres ofertados:</label>
</div>

<table border="1px" cellpadding="0" cellspacing="0"
	class="box3" align="center" width="100%">

	<tr>
		<th height="21" align="center"><label class="dlabel">Taller</label></th>
		<th align="center"><label class="dlabel">Fecha Inicio</label></th>
		<th align="center"><label class="dlabel">Fecha Fin</label></th>
		<th align="center"><label class="dlabel">Nº de Plazas</label></th>
		<th align="center"><label class="dlabel">Alumnos</label></th>
		<th align="center"><label class="dlabel">Libres</label></th>
		<th align="center"><label class="dlabel">Acciones</label></th>
	</tr>
	<c:forEach var="taller" items="${ofertados}">
		<tr>
			<td width="36%" height="21"><label class="label0"><c:out
				value="${taller.taller}" /></label></td>
			<td width="14%"><label class="label0">
				<fmt:formatDate value="${taller.inicio}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="14%"><label class="label0">
				<fmt:formatDate value="${taller.fin}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="8%" align="right"><label class="label0"><c:out
				value="${taller.numPlazas}" /></label></td>
			<td width="8%" align="right"><label class="label0"><c:out
				value="${taller.numAlumnos}" /></label></td>
			<td width="8%" align="right"><label class="label0"><c:out
				value="${taller.plazasLibres}" /></label></td>
			<td width="12%" align="center">
				<c:choose>
					<c:when test="${taller.plazasLibres > 0}">
						<img src="<c:url value="/resources/img/add-user-red.gif" />" alt="apuntar" align="middle" />
						<a class="dhref" href="<c:url value="/aula/join">
						<c:param name="aulaId" value="${taller.id}"/>
						<c:param name="mujerId" value="${details.id}"/></c:url>">Inscribir</a>
					</c:when>
					<c:otherwise>
						<img src="<c:url value="/resources/img/restrict-page-red.gif" />" alt="apuntar" align="middle" />
  						<label class="dlabel">No hay plazas</label>
  					</c:otherwise>
				</c:choose>				
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<!-- Tabla con los talleres que esta cursando la persona actualmente -->
<div align="left">
	<label class="dlabel">Talleres que cursa actualmente:</label>
</div>

<table border="1px" cellpadding="0" cellspacing="0"
	class="box3" align="center" width="100%">

	<tr>
		<th height="21" align="center"><label class="dlabel">Taller</label></th>
		<th align="center"><label class="dlabel">Fecha Inicio</label></th>
		<th align="center"><label class="dlabel">Fecha Fin</label></th>
		<th align="center"><label class="dlabel">Nº de Plazas</label></th>
		<th align="center"><label class="dlabel">Alumnos</label></th>
		<th align="center"><label class="dlabel">Libres</label></th>
	</tr>
	<c:forEach var="taller" items="${encurso}">
		<tr>
			<td width="40%" height="21"><label class="label0"><c:out
				value="${taller.taller}" /></label></td>
			<td width="15%"><label class="label0">
				<fmt:formatDate value="${taller.inicio}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="15%"><label class="label0">
				<fmt:formatDate value="${taller.fin}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="10%" align="right"><label class="label0"><c:out
				value="${taller.numPlazas}" /></label></td>
			<td width="10%" align="right"><label class="label0"><c:out
				value="${taller.numAlumnos}" /></label></td>
			<td width="10%" align="right"><label class="label0"><c:out
				value="${taller.plazasLibres}" /></label></td>
		</tr>
	</c:forEach>
</table>

</my:tabpannel>
</body>
</html>