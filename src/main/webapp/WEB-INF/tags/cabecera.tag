<!-- CABECERA -->
<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div align="center">
<table width="85%" class="cabecera" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td width="504" class="logo"></td>
		<td width="321">&nbsp;</td>
		<td width="219">
			<table width="100%" align="center" cellpadding="6">
				<tr> 
					<td height="39" colspan="2" align="center">Concejal&iacute;a de Mujer </td>
				</tr>
				<tr colspan="2">
				 	<td height="26" align="right">
				  		<label class="dlabel">Usuario:</label>
				  </td>
				  	<td>
				  		<label class="label0">
				  			<sec:authentication property="principal.username" />
				  		</label>	
					</td>
			  	</tr>
				<tr>
					<td height="37" colspan="2" align="center">
				  		<img src="<c:url value="/resources/img/user-group4.gif" />" />
						<label class="dlabel">
							<sec:authorize access="hasRole('ROLE_ADMINISTRATIVO')">
								Administrativo
							</sec:authorize>
							<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
								<c:out value="${sessionScope.user.servicio.descripcion }" />
							</sec:authorize>
						</label>
				  </td>
			  	</tr>
			</table>
	  	</td>	
	  <td width="1%"></td>	
	</tr>    
</table>
</div>
<!-- FIN CABECERA -->