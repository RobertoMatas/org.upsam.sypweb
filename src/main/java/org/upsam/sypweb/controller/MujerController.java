package org.upsam.sypweb.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.upsam.sypweb.domain.mujer.MujerService;
import org.upsam.sypweb.view.BusqMujerView;

@Controller
@RequestMapping("/mujeres/buscar")
@SessionAttributes("busq")
public class MujerController {
	/**
	 * Servicio para la gestión de mujeres
	 */
	private MujerService mujerService;

	/**
	 * @param mujerService
	 */
	@Inject
	public MujerController(MujerService mujerService) {
		super();
		this.mujerService = mujerService;
	}

	@ModelAttribute("busq")
	public BusqMujerView modelAttribute() {
		return new BusqMujerView();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "searchForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitSearchForm(@ModelAttribute BusqMujerView busq, Model model, SessionStatus status) {
		model.addAttribute("mujeres", mujerService.findAll(busq));
		status.setComplete();
		return "searchResults";
	}
}
