package org.upsam.sypweb.facade.impl;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.converter.Converter;
import org.upsam.sypweb.domain.aula.AulaAbierta;
import org.upsam.sypweb.domain.aula.AulaConverter;
import org.upsam.sypweb.domain.citas.Citacion;
import org.upsam.sypweb.domain.citas.CitacionConverter;
import org.upsam.sypweb.domain.citas.ejb.CitacionServiceBeanLocal;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerConverter;
import org.upsam.sypweb.domain.mujer.MujerService;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.servicio.ServicioService;
import org.upsam.sypweb.facade.MujerServiceFacade;
import org.upsam.sypweb.view.CitacionView;
import org.upsam.sypweb.view.MujerDetailedView;
import org.upsam.sypweb.view.MujerView;

@Transactional(readOnly = true)
@Service
public class MujerServiceFacadeImpl implements MujerServiceFacade {
	/**
	 * Servicio de gestión de {@link Servicio}
	 */
	private ServicioService servicioService;
	/**
	 * Servicio de gestión de {@link Citacion}
	 */
	private CitacionServiceBeanLocal citacionService;
	/**
	 * Servicio de gestión de {@link Mujer}
	 */
	private MujerService mujerService;
	/**
	 * {@link Converter} de {@link Mujer} a {@link MujerView}
	 */
	private MujerConverter mujerConverter;
	/**
	 * {@link Converter} de {@link Citacion} a {@link CitacionView}
	 */
	private CitacionConverter citacionConverter;
	/**
	 * {@link Converter} de {@link AulaAbierta} a {@link TallerView}
	 */
	private AulaConverter aulaConverter;
	
	/**
	 * 
	 * @param servicioService
	 * @param mujerService
	 * @param citacionService
	 * @param mujerConverter
	 * @param citacionConverter
	 * @param aulaConverter
	 */
	@Inject
	public MujerServiceFacadeImpl(ServicioService servicioService,
			MujerService mujerService, CitacionServiceBeanLocal citacionService,
			MujerConverter mujerConverter, CitacionConverter citacionConverter,
			AulaConverter aulaConverter) {
		super();
		this.servicioService = servicioService;
		this.citacionService = citacionService;
		this.mujerService = mujerService;
		this.mujerConverter = mujerConverter;
		this.citacionConverter = citacionConverter;
		this.aulaConverter = aulaConverter;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable("mujeres")
	public MujerDetailedView find(Long mujerId) {
		Mujer mujer = mujerService.find(mujerId);
		MujerView mujerView = mujerConverter.convert(mujer);
		MujerDetailedView view = new MujerDetailedView();
		BeanUtils.copyProperties(mujerView, view);
		view.setUsedServices(servicioService.getUsedUservicesBy(mujer));
		view.setCitasPendientes(citacionService.getCitasPendientes(mujerId));
		view.setHistoricoCitas(citacionConverter.convert(mujer.getCitaciones()));
		view.setTalleres(aulaConverter.convert(mujer.getTalleres()));

		return view;
	}


}
