package org.upsam.sypweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.upsam.sypweb.domain.user.UserDTO;
import org.upsam.sypweb.facade.MujerServiceFacade;

public class AbstractController {

	/**
	 * Servicio que implementa la lógica de negocio relativa a las fichas
	 */
	protected MujerServiceFacade mujerServiceFacade;

	/**
	 * @param mujerServiceFacade
	 */
	public AbstractController(MujerServiceFacade mujerServiceFacade) {
		super();
		this.mujerServiceFacade = mujerServiceFacade;
	}

	protected void referenceData(Long mujerId, Model model) {
		model.addAttribute("details", mujerServiceFacade.find(mujerId));
	}

	protected Integer getServicioId(HttpSession session) {
		return ((UserDTO) session.getAttribute("user")).getServicio().getId();
	}
}
