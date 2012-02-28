package org.upsam.sypweb.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerService;

@Controller
@RequestMapping("/mujeres/edit")
@SessionAttributes("mujer")
public class RegisterMujerController {
	/**
	 * Servicio para la gestión de mujeres
	 */
	private MujerService mujerService;

	/**
	 * @param mujerService
	 */
	@Inject
	public RegisterMujerController(MujerService mujerService) {
		super();
		this.mujerService = mujerService;
	}

	@ModelAttribute("mujer")
	public Mujer modelAttribute(@RequestParam(required = false) Long mujerId) {
		return mujerId != null ? mujerService.find(mujerId) : new Mujer();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm(Model model) {
		referenceData(model);
		return "addMujerForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitEditForm(@Valid @ModelAttribute Mujer mujer, BindingResult result, Model model, SessionStatus status) {
		if (!result.hasErrors()) {
			mujerService.save(mujer);
			status.setComplete();
			return "redirect:/mujeres/buscar";
		}
		return searchForm(model);
	}

	private void referenceData(Model model) {
		model.addAttribute("listProvincias", mujerService.getProvincias());
		model.addAttribute("listTipoDir", mujerService.getTiposDireccion());
	}
}
