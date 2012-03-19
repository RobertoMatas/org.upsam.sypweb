package org.upsam.sypweb.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.facade.MujerServiceFacade;

@Controller
public class CitasController {
	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private MujerServiceFacade mujerServiceFacade;

	/**
	 * @param mujerService
	 */
	@Inject
	public CitasController(MujerServiceFacade mujerServiceFacade) {
		super();
		this.mujerServiceFacade = mujerServiceFacade;
	}


	@RequestMapping("/listarCitas")
	public String listarCitas(@RequestParam(required = true) Long mujerId, Model model) {
		model.addAttribute("details", mujerServiceFacade.find(mujerId));
		return "listarCitas";
	}
}
