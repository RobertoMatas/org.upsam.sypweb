package org.upsam.sypweb.controller.ficha;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.upsam.sypweb.controller.AbstractController;
import org.upsam.sypweb.domain.ficha.FichaService;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.facade.MujerServiceFacade;
import org.upsam.sypweb.view.FichaView;

@Controller
@RequestMapping("/ficha/doc")
@SessionAttributes("doc")
public class DocumentoAdjuntoController extends AbstractController {

	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private FichaService fichaService;
	
	@Inject
	public DocumentoAdjuntoController(MujerServiceFacade mujerServiceFacade, FichaService fichaService) {
		super(mujerServiceFacade);
		this.fichaService = fichaService;
	}

	@ModelAttribute("doc")
	public DocumentoForm modelAttribute(@RequestParam Long mujerId, HttpSession session) {
		FichaView ficha = fichaService.findFichaAbierta(mujerId, getServicioId(session));
		DocumentoForm doc = new DocumentoForm();
		doc.setFichaId(ficha.getId());
		return doc;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showForm(@RequestParam Long mujerId, Model model) {
		referenceData(mujerId, model);
		return "/ficha/doc/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String handleFormUpload(@Valid @ModelAttribute("doc") DocumentoForm doc, BindingResult result, @RequestParam Long mujerId, Model model, SessionStatus status, HttpSession session) throws IOException {
		if (! result.hasErrors()) {
			if (fichaService.save(doc)) {
				status.setComplete();
				session.removeAttribute("ficha");
				return "redirect:/ficha/resumen?mujerId=" + mujerId;
			} 
		}
		return showForm(mujerId, model);
	}
	
	@ExceptionHandler( { IOException.class, MaxUploadSizeExceededException.class } )
	public ModelAndView handleUploadException(Exception ex, HttpServletRequest request, HttpSession session) {
		DocumentoForm model = (DocumentoForm) WebUtils.getOrCreateSessionAttribute(session, "doc", DocumentoForm.class);
		request.setAttribute("error", ex.getLocalizedMessage());
		ModelAndView mav = new ModelAndView("/ficha/doc/add", "doc", model);
		mav.addObject("details", mujerServiceFacade.find(Long.parseLong(request.getParameter("mujerId"))));
		return mav;
	}

}
