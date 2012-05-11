<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adjuntar Documento</title>
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
</head>
<body id="main">
<my:cabecera />
<my:menu />
<br />
<my:detalleMujer mujer="${details}"/>
<br />
<c:set var="submitUrl">
	<c:url value="/ficha/seg/add" />
</c:set>
<my:tabpannel target="/ficha/resumen" subtarget="doc">
<c:out value="${requestScope.error }" />
<form:form method="POST" commandName="doc" modelAttribute="doc" enctype="multipart/form-data">
<input type="hidden" name="mujerId" value="${details.id}" />
<table width="85%" border="0" align="center" class="box1b" cellpadding="5" cellspacing="5">
    <tr>
    	<td height="40" width="33%" align="right">
    		<label class="dlabel">Introduzca la descripción del documento:</label>
    	</td>
    	<td width="67%">
    		<form:input path="descripcion" size="80" maxlength="80" /><form:errors path="descripcion"><span class="error">&nbsp;*</span></form:errors>    		
    	</td>
    </tr>
    <tr>
    	<td height="40" width="33%" align="right">
    		<label class="dlabel">Seleccione el fichero a adjuntar:</label>
    	</td>
    	<td width="67%">
    		<form:input path="file" type="file" />
    		<!-- <input type="file" name="doc.file" size="66" /><form:errors path="file"><span class="error">&nbsp;*</span></form:errors> -->    		
    	</td>
    </tr>
     <tr>
    	<td height="50" colspan="2" align="center" valign="middle">
			<input type="submit" name="adjuntar" value="Adjuntar" />
    	</td>
    </tr>
</table>
<br />
</form:form>
</my:tabpannel>

</body>
</html>