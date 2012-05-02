package org.upsam.sypweb.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jndi.JndiTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.upsam.sypweb.domain.servicio.ServicioService;

@Component
public class ConcejaliaAuthenticationSuccess implements AuthenticationSuccessHandler {
	/**
	 * Servicio {@link ServicioService}
	 */
	private ServicioService servicioService;
	/**
	 * Estrategia de redirección
	 */
	private RedirectStrategy redirectStrategy;
	/**
	 * Template para búsquedas JNDI
	 */
	private JndiTemplate jndiTemplate;
	/**
	 * Nombre JNDI del bean de histórico
	 */
	private @Value("${appointmentHistoryBean}") String appointmentHistoryJndiName;

	/**
	 * @param servicioService
	 */
	@Inject
	public ConcejaliaAuthenticationSuccess(ServicioService servicioService, JndiTemplate jndiTemplate) {
		super();
		this.servicioService = servicioService;
		this.redirectStrategy = new DefaultRedirectStrategy();
		this.jndiTemplate = jndiTemplate;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		session.setAttribute("user", servicioService.findUserByUserName(authentication.getName()));
		try {
			session.setAttribute("history", jndiTemplate.lookup(appointmentHistoryJndiName));
		} catch (NamingException e) {
			e.printStackTrace();
		}
		redirectStrategy.sendRedirect(request, response, "/mujeres/buscar");
	}

}
