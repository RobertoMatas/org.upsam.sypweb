<!-- LISTADO DE DOCUMENTOS ADJUNTOS -->
<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="adjuntos" required="true" type="java.util.List" %>
<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
<!-- Listado de documentos adjuntos a la ficha -->
<table border="1px" cellpadding="0" cellspacing="0" class="box3" align="center" width="85%">
	<tr>
		<th height="21" align="center"><label class="dlabel">&nbsp;</label></th>
		<th align="center"><label class="dlabel">Descripción</label></th>
	</tr>
	<c:forEach var="doc" items="${adjuntos}">
		<tr>
			<td height="18" width="20%" align="center">
				<a href="<c:url value="/ficha/doc/show"><c:param name="docId" value="${doc.id}"/></c:url>" target="_blank">
					<c:choose>
						<c:when test="${doc.tipo eq 'application/pdf'}">
							<img src="<c:url value="/resources/img/pdf.gif" />" border="0" />
						</c:when>
						<c:when test="${doc.tipo eq 'text/plain'}">
							<img src="<c:url value="/resources/img/text-file.gif" />" border="0" />
						</c:when>
						<c:when test="${doc.tipo eq 'application/msword'}">
							<img src="<c:url value="/resources/img/ms-word.gif" />" border="0" />
						</c:when>
						<c:when test="${doc.tipo eq 'application/x-zip-compressed'}">
							<img src="<c:url value="/resources/img/zip-file.gif" />" border="0" />
						</c:when>
						<c:when test="${doc.tipo eq 'application/vnd.ms-excel'}">
							<img src="<c:url value="/resources/img/excel-file.gif" />" border="0" />
						</c:when>
						<c:otherwise>
							<img src="<c:url value="/resources/img/file.gif" />" border="0" />
						</c:otherwise>
					</c:choose>
				</a>
			
			</td>
			<td width="80%"><label class="label0">
				<c:out value="${doc.descripcion}" /></label></td>
		</tr>
	</c:forEach>
</table>
</sec:authorize>
<!-- FIN LISTADO DE DOCUMENTOS ADJUNTOS -->