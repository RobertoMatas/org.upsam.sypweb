package org.upsam.sypweb.controller.ficha;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import org.upsam.sypweb.view.SeguimientoView;

@Controller
@RequestMapping("/ficha/seg")
@SessionAttributes("seg")
public class SeguimientosController extends AbstractController {

	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private FichaService fichaService;
	
	@Inject
	public SeguimientosController(MujerServiceFacade mujerServiceFacade, FichaService fichaService) {
		super(mujerServiceFacade);
		this.fichaService = fichaService;
	}

	@ModelAttribute("seg")
	public SeguimientoView modelAttribute(@RequestParam Long mujerId, HttpSession session) {
		FichaView ficha = fichaService.findFichaAbierta(mujerId, getServicioId(session));
		SeguimientoView seg = fichaService.abrirSeguimiento(ficha.getId());
		return seg;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSegForm(@RequestParam Long mujerId, Model model) {		
		referenceData(mujerId, model);
		return "/ficha/seg/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSegFormSubmit(@ModelAttribute("seg") SeguimientoView seg, @RequestParam Long mujerId, SessionStatus status, HttpSession session) {		
		fichaService.save(seg);
		status.setComplete();
		session.removeAttribute("ficha");
		return "redirect:/ficha/resumen?mujerId=" + mujerId;
	}
}
