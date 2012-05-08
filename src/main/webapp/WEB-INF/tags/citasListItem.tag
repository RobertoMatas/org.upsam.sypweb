<!-- LISTADO DE CITAS -->
<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="cita" required="true" type="org.upsam.sypweb.view.CitacionView" %>
<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
<table class="list" width="100%">
	<tr class="fila1">
		<td width="5%" height="21" align="center">
			<a href=
			"<c:url value="/ficha/open">
				<c:param name="citaId" value="${cita.id}"/>
				<c:param name="mujerId" value="${cita.mujer.id}"/>
			</c:url>">
			<img src="<c:url value="/resources/img/seleccionar.gif" />" border="0" /></a>
		</td>
		<td width="80%" class="col2"><label class="label0"><c:out value="${cita.mujer.apellido1}" />&nbsp;<c:out value="${cita.mujer.apellido2}" />,&nbsp;<c:out value="${cita.mujer.nombre}" /></label></td>
		<td width="15%" class="col1" align="center"><label class="dlabel">${fn:substring(cita.hora,0,2)}:${fn:substring(cita.hora,2,4)}&nbsp;horas</label></td>
	</tr>
	<tr>
		<td colspan="3">
			<table width="100%" cellpadding="0" cellspacing="0" class="box1b" align="center">
			  <tr>
			  	<td width="1%">&nbsp;</td>
				<td width="8%" height="28" align="left">
					<label class="dlabel">Domicilio: </label>
				</td>
				<td width="21%">
					<label class="label0">
						<c:out value="${cita.mujer.domicilio.tipoDireccion}" />&nbsp;
						<c:out value="${cita.mujer.domicilio.nombreAvenida}" />&nbsp;
						<c:out value="${cita.mujer.domicilio.numero}" />&nbsp;
						<c:out value="${cita.mujer.domicilio.piso}" />&nbsp;
						<c:out value="${cita.mujer.domicilio.letra}" />&nbsp;
					</label>
				</td>
				<td width="8%" align="left">
					<label class="dlabel">Población: </label>
				</td>
				<td width="26%">
					<label class="label0"><c:out value="${cita.mujer.domicilio.poblacion}" /></label>
				</td>
				<td width="9%" align="left">
					<label class="dlabel">Provincia: </label>
				</td>
				<td width="27%">
					<label class="label0"><c:out value="${cita.mujer.domicilio.nombreProvincia}" /></label>
				</td>
			  </tr>
			</table>
		</td>
	</tr>
</table>
</sec:authorize>
<!-- FIN LISTADO DE CITAS -->