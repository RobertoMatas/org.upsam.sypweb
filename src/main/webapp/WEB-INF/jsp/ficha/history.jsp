<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Histórico de Fichas</title>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
</head>
<body id="main">
<my:cabecera />
<my:menu />
<br />
<my:detalleMujer mujer="${details}"/>
<br />

<my:tabpannel target="/ficha/historico">
<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
	<br />
	<c:forEach var="ficha" items="${history}">
		<!-- Detalle de Ficha (F. Apertura, Servicio, F. Cierre y Motivo de apertura) -->
		<table class="list" width="95%" align="center">
			<tr class="fila1">
				<td width="20%" class="col1" height="21" align="center"><label
					class="dlabel">F. Apertura:</label>&nbsp; <label class="label0">
				<fmt:formatDate value="${ficha.apertura}" pattern="dd/MM/yyyy" /> </label>
				</td>
				<td width="60%" class="col2" align="center"><label
					class="dlabel"><c:out value="${ficha.servicio.service}" /></label>
				</td>
				<td width="20%" class="col1" align="center"><label
					class="dlabel">F. Cierre:</label>&nbsp; <label class="label0">
				<fmt:formatDate value="${ficha.cierre}" pattern="dd/MM/yyyy" /> </label></td>
			</tr>
			<tr>
				<td colspan="3">
				<table width="100%" cellpadding="0" cellspacing="0" class="box1b"
					align="center">
					<tr>
						<td>
						<table class="box1b" width="100%">
							<tr>
								<td width="20%" align="center"><label class="dlabel">Motivo:</label>
								</td>
								<td class="label0" width="80%"><c:out
									value="${ficha.descripcion}" /></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<div style="overflow-y: auto; overflow-x: hidden; height: 60px;">
					<my:seguimientos seguimientos="${ficha.seguimientos }"/>
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<div style="overflow-y: auto; overflow-x: hidden; height: 60px;">
				<my:adjuntos adjuntos="${ficha.adjuntos }"/>
				</div>
				</td>
			</tr>
		</table>
		<br />
	</c:forEach>
</sec:authorize>
</my:tabpannel>
</body>
</html>