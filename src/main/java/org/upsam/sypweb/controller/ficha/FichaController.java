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
import org.upsam.sypweb.domain.ficha.FichaService;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.user.UserDTO;
import org.upsam.sypweb.facade.MujerServiceFacade;
import org.upsam.sypweb.view.FichaView;

@Controller
@RequestMapping("/ficha")
@SessionAttributes("ficha")
public class FichaController {
	/**
	 * Servicio que implementa la lógica de negocio relativa a las fichas
	 */
	private FichaService fichaService;
	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private MujerServiceFacade mujerServiceFacade;

	/**
	 * @param fichaService
	 */
	@Inject
	public FichaController(FichaService fichaService, MujerServiceFacade mujerServiceFacade) {
		super();
		this.fichaService = fichaService;
		this.mujerServiceFacade = mujerServiceFacade;
	}
	
	@ModelAttribute("ficha")
	public FichaView modelAttribute(@RequestParam Long mujerId, HttpSession session) {
		return fichaService.findFichaAbierta(mujerId, getServicio(session));
	}

	@RequestMapping("/open")
	public String abrirFicha(@RequestParam Long citaId, @RequestParam Long mujerId, HttpSession session, Model model) {		
		FichaView ficha = fichaService.abrirFicha(citaId, mujerId, ((UserDTO) session.getAttribute("user")).getUserName());
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

	private Integer getServicio(HttpSession session) {		
		return ((UserDTO) session.getAttribute("user")).getServicio().getId();
	}
	
	private void referenceData(Long mujerId, Model model) {
		model.addAttribute("details", mujerServiceFacade.find(mujerId));
	}
}
