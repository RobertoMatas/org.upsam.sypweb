<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet" type="text/css" />
</head>

<body id="main">
	
	<c:if test="${not empty param.login_error}">
    	<p class="">
        Your login attempt was not successful, try again.<br/><br/>
        Reason: <c:out value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
        </p>
    </c:if>
	
	<form id="loginForm" action="<c:url value="/j_spring_security_check" />" method="POST">
	<center>
		<table width="439" height="196" class="login">
  			<tr>
			    <td height="54" colspan="2" align="left">
					<label class="dlabel">Introduzca su nombre de usuario y contraseña:</label>
				</td>
    		</tr>
  			<tr>
    			<td width="178" height="33" align="right">
	  				<label class="dlabel">Usuario:</label>	
				</td>
				<td width="249">
					<input type="text" name="j_username" id="username" value="${sessionScope.SPRING_SECURITY_LAST_USERNAME}" class="formulario" />
				</td>
			</tr>
	 		<tr>
				<td height="35" align="right">
					<label class="dlabel">Contraseña:</label>
				</td>
				<td>
					<input type="password" name="j_password" id="password" value="" class="formulario" />
				</td>
		    </tr> 
			<tr>
    			<td height="62" colspan="2" align="center">
					<input type="submit" name="logearse" value="Aceptar" />
				</td>
    		</tr>
		</table>
	</center>
	</form>
</body>
</html>
