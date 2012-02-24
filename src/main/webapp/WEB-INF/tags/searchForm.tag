<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ attribute name="busq" required="true" type="org.upsam.sypweb.view.BusqMujerView" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="submitSearch" value="/mujeres/buscar" />
<form:form method="POST" commandName="busq" modelAttribute="busq" action="${submitSearch}"  methodParam="POST">
	<table width="85%" border="0" align="center" class="box1b">
		<tr>
			<td height="28" colspan="6" class="head1">CONSULTAR CIUDADANOS</td>
		</tr>
		<tr>
			<td align="right" width="7%" height="58">
				<label class="dlabel">Nombre:</label>
			</td>
			<td width="23%">
				<form:input path="nombre" size="38" />
			</td>
			<td width="11%" align="right">
				<label class="dlabel">Primer Apellido:</label>
			</td>
			<td width="23%">
				<form:input path="apellido1" size="38" />
			</td>
			<td width="11%" align="right">
				<label class="dlabel">Segundo Apellido:</label>
			</td>
			<td width="25%">
				<form:input path="apellido2" size="38" />
			</td>
		</tr>
		<tr>
			<td height="58" align="right">
				<label class="dlabel">DNI:</label>
			</td>
			<td>
				<form:input path="dni" size="38" />
			</td>
			<td align="right">
				<label class="dlabel">Teléfono Fijo:</label>
			</td>
			<td>
				<form:input path="telfFijo" size="38" />
			</td>
			<td align="right">
				<label class="dlabel">Teléfono Móvil:</label>
			</td>
			<td>
				<form:input path="telfMovil" size="38" />
			</td>
		</tr>
	</table>
	<br />
	<center>
		<input name="buscar" type="submit" value="Buscar" class="dboton" />
	</center>
</form:form>