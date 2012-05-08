package org.upsam.sypweb.domain.ficha;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.citas.Citacion;
import org.upsam.sypweb.domain.citas.CitacionRepository;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerRepository;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.servicio.ServicioRepository;
import org.upsam.sypweb.domain.user.User;
import org.upsam.sypweb.domain.user.UserRepository;
import org.upsam.sypweb.view.FichaView;

@Service
@Transactional
public class FichaServiceImpl implements FichaService {
	/**
	 * Repositorio para {@link Citacion}
	 */
	private CitacionRepository citacionRepository;
	/**
	 * Repositorio para {@link Ficha}
	 */
	private FichaRepository fichaRepository;
	/**
	 * Converter de {@link Ficha} a {@link FichaView}
	 */
	private FichaConverter fichaConverter;
	/**
	 * Repositorio para {@link Servicio}
	 */
	private ServicioRepository servicioRepository;
	/**
	 * Repositorio para {@link User}
	 */
	private UserRepository userRepository;
	/**
	 * Repositorio para {@link Mujer}
	 */
	private MujerRepository mujerRepository;

	/**
	 * @param citacionRepository
	 */
	@Inject
	public FichaServiceImpl(CitacionRepository citacionRepository, FichaRepository fichaRepository, FichaConverter fichaConverter, ServicioRepository servicioRepository,
			MujerRepository mujerRepository, UserRepository userRepository) {
		super();
		this.citacionRepository = citacionRepository;
		this.fichaRepository = fichaRepository;
		this.fichaConverter = fichaConverter;
		this.servicioRepository = servicioRepository;
		this.mujerRepository = mujerRepository;
		this.userRepository = userRepository;
	}

	@Override
	public FichaView abrirFicha(Long citaId, Long mujerId, String userName) {
		Citacion cita = citacionRepository.findOne(citaId);
		if (cita != null) {
			cita.setAcudio(Boolean.TRUE);
		}
		Servicio servicio = servicioRepository.findByResponsable(userRepository.findByUserName(userName));
		return findFichaAbierta(mujerId, servicio.getId());
	}

	@Override
	public void save(FichaView ficha) {
		Ficha ficha2 = fichaRepository.findOne(ficha.getId());
		if (ficha2 != null) {
			ficha2.setDescripcion(ficha.getDescripcion());
		}
		fichaRepository.save(ficha2);
	}

	@Override
	public FichaView findFichaAbierta(Long mujerId, Integer servicioId) {
		QFicha ficha = QFicha.ficha;
		Ficha ficha2 = fichaRepository.findOne(ficha.mujer.id.eq(mujerId).and(ficha.servicio.id.eq(servicioId)).and(ficha.cerrada.eq(Boolean.FALSE)));
		if (ficha2 == null) {
			ficha2 = createFicha(mujerId, servicioId);
		}
		return fichaConverter.convert(ficha2);
	}

	private Ficha createFicha(Long mujerId, Integer servicioId) {
		Mujer mujer = mujerRepository.findOne(mujerId);
		Servicio servicio = servicioRepository.findOne(servicioId);
		Ficha ficha = new Ficha();
		ficha.setApertura(new Date());
		ficha.setMujer(mujer);
		ficha.setCerrada(Boolean.FALSE);
		ficha.setServicio(servicio);
		fichaRepository.save(ficha);
		return ficha;
	}

}
