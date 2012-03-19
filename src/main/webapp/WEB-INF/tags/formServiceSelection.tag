<!-- FORMULARIO SELECCIÓN SERVICIO -->
<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="listServicios" required="true" type="java.util.List" %>
<c:set var="submitUrl">
	<c:url value="/cita/new" />
</c:set>
<form:form method="POST" commandName="citacion" modelAttribute="citacion" action="${submitUrl}">
<table class="box3" cellpadding="2" cellspacing="2" width="60%" align="center">
<tr>
	<td height="20" width="25%" align="right">
		<label class="dlabel">Seleccione el servicio:</label>
	</td>
	<td width="50%">
		<form:select path="servicioId" cssClass="dlist"> 
			<form:options items="${listServicios}" itemLabel="service" itemValue="id" />
		</form:select>
	</td>
	<td width="25%">
		<input type="submit" name="_target1" value="Aceptar" />
	</td>
</tr>
</table>
</form:form>
<!-- FIN FORMULARIO SELECCIÓN SERVICIO -->