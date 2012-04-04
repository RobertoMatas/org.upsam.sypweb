<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Concejalía de Mujer</title>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value="/resources/js/calendariojs/css/micalendario.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/js/calendariojs/css/layouts/small.css" />" />
<script type="text/javascript" src="<c:url value="/resources/js/calendariojs/utils/zapatec.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/calendariojs/js/calendar.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/calendariojs/js/calendar-sp.js" />"></script>
</head>
<body id="main">
<my:cabecera/>
<my:menu/>
<br />
<c:url var="urlSubmit" value="/mujeres/edit" />
<form:form method="POST" commandName="mujer" modelAttribute="mujer" action="${urlSubmit}">
<center><form:errors path="dni" cssClass="error" /></center>
<center><form:errors path="nombre" cssClass="error" /></center>
<center><form:errors path="apellido1" cssClass="error" /></center>
<center><form:errors path="apellido2" cssClass="error" /></center>
<br />

<form:hidden path="id"/>
<table width="85%" border="0" align="center" class="box1b" cellpadding="5" cellspacing="5">
	<tr>
    	<td height="25" class="head1">REGISTRO CIUDADAN@S</td>
  	</tr>
    <tr>
    	<td>
			<table align="center" width="90%" class="box3" cellpadding="3" cellspacing="3">
				<tr>
					<td class="titulo" colspan="6">Datos Personales</td>
				</tr>
				<tr>
					<td width="3%" height="40" align="right">
						<label class="dlabel">Nombre:</label>
				  	</td>
   					<td width="20%">
   						<form:input path="nombre" size="30" cssErrorClass="derror" />
   				  	</td>
    				<td width="23%" align="right">
						<label class="dlabel">Primer Apellido:</label>
				  	</td>
    				<td width="20%">
    					<form:input path="apellido1" size="30" cssErrorClass="derror" />
				  	</td>
    				<td width="20%" align="right">
						<label class="dlabel">2º Apellido:</label>
				  	</td>
    				<td width="20%">
    					<form:input path="apellido2" size="30" cssErrorClass="derror" />
				  	</td>
  				</tr>
				<tr>
					<td width="3%" height="37" align="right">
						<label class="dlabel">DNI:</label>
				  </td>
   					<td width="20%">
   						<form:input path="dni" size="30" cssErrorClass="derror" />
    				</td>
    				<td width="20%" align="right">
						<label class="dlabel">Fecha Nac.:</label>
					</td>
    				<td>
    					<form:input path="fechaNac" size="12" maxlength="10" />
    					<img align="middle" src="<c:url value="/resources/js/calendariojs/icons/calendar1.gif" />" border="0" id="icon"  onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />
    						<script type="text/javascript">
							Zapatec.Calendar.setup({
								firstDay	: 1,
								weekNumbers	: false,
								electric	: false,
								inputField	: "fechaNac",
								button		: "icon",
								ifFormat	: "%d/%m/%Y",
								daFormat	: "%d/%m/%Y",
								step		: 1,
								noHelp		: false
							});
						</script>
					</td>
					<td width="20%" align="right">
						<label class="dlabel">Email:</label>
				  	</td>
    				<td width="20%">
    					<form:input path="email" size="30" maxlength="50" cssErrorClass="derror" />
				  	</td>
  				</tr>
		  </table>		
		</td>
  	</tr>

    <tr>
    	<td>
			<table align="center" width="90%" class="box3" cellpadding="3" cellspacing="3">
				<tr>
					<td class="titulo" colspan="9">Domicilio</td>
				</tr>
				<tr>
					<td>
						<label class="dlabel">Empadronad@:</label>					
					</td>
					<td>
						<form:checkbox path="empadronada" />
					</td>
					<td height="34" align="right">
						<label class="dlabel">Dirección:</label>				  	
					</td>
					<td colspan="3" align="left">
						<form:select path="domicilio.tipoDireccionId" cssClass="dlist"> 
							<form:options items="${listTipoDir}" itemLabel="tipo" itemValue="id" />
						</form:select>
					</td>
					<td colspan="4" align="left">
						<form:input path="domicilio.nombreAvenida" size="70"/>
					</td>					
				</tr>
				
				<tr>
					<td width="9%" height="34" align="right">
						<label class="dlabel">Número:</label>
					</td>
					<td width="10%">
						<form:input path="domicilio.numero" size="6" maxlength="5" />
					</td>
					<td width="6%" align="right">	
						<label class="dlabel">Piso:</label>
					</td>
					<td width="8%">
						<form:input path="domicilio.piso" size="6" maxlength="5" />
					</td>
				  	<td>&nbsp;</td>
					<td width="10%" align="right">	
						<label class="dlabel">Letra:</label>
					</td>
					<td width="7%">	
						<form:input path="domicilio.letra" size="5" maxlength="1" />
					</td>
					<td width="9%" align="right">					
						<label class="dlabel">Escalera:</label>
					</td>
					<td width="41%">	
						<form:input path="domicilio.escalera" size="6" />
					</td>
				</tr>
				<tr>
				  <td height="34" align="right">
				  	<label class="dlabel">Provincia:</label>		
				  </td>
				  <td colspan="3">				    
				  	<form:select path="domicilio.provinciaId" cssClass="dlist">
						<form:options items="${listProvincias}" itemLabel="nombre" itemValue="id" />
					</form:select>
				  </td>
				  <td colspan="2" align="right">
				  	<label class="dlabel">Población:</label>
				  </td>
				  <td colspan="3">
				  	<form:input path="domicilio.poblacion" size="70" />
				  </td>
			  </tr>
		  </table>		
		</td>
  	</tr>

    <tr>
    	<td>
			<table align="center" width="90%" class="box3" cellpadding="3" cellspacing="3">
				<tr>
					<td class="titulo" colspan="4">Otros</td>
				</tr>
				<tr>
					<td align="right">
						<label class="dlabel">Teléfono Fijo:</label>						
					</td>
					<td>
						<form:input path="telfFijo" size="20" maxlength="10" />
					</td>
					<td align="right">
						<label class="dlabel">Teléfono Móvil:</label>		
				  	</td>
					<td>
						<form:input path="telfMovil" size="20" maxlength="10" />
					</td>
				</tr>

		  </table>		
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