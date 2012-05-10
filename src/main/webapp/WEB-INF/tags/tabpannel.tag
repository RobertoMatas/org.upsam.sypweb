<!-- TAB PANNEL -->
<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="target" required="true" type="java.lang.String" %>
<%@ attribute name="subtarget" required="false" type="java.lang.String" %>
<c:set var="tabs" value="/cita/list,/cita/new,/ficha/resumen,/ficha/historico,/aula/resumen" />
<c:set var="tabText">Citas,Nueva Cita,Ficha,Histórico Fichas,Aula Abierta</c:set>
<table cellpadding="0" cellspacing="0" border="0" width="85%" align="center" >
<tr>
<td class="bgcolor1">
	<div id="header">
		<ul>
			<c:forTokens items="${tabs }" delims="," var="aTab" varStatus="status">
				<c:url var="tabUrl" value="${aTab}">
					<c:param name="mujerId" value="${details.id}" />
				</c:url>
				<c:choose>
					<c:when test="${target eq aTab }">
						<li id="nav-main">
							<a href="${tabUrl}"><c:out value="${fn:split(tabText, ',')[status.index]}" /></a>
						</li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${aTab eq '/aula' }">
								<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
									<li id="nav-no">
										<a><c:out value="${fn:split(tabText, ',')[status.index]}" /></a>
									</li>								
								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_ADMINISTRATIVO')">
									<li id="nav-off">
										<a href="${tabUrl}"><c:out value="${fn:split(tabText, ',')[status.index]}" /></a>
									</li>								
								</sec:authorize>
							</c:when>
							<c:when test="${aTab eq '/ficha/historico' or aTab eq '/ficha/resumen'}">
								<sec:authorize access="hasRole('ROLE_ADMINISTRATIVO')">
									<li id="nav-no">
										<a><c:out value="${fn:split(tabText, ',')[status.index]}" /></a>
									</li>								
								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
									<li id="nav-off">
										<a href="${tabUrl}"><c:out value="${fn:split(tabText, ',')[status.index]}" /></a>
									</li>								
								</sec:authorize>
							</c:when>
							<c:otherwise>
								<li id="nav-off">
									<a href="${tabUrl}"><c:out value="${fn:split(tabText, ',')[status.index]}" /></a>
								</li>	
							</c:otherwise>
						</c:choose>
						
					</c:otherwise>
				</c:choose>
			</c:forTokens>

		</ul>
	</div>
</td>
</tr>
</table>

<table id="boxcaja" class="box2" width="85%" align="center" cellpadding="2" cellspacing="2">
<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
<c:if test="${subtarget != null}">
	
	<tr class="submenu" valign="bottom">
		<td width="100%" height="25"><span>&nbsp;</span>
		<span>
			<img src="<c:url value="/resources/img/folder_new.gif" />" />&nbsp;
			<c:url var="tabUrl" value="/ficha/seg/add"><c:param name="mujerId" value="${details.id}" /></c:url>
			<c:choose>
				<c:when test="${subtarget eq 'seg'}">
					<a class="resaltado" href="${tabUrl }">Añadir Seguimiento</a>
				</c:when>
				<c:otherwise>
					<a href="${tabUrl }">Añadir Seguimiento</a>
				</c:otherwise>
			</c:choose>
			
		</span>
		<span>&nbsp;|&nbsp;</span>
				
		<span>
			<img src="<c:url value="/resources/img/icon_attachment.gif" />" />&nbsp;
			<c:url var="tabUrl" value="/ficha/doc/add"><c:param name="mujerId" value="${details.id}" /></c:url>
			<c:choose>
				<c:when test="${subtarget eq 'doc'}">
					<a class="resaltado" href="${tabUrl }">Adjuntar Documento</a>
				</c:when>
			<c:otherwise>
					<a href="${tabUrl }">Adjuntar Documento</a>
				</c:otherwise>
			</c:choose>
		</span>
		<span>&nbsp;|&nbsp;</span>

		<span>
			<img src="<c:url value="/resources/img/page_text.gif" />" />&nbsp;
			<c:url var="tabUrl" value="/ficha/resumen"><c:param name="mujerId" value="${details.id}" /></c:url>
			<c:choose>
				<c:when test="${subtarget eq 'resumen'}">
					<a class="resaltado" href="${tabUrl }">Resumen</a>
				</c:when>
				<c:otherwise>
					<a href="${tabUrl }">Resumen</a>
				</c:otherwise>
			</c:choose>
		</span>
				
		</td>
	</tr>
	<tr><td><hr /></td></tr>
</c:if>
</sec:authorize>
<tr><td width="100%">

<jsp:doBody />

<br />
</td></tr></table>

<!-- FIN TAB PANNEL -->