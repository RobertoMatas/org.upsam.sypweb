package org.upsam.sypweb.domain.ficha;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.controller.ficha.DocumentoForm;
import org.upsam.sypweb.domain.citas.Citacion;
import org.upsam.sypweb.domain.citas.CitacionRepository;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerRepository;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.servicio.ServicioRepository;
import org.upsam.sypweb.domain.user.User;
import org.upsam.sypweb.domain.user.UserRepository;
import org.upsam.sypweb.view.ByteDocumentView;
import org.upsam.sypweb.view.FichaView;
import org.upsam.sypweb.view.SeguimientoView;

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
	 * Converter de {@link Seguimiento} a {@link SeguimientoView}
	 */
	private SeguimientoConveter seguimientoConveter;
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
	 * Repositorio para {@link Seguimiento}
	 */
	private SeguimientoRepository seguimientoRepository;
	/**
	 * Repositorio de {@link DocumentoAdjunto}
	 */
	private DocumentoRepository documentoRepository;

	/**
	 * @param citacionRepository
	 */
	@Inject
	public FichaServiceImpl(CitacionRepository citacionRepository, FichaRepository fichaRepository, FichaConverter fichaConverter, ServicioRepository servicioRepository,
			MujerRepository mujerRepository, UserRepository userRepository, SeguimientoRepository seguimientoRepository, SeguimientoConveter seguimientoConveter,
			DocumentoRepository documentoRepository) {
		super();
		this.citacionRepository = citacionRepository;
		this.fichaRepository = fichaRepository;
		this.fichaConverter = fichaConverter;
		this.servicioRepository = servicioRepository;
		this.mujerRepository = mujerRepository;
		this.userRepository = userRepository;
		this.seguimientoRepository = seguimientoRepository;
		this.seguimientoConveter = seguimientoConveter;
		this.documentoRepository = documentoRepository;
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

	@Override
	public SeguimientoView abrirSeguimiento(Long fichaId) {
		Ficha ficha = fichaRepository.findOne(fichaId);
		Seguimiento seg = new Seguimiento();
		seg.setFecha(new Date());
		seg.setFicha(ficha);
		seguimientoRepository.save(seg);
		return seguimientoConveter.convert(seg);
	}

	@Override
	public void save(SeguimientoView seg) {
		Seguimiento seguimiento = seguimientoRepository.findOne(seg.getId());
		seguimiento.setObservaciones(seg.getObservaciones());
		seguimientoRepository.save(seguimiento);
	}

	@Override
	public boolean save(DocumentoForm doc) throws IOException {
		byte[] bytes = null;
		boolean insert = false;
		if (doc != null && doc.getFile() != null && !doc.getFile().isEmpty()) {
			bytes = doc.getFile().getBytes();
			DocumentoAdjunto docAdj = new DocumentoAdjunto();
			docAdj.setDescripcion(doc.getDescripcion());
			docAdj.setDocumento(bytes);
			docAdj.setFicha(fichaRepository.findOne(doc.getFichaId()));
			docAdj.setTipo(doc.getFile().getContentType());
			documentoRepository.save(docAdj);
			insert = true;

		}
		return insert;
	}

	@Override
	public ByteDocumentView openDocument(Long docId) {
		DocumentoAdjunto docAdj = documentoRepository.findOne(docId);
		ByteDocumentView dview = new ByteDocumentView(docAdj.getId(), docAdj.getTipo(), docAdj.getDescripcion());
		dview.setDocBytes(new ByteArrayInputStream(docAdj.getDocumento()));
		return dview;
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
