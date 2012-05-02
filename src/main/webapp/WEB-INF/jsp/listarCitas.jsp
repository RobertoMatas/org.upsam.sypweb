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

<my:tabpannel target="/cita/list">
<br />
<!-- Tabla con las distintas pendientes (la fecha actual es inferior a la de la cita) -->
<div align="left">
	<label class="dlabel">Citas pendientes:</label>
</div>
<table border="1px" cellpadding="0" cellspacing="0"
	class="box3" align="center" width="100%">

	<tr>
		<th height="21" align="center"><label class="dlabel">&nbsp;</label></th>
		<th align="center"><label class="dlabel">Servicio</label></th>
		<th align="center"><label class="dlabel">Responsable</label></th>
		<th align="center"><label class="dlabel">Fecha</label></th>
		<th align="center"><label class="dlabel">Hora</label></th>
	</tr>
	<c:forEach var="cita" items="${details.citasPendientes}">
		<tr>
			<td width="5%" height="21" align="center">
				<a class="dhref" href="<c:url value="/removeCita.htm">
					<c:param name="citaId" value="${cita.id}"/></c:url>">
					<img src="<c:url value="/resources/img/eliminar.gif" />" alt="Eliminar" align="middle" border="0" />
				</a>
			</td>
			<td width="35%"><label class="label0">
				<c:out value="${cita.servicio}" /></label>
			</td>
			<td width="30%" align="left">
				<label class="label0">
				<c:out value="${cita.responsable}" />
				</label>
			</td>
			<td width="20%">
				<label class="label0">
				<fmt:formatDate value="${cita.cita}" pattern="EEEE, dd/MM/yyyy" />
				</label>
			</td>
			
			<td width="10%" align="right">
				<label class="label0">
					${fn:substring(cita.hora,0,2)}:${fn:substring(cita.hora,2,4)}&nbsp;horas
				</label>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<div align="left">
	<label class="dlabel">Histórico de citas:</label>
</div>

<table border="1px" cellpadding="0" cellspacing="0"
	class="box3" align="center" width="100%">

	<tr>
		<th height="21" align="center"><label class="dlabel">Servicio</label></th>
		<th align="center"><label class="dlabel">Responsable</label></th>
		<th align="center"><label class="dlabel">Fecha</label></th>
		<th align="center"><label class="dlabel">Hora</label></th>
		<th align="center"><label class="dlabel">Acudio</label></th>
	</tr>
	<c:forEach var="cita" items="${details.historicoCitas}">
		<tr>
			<td width="35%"><label class="label0">
				<c:out value="${cita.servicio}" /></label>
			</td>
			<td width="30%" align="left">
				<label class="label0">
				<c:out value="${cita.responsable}" />
				</label>
			</td>
			<td width="20%">
				<label class="label0">
				<fmt:formatDate value="${cita.cita}" pattern="EEEE, dd/MM/yyyy" />
				</label>
			</td>
			
			<td width="10%" align="right">
				<label class="label0">
					${fn:substring(cita.hora,0,2)}:${fn:substring(cita.hora,2,4)}&nbsp;horas
				</label>
			</td>
			<td width="5%" height="21" align="center">
				<c:if test="${! cita.acudio}">
					<img src="<c:url value="/resources/img/pto-roj.gif" />" />
				</c:if>
				<c:if test="${cita.acudio}">
					<img src="<c:url value="/resources/img/pto-ver.gif" />" />
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
</my:tabpannel>
</body>
</html>