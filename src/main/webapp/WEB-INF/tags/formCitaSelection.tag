<!-- FORMULARIO SELECCIÓN CITA -->
<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="citasDisponibles" required="true" type="java.util.List" %>
<form:form method="POST">
<table border="1px" cellpadding="0" cellspacing="0" class="box3" align="center" width="60%">

	<tr>
		<th height="18" align="center" width="5%">&nbsp;</th>
		<th align="center" width="70%"><label class="dlabel">Fecha</label></th>
		<th align="center" width="25%"><label class="dlabel">Hora</label></th>
	</tr>
	<c:forEach var="citaDis" items="${citasDisponibles}">
		<tr>
			<td align="center">
				<c:choose>
					<c:when test="${citaDis.id eq 1}">
						<input border="0" type="radio" name="citasel" value="<c:out value="${citaDis.id}" />" checked="checked" />
					</c:when>
					<c:otherwise>
						<input border="0" type="radio" name="citasel" value="<c:out value="${citaDis.id}" />" />
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<label class="label0">
				<fmt:formatDate value="${citaDis.cita}" pattern="EEEE, dd 'de' MMMM 'de' yyyy" />
				</label>
			</td>
			<td align="center">
				<label class="label0">
					<tab:formatHour hora="${citaDis.hora}" />&nbsp;horas				
				</label>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<center>
	<input type="submit" name="_finish" value="Aceptar" />
</center>
</form:form>
<!-- FIN FORMULARIO SELECCIÓN CITA -->