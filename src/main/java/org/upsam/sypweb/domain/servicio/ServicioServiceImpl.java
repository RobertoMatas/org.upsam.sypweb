package org.upsam.sypweb.domain.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.view.ServicioView;

@Transactional(readOnly = true)
@Service
public class ServicioServiceImpl implements ServicioService {
	/**
	 * Repositorio de la entidad {@link Servicio}
	 */
	private ServicioRepository servicioRepository;

	/**
	 * @param servicioRepository
	 */
	@Inject
	public ServicioServiceImpl(ServicioRepository servicioRepository) {
		super();
		this.servicioRepository = servicioRepository;
	}

	@Override
	public List<ServicioView> getUsedUservicesBy(Mujer mujer) {
		List<Servicio> usedServices = servicioRepository.getUsedUservicesBy(mujer);
		List<ServicioView> view = new ArrayList<ServicioView>(usedServices.size());
		ServicioView item = null;
		for (Servicio servicio : usedServices) {
			item = new ServicioView(servicio.getDescripcion(), servicio.getResponsable().getUserName());
			view.add(item);
		}
		return view;
	}

}
