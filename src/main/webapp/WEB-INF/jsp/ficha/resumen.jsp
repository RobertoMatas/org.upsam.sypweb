<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestión de Fichas</title>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
</head>
<body id="main">
<my:cabecera />
<my:menu />
<br />
<my:detalleMujer mujer="${details}"/>
<br />
<my:tabpannel target="/ficha/resumen" subtarget="resumen">
<table class="list" width="85%" align="center">
	<tr class="fila1">
		<td width="5%" height="21" align="center">
			<a href="<c:url value="/ficha/edit">
				<c:param name="mujerId" value="${ficha.mujer.id}"/></c:url>">
			<img src="<c:url value="/resources/img/modificar.gif" />" border="0" /></a>
		</td>
		<td width="90%" class="col2" align="center"><label class="dlabel">Ficha actual para&nbsp;<c:out value="${ficha.servicio.service}" /></label></td>
		<td width="5%" align="center">
			<c:set var="parte1" value="if (window.confirm('¿Está seguro que desea cerrar la ficha?')) { window.location.href = '" />
			<c:url var="myUrl" value="/ficha/close">
				<c:param name="fichaId" value="${ficha.id}"/>
			</c:url>
			<c:set var="dir" value="${myUrl}" />
			<c:set var="parte2" value="'; } return false;" />

			<a onclick="<c:out value="${parte1}" escapeXml="false" /><c:out value="${dir}" /><c:out value="${parte2}" escapeXml="false" />" href="#">
				<img src="<c:url value="/resources/img/eliminar.gif" />" border="0" alt="Cerrar Ficha"/>
			</a>
		</td>
	</tr>
	<tr>
		<td colspan="3">
		<table class="box1b" align="center" width="100%">
			<tr>
				<td width="20%" height="35" align="center">
					<label class="dlabel">Motivo:</label>
				</td>
				<td width="80%">
					<label class="label0"><c:out value="${ficha.descripcion}" /></label>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br />
<!-- Listado de seguimientos adjuntos a la ficha -->
<my:seguimientos seguimientos="${ficha.seguimientos }"/>
<br />
<!-- Listado de documentos adjuntos a la ficha -->
<table border="1px" cellpadding="0" cellspacing="0" class="box3" align="center" width="85%">
	<!-- bloque seguimientos TODO -->
</table>
</my:tabpannel>
</body>
</html>