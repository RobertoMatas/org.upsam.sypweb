<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Concejalía de Mujer</title>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
</head>
<body id="main">
<my:cabecera/>
<my:menu/>
<br />
<my:detalleMujer mujer="${details}"/>
<br />

<my:tabpannel target="newCita">
<br />
<my:formServiceSelection listServicios="${listServicios }"/>
<c:if test="${not empty citaciones}">
<br />
<my:formCitaSelection citasDisponibles="${citaciones }"/>
</c:if>
</my:tabpannel>
</body>
</html>