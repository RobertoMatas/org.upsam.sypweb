<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<center>
<table   id="background-image-andres" >
<thead>
<tr>
<th colspan="4">Ultimas citas concedidas</th>
</tr>
<tr>
<th >Nombre</th>
<th >Servicio</th>
<th >D&iacute;a asignado</th>
<th >Hora asignada</th>
</tr>
</thead>
<tbody>
<c:forEach items="${history }" var="h">
	<tr>
	<td><c:out value="${h.nombre}"></c:out></td><td><c:out value="${h.servicio }"></c:out></td><td><c:out value="${h.cita }"></c:out></td><td><c:out value="${h.hora }"></c:out></td>
	</tr>
</c:forEach>
</tbody>
</table>
</center>


</body>
</html>