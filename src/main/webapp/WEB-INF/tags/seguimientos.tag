<!-- LISTADO DE SEGUIMIENTOS -->
<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="seguimientos" required="true" type="java.util.List" %>
<sec:authorize access="hasRole('ROLE_ESPECIALISTA')">
<table border="1px" cellpadding="0" cellspacing="0"	class="box3" align="center" width="85%">
	<tr>
		<th height="18" align="center"><label class="dlabel">Fecha</label></th>
		<th align="center"><label class="dlabel">Observaciones</label></th>
	</tr>
	<c:forEach var="seg" items="${seguimientos}">
		<tr>
			<td height="21" width="20%"><label class="label0">
				<fmt:formatDate value="${seg.fecha}" pattern="EEEE, dd/MM/yyyy" /></label></td>
			<td width="80%"><label class="label0">
				<c:out value="${seg.observaciones}" /></label>
			</td>
		</tr>
	</c:forEach>
</table>
</sec:authorize>
<!-- FIN LISTADO DE SEGUIMIENTOS -->