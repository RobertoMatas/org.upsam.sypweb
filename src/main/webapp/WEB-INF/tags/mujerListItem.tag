<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="mujer" required="true" type="org.upsam.sypweb.view.MujerView" %>
<table class="list" width="100%">
	<tr class="fila1">
		<td width="5%" height="21" align="center">
			<a href="<c:url value="/listarCitas.htm"><c:param name="mujerId" value="${mujer.id}"/></c:url>"> <img src="<c:url value="/resources/img/seleccionar.gif" />" border="0" /></a>
		</td>
		<td width="80%" class="col2"><label class="label0"><c:out value="${mujer.apellido1}" />&nbsp;<c:out value="${mujer.apellido2}" />,&nbsp;<c:out
			value="${mujer.nombre}" /></label></td>
		<td width="15%" class="col1"><label class="dlabel">DNI:&nbsp;</label><label class="label0"><c:out value="${mujer.dni}" /></label></td>
	</tr>
	<tr>
		<td colspan="3">
		<table width="100%" cellpadding="0" cellspacing="0" class="box1b" align="center">
			<tr>
				<td width="1%">&nbsp;</td>
				<td width="8%" height="31" align="left"><label class="dlabel">Domicilio: </label></td>
				<td width="21%"><label class="label0"> <c:out value="${mujer.domicilio.tipoDireccion}" />&nbsp; <c:out value="${mujer.domicilio.nombreAvenida}" />&nbsp; <c:out
					value="${persona.domicilio.numero}" />&nbsp; <c:out value="${mujer.domicilio.piso}" />&nbsp; <c:out value="${mujer.domicilio.letra}" />&nbsp; </label></td>
				<td width="8%" align="left"><label class="dlabel">Población: </label></td>
				<td width="26%"><label class="label0"><c:out value="${mujer.domicilio.poblacion}" /></label></td>
				<td width="9%" align="left"><label class="dlabel">Provincia: </label></td>
				<td width="27%"><label class="label0"><c:out value="${mujer.domicilio.nombreProvincia}" /></label></td>
			</tr>
			<tr>
				<td width="1%">&nbsp;</td>
				<td width="8%" height="30" align="left"><label class="dlabel">Fecha Nac.: </label></td>
				<td width="21%"><label class="label0"><fmt:formatDate value="${mujer.fechaNac}" dateStyle="long" /></label></td>
				<td width="8%" align="left"><label class="dlabel">Telf. Fijo: </label></td>
				<td width="26%"><label class="label0"><c:out value="${mujer.telfFijo}" /></label></td>
				<td width="9%" align="left"><label class="dlabel">Telf. Móvil: </label></td>
				<td width="27%"><label class="label0"><c:out value="${mujer.telfMovil}" /></label></td>
			</tr>
		</table>
		</td>
	</tr>
</table>