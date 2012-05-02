<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- MENU -->
<div align="center">
<div class="page-container">
	<div class="dropnav">
      <ul>
        <li>
			<a href="<c:url value="/inicio.htm" />">Inicio</a>
		</li>
      </ul>       
      <ul>
        <li>
			<a href="<c:url value="/mujeres/edit" />">Registrar Mujer</a>
		</li>
      </ul>       
      <ul>
        <li>
			<a href="<c:url value="/mujeres/buscar" />">Consultar Mujeres</a>
		</li>
      </ul>
      <ul>
        <li>
			<a href="<c:url value="/cita/history" />">Mis citas concedidas</a>
		</li>
      </ul>
      <ul>
        <li><a href="<c:url value="/logout" />">Salir</a>
        </li>
      </ul>        
    </div>
 </div>
 </div>
<!-- FIN MENU -->