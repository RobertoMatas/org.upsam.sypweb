package org.upsam.sypweb.controller.citas;

import java.util.List;

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
import org.upsam.sypweb.domain.citas.ejb.AppointmentHistoryBeanLocal;
import org.upsam.sypweb.domain.citas.ejb.CitacionServiceBeanLocal;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.servicio.ServicioService;
import org.upsam.sypweb.facade.MujerServiceFacade;
import org.upsam.sypweb.view.CitacionView;

@Controller
@SessionAttributes({"citacion", "citaciones"})
public class NewCitaController extends AbstractController {
	/**
	 * servicio de gestión de la entidad {@link Servicio}
	 */
	private ServicioService servicioService;
	/**
	 * 
	 */
	private CitacionServiceBeanLocal citacionService;

	/**
	 * @param mujerService
	 */
	@Inject
	public NewCitaController(MujerServiceFacade mujerServiceFacade, ServicioService servicioService, CitacionServiceBeanLocal citacionService) {
		super(mujerServiceFacade);
		this.servicioService = servicioService;		
		this.citacionService = citacionService;
	}

	@ModelAttribute("citacion")
	public CitacionView modelAttribute() {
		return new CitacionView();
	}
	
	@RequestMapping(value = "/cita/new", method = RequestMethod.GET)
	public String newCitaForm(@RequestParam(required = true) Long mujerId, Model model, HttpSession session) {
		session.setAttribute("mujerId", mujerId);
		referenceData(mujerId, model);
		return "newCita";
	}
	
	@RequestMapping(value = "/cita/new", method = RequestMethod.POST)
	public String submitServiceSelection(@ModelAttribute("citacion") CitacionView citacion, @RequestParam(required = false) Long mujerId, Model model, HttpSession session) {
		mujerId = (Long) (mujerId != null ? mujerId : session.getAttribute("mujerId"));
		referenceData(mujerId, model);
		model.addAttribute("citaciones", citacionService.getCitasDisponibles(citacion.getServicioId()));
		return "newCita";
	}
	
	@RequestMapping(value = "/cita/new/finish", method = RequestMethod.POST)
	@SuppressWarnings("unchecked")
	public String submitCitaSelection(@ModelAttribute("citacion") CitacionView citacion, @RequestParam(required = false) Long mujerId, @RequestParam Integer citasel, Model model, HttpSession session, SessionStatus status) {
		mujerId = (Long) (mujerId != null ? mujerId : session.getAttribute("mujerId"));
		List<CitacionView> citaciones = (List<CitacionView>) session.getAttribute("citaciones");
		if (citaciones != null && citasel != null) {
			CitacionView citaSelected = citaciones.get(citasel);
			citacionService.citar(mujerId, citaSelected, (AppointmentHistoryBeanLocal) session.getAttribute("history"));
			status.setComplete();
			return "redirect:/cita/list?mujerId=" + mujerId;
			
		} else {
			referenceData(mujerId, model);
			model.addAttribute("citaciones", citacionService.getCitasDisponibles(citacion.getServicioId()));
		}
		return "newCita";
	}

	@Override
	protected void referenceData(Long mujerId, Model model) {
		model.addAttribute("details", mujerServiceFacade.find(mujerId));
		model.addAttribute("listServicios", servicioService.getServicesBy(null));
	}
}
