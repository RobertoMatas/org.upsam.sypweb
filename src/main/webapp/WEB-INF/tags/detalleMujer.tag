<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="mujer" required="true" type="org.upsam.sypweb.view.MujerDetailedView" %>
<div align="center">
<table class="list" width="85%" align="center">
	<tr class="fila1">
		<td width="5%" height="21" align="center">
			<a href="<c:url value="/mujeres/edit"><c:param name="mujerId" value="${mujer.id}"/></c:url>">
			<img src="<c:url value="/resources/img/modificar.gif"/>" border="0" /></a>
		</td>
		<td width="80%" class="col2"><label class="label0"><c:out value="${mujer.apellido1}" />&nbsp;<c:out value="${mujer.apellido2}" />,&nbsp;<c:out value="${mujer.nombre}" /></label></td>
		<td width="15%" class="col1"><label class="dlabel">DNI:&nbsp;</label><label class="label0"><c:out value="${mujer.dni}" /></label></td>
	</tr>
	<tr>
		<td colspan="3">
		<table width="100%" cellpadding="0" cellspacing="0" class="box1b"
			align="center"">
			<tr>
				<td width="1%">&nbsp;</td>
				<td width="8%" height="31" align="left">
					<label class="dlabel">Domicilio:</label>
				</td>
				<td width="33%">
					<label class="label0">
						<c:out value="${mujer.domicilio.tipoDireccion}" />&nbsp;
						<c:out value="${mujer.domicilio.nombreAvenida}" />&nbsp;
						<%--<c:out value="${mujer.domicilio.numero}" />&nbsp; --%>
						<c:out value="${mujer.domicilio.piso}" />&nbsp;
						<c:out value="${mujer.domicilio.letra}" />&nbsp;
					</label>
					<%--
					<label class="dlabel">Escalera:&nbsp;</label>
					<label class="label0"><c:out value="${mujer.domicilio.escalera}" /></label>
					 --%>
				</td>
				<td width="9%" align="left">
					<label class="dlabel">Población:</label>
				</td>
				<td width="22%">
					<label class="label0"><c:out value="${mujer.domicilio.poblacion}" /></label>
				</td>
				<td width="7%" align="left">
					<label class="dlabel">Provincia:</label>
				</td>
				<td width="20%">
					<label class="label0"><c:out value="${mujer.domicilio.nombreProvincia}" /></label>
				</td>
			</tr>
			<tr>
				<td width="1%">&nbsp;</td>
				<td width="8%" height="35" align="left">
					<label class="dlabel">Fecha	Nac.: </label>
				</td>
				<td width="33%">
					<label class="label0"><fmt:formatDate value="${mujer.fechaNac}" dateStyle="long" /></label>
				</td>
				<td width="9%" align="left">
					<label class="dlabel">Telf. Fijo: </label>
				</td>
				<td width="22%">
					<label class="label0"><c:out value="${mujer.telfFijo}" /></label>
				</td>
				<td width="7%" align="left">
					<label class="dlabel">Telf. Móvil: </label>
				</td>
				<td width="20%">
					<label class="label0"><c:out value="${mujer.telfMovil}" /></label>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td height="36" align="left">
					<label class="dlabel">Fecha Alta: </label>
				</td>
				<td>
					<label class="label0"><fmt:formatDate value="${mujer.fechaAlta}" dateStyle="long" /></label>
				</td>
				<td align="left">
					<label class="dlabel">Empadronad@: </label>
				</td>
				<td>
					<c:if test="${! mujer.empadronada}">
						<img src="<c:url value="/resources/img/pto-roj.gif" />" />
					</c:if>
					<c:if test="${mujer.empadronada}">
						<img src="<c:url value="/resources/img/pto-ver.gif" />" />
					</c:if>
				</td>
				<td class="dlabel" align="left">Email:</td>
				<td><label class="label0"><c:out value="${mujer.email}" /></label></td>
			</tr>
		</table>
		<table width="100%">
			<tr>
				<td width="50%">
				<div class="scroll">
				<table width="100%" border="1px" cellpadding="0" cellspacing="0"
					class="box3">

					<tr class="head2">
						<td height="18" colspan="8"><label>Servicios Utilizados</label></td>
					</tr>
					<tr>
						<td width="41%" align="center"><label class="dlabel">Servicio</label></td>
						<td width="59%" align="center"><label class="dlabel">Responsable</label></td>
					</tr>					
					<c:forEach var="servicio" items="${mujer.usedServices}">
					<tr>
						<td>
							<label class="label0"><c:out value="${servicio.service}" /></label>
						</td>
						<td>
							<label class="label0">
								<c:out value="${servicio.responsable}" />
							</label>
						</td>
					</tr>
					</c:forEach>										
				</table>
				</div>
				</td>
				
				<td width="50%">
				<div class="scroll">
				<table width="100%" border="1" cellpadding="0" cellspacing="0"
					class="box3">
					<tr class="head2">
						<td height="18" colspan="9">Aula Abierta</td>
					</tr>
					<tr>
						<td align="center"><label class="dlabel">Taller</label></td>
						<td align="center"><label class="dlabel">F. Inicio</label></td>
						<td align="center"><label class="dlabel">F. Fin</label></td>
					</tr>
					<c:forEach var="aula" items="${mujer.talleres}">
					<tr>
						<td>
							<label class="label0"><c:out value="${aula.taller}" /></label>
						</td>
						<td>
							<label class="label0">
								<fmt:formatDate value="${aula.inicio}" pattern="EEEE, dd/MM/yyyy" />
							</label>
						</td>
						<td>
							<label class="label0">
								<fmt:formatDate value="${aula.fin}" pattern="EEEE, dd/MM/yyyy" />
							</label>
						</td>
					</tr>
					</c:forEach>
				</table>
				</div>
				</td>
				 
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>