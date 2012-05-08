<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<c:set var="submitUrl">
<c:url value="/ficha/edit" />
</c:set>
<form:form method="POST" commandName="ficha" modelAttribute="ficha" action="${submitUrl}">
<table width="85%" border="0" align="center" class="box1b" cellpadding="5" cellspacing="5">
	<tr>
    	<td height="22" class="head1">GESTIÓN DE FICHAS</td>
  	</tr>
    <tr>
    	<td height="22">
    		<label class="dlabel">Introduzca el motivo de la consulta:</label>
    	</td>
    </tr>
	<tr>
    	<td>
    		<form:textarea path="descripcion" cssErrorClass="derror" rows="3" cols="172" />
    	</td>
    </tr>
    <tr>
    	<td>
    		<label class="dlabel">Fecha de apertura:</label>
    		<label class="label0"><fmt:formatDate value="${ficha.apertura}" dateStyle="long" /></label>
    	</td>
    </tr>
</table>
<br />
<center>
	<input type="submit" name="aceptar" value="Aceptar" />
</center>
</form:form>
</body>
</html>