package org.upsam.sypweb.controller.ficha;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.upsam.sypweb.controller.AbstractController;
import org.upsam.sypweb.domain.ficha.FichaService;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.facade.MujerServiceFacade;
import org.upsam.sypweb.view.FichaView;

@Controller
@RequestMapping("/ficha")
@SessionAttributes("ficha")
public class FichaController extends AbstractController {
	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private FichaService fichaService;
	
	@Inject
	public FichaController(FichaService fichaService, MujerServiceFacade mujerServiceFacade) {
		super(mujerServiceFacade);
		this.fichaService = fichaService;
	}
	
	@ModelAttribute("ficha")
	public FichaView modelAttribute(@RequestParam Long mujerId, HttpSession session) {
		return fichaService.findFichaAbierta(mujerId, getServicioId(session));
	}

	@RequestMapping("/open")
	public String abrirFicha(@RequestParam Long citaId, @RequestParam Long mujerId, HttpSession session, Model model) {		
		FichaView ficha = fichaService.abrirFicha(citaId, mujerId, getUserName(session));
		if (StringUtils.hasText(ficha.getDescripcion())) {
			return resumenFicha(ficha, mujerId, session, model);
		}
		return editFicha(ficha, mujerId, session, model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editFicha(@ModelAttribute("ficha") FichaView ficha, @RequestParam Long mujerId, HttpSession session, Model model) {
		referenceData(mujerId, model);
		return "ficha/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editFichaSubmit(@ModelAttribute("ficha") FichaView ficha, HttpSession session, Model model, SessionStatus status) {
		fichaService.save(ficha);
		status.setComplete();
		return resumenFicha(ficha, ficha.getMujer().getId(), session, model);
	}

	@RequestMapping("/resumen")
	public String resumenFicha(@ModelAttribute("ficha") FichaView ficha, @RequestParam Long mujerId, HttpSession session, Model model) {
		referenceData(mujerId, model);
		if (! StringUtils.hasText(ficha.getDescripcion())) {
			return editFicha(ficha, mujerId, session, model);
		} 
		model.addAttribute("ficha", ficha);
		return "ficha/resumen";
	}
	
	@RequestMapping(value = "/close", method = RequestMethod.GET)
	public String close(@RequestParam Long fichaId, @RequestParam Long mujerId, HttpSession session, Model model, SessionStatus status) {
		fichaService.close(fichaId);
		status.setComplete();
		return history(mujerId, session, model);
	}
	
	@RequestMapping(value = "/historico", method = RequestMethod.GET)
	public String history(@RequestParam Long mujerId, HttpSession session, Model model) {
		referenceData(mujerId, model);
		model.addAttribute("history", fichaService.history(mujerId));
		return "ficha/history";
	}
}
