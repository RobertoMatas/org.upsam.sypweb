<!-- TAB PANNEL -->
<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="target" required="true" type="java.lang.String" %>
<c:set var="tabs" value="listarCitas,newCita,addFicha,listarFichas,aulaAbierta" />
<c:set var="tabText">Citas,Nueva Cita,Ficha,Histórico Fichas,Aula Abierta</c:set>
<table cellpadding="0" cellspacing="0" border="0" width="85%" align="center" >
<tr>
<td class="bgcolor1">
	<div id="header">
		<ul>
			<c:forTokens items="${tabs }" delims="," var="aTab" varStatus="status">
				<c:choose>
					<c:when test="${target eq aTab }">
						<li id="nav-main">
							<a href="${aTab}"><c:out value="${fn:split(tabText, ',')[status.index] }" /></a>
						</li>					
					</c:when>
					<c:otherwise>
						<li id="nav-off">
							<a href="${aTab}"><c:out value="${fn:split(tabText, ',')[status.index] }" /></a>
						</li>	
					</c:otherwise>
				</c:choose>
			</c:forTokens>

		</ul>
	</div>
</td>
</tr>
</table>

<table id="boxcaja" class="box2" width="85%" align="center" cellpadding="2" cellspacing="2">

<tr><td width="100%">

<jsp:doBody />

<br />
</td></tr></table>

<!-- FIN TAB PANNEL -->