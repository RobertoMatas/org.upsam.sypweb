package org.upsam.sypweb.domain.aula;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerRepository;
import org.upsam.sypweb.view.AulaAbiertaView;

@Service(value = "aulaAbiertaService")
@Transactional(readOnly = true)
public class AulaAbiertaServiceImpl implements AulaAbiertaService {
	/**
	 * Repositorio de {@link AulaAbierta}
	 */
	private AulaAbiertaRepository aulaAbiertaRepository;
	/**
	 * Repositorio de {@link Mujer}
	 */
	private MujerRepository mujerRepository;
	/**
	 * Converter de {@link AulaAbierta} a {@link AulaAbiertaView}
	 */
	private AulaConverter aulaConverter;

	/**
	 * @param aulaAbiertaRepository
	 * @param mujerRepository
	 * @param aulaConverter
	 */
	@Inject
	public AulaAbiertaServiceImpl(AulaAbiertaRepository aulaAbiertaRepository, MujerRepository mujerRepository, AulaConverter aulaConverter) {
		super();
		this.aulaAbiertaRepository = aulaAbiertaRepository;
		this.mujerRepository = mujerRepository;
		this.aulaConverter = aulaConverter;
	}

	@Override
	@Transactional
	public void inscribir(Long aulaId, Long mujerId) {
		Mujer mujer = mujerRepository.findOne(mujerId);
		AulaAbierta aula = aulaAbiertaRepository.findOne(aulaId);
		mujer.getTalleres().add(aula);
	}

	@Override
	@Transactional
	public void cancelarInscripcion(Long aulaId, Long mujerId) {
		Mujer mujer = mujerRepository.findOne(mujerId);
		AulaAbierta aula = aulaAbiertaRepository.findOne(aulaId);
		mujer.getTalleres().remove(aula);
	}

	@Override
	public List<AulaAbiertaView> findTalleresApuntados(Long mujerId) {
		List<AulaAbierta> query = aulaAbiertaRepository.findTalleresNoComenzadosByFechaAndMujer(new Date(), mujerRepository.findOne(mujerId));
		return toView(query);
	}

	@Override
	public List<AulaAbiertaView> findTalleresOfertados(Long mujerId) {
		List<AulaAbierta> query = aulaAbiertaRepository.findTalleresOfertadosByFechaAndMujer(new Date(), mujerRepository.findOne(mujerId));
		return toView(query);
	}

	@Override
	public List<AulaAbiertaView> findTalleresApuntadosEnCurso(Long mujerId) {
		List<AulaAbierta> query = aulaAbiertaRepository.findTalleresCursadosByFechaAndMujer(new Date(), new Date(), mujerRepository.findOne(mujerId));
		return toView(query);
	}

	private List<AulaAbiertaView> toView(List<AulaAbierta> query) {
		return aulaConverter.convert(query);
	}

}
