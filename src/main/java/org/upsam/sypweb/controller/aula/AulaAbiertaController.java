package org.upsam.sypweb.controller.aula;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.upsam.sypweb.domain.aula.AulaAbierta;
import org.upsam.sypweb.domain.aula.AulaAbiertaService;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.facade.MujerServiceFacade;

@Controller
@RequestMapping("/aula")
public class AulaAbiertaController {
	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private MujerServiceFacade mujerServiceFacade;
	/**
	 * Servicio de gestión del {@link AulaAbierta}
	 */
	private AulaAbiertaService aulaAbiertaService;

	/**
	 * 
	 * @param mujerServiceFacade
	 * @param aulaAbiertaService
	 */
	@Inject
	public AulaAbiertaController(MujerServiceFacade mujerServiceFacade) {
		super();
		this.mujerServiceFacade = mujerServiceFacade;
	}

	@RequestMapping
	public String aulaAbierta(@RequestParam(required = true) Long mujerId, Model model) {
		model.addAttribute("details", mujerServiceFacade.find(mujerId));
		model.addAttribute("inscritos", aulaAbiertaService.findTalleresApuntados(mujerId));
		model.addAttribute("ofertados", aulaAbiertaService.findTalleresOfertados(mujerId));
		model.addAttribute("encurso", aulaAbiertaService.findTalleresApuntadosEnCurso(mujerId));
		return "aulaAbierta";
	}

	@RequestMapping("/join")
	public String inscripcion(@RequestParam(required = true) Long mujerId, @RequestParam(required = true) Long aulaId, Model model) {
		aulaAbiertaService.inscribir(aulaId, mujerId);
		return aulaAbierta(mujerId, model);
	}
	
	@RequestMapping("/cancel-join")
	public String cancelarInscripcion(@RequestParam(required = true) Long mujerId, @RequestParam(required = true) Long aulaId, Model model) {
		aulaAbiertaService.cancelarInscripcion(aulaId, mujerId);
		return aulaAbierta(mujerId, model);
	}

	/**
	 * @param aulaAbiertaService the aulaAbiertaService to set
	 */
	@Resource(name = "aulaAbiertaWebService")
	public void setAulaAbiertaService(AulaAbiertaService aulaAbiertaService) {
		this.aulaAbiertaService = aulaAbiertaService;
	}
	
}
