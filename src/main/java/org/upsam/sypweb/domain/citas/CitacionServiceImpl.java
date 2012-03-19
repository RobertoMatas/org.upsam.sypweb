package org.upsam.sypweb.domain.citas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.user.User;
import org.upsam.sypweb.view.CitacionView;

import com.mysema.query.types.Predicate;

@Transactional(readOnly = true)
@Service
public class CitacionServiceImpl implements CitacionService {
	/**
	 * Formato de hora usado
	 */
	private final DateFormat df = new SimpleDateFormat("HHmmss");
	/**
	 * Repositorio de la entidad {@link Citacion}
	 */
	private CitacionRepository citacionRepository;
	/**
	 * Converter de {@link Citacion} a {@link CitacionView}
	 */
	private CitacionConverter citacionConverter;

	/**
	 * 
	 * @param citacionRepository
	 * @param citacionConverter
	 */
	@Inject
	public CitacionServiceImpl(CitacionRepository citacionRepository,
			CitacionConverter citacionConverter) {
		super();
		this.citacionRepository = citacionRepository;
		this.citacionConverter = citacionConverter;
	}

	@Override
	public List<CitacionView> getCitasPendientes(Mujer mujer) {
		Iterable<Citacion> citasPendientes = citacionRepository
				.findAll(getCitasPendientesPredicate(mujer));
		return citacionConverter.convert(citasPendientes);
	}

	@Override
	public List<CitacionView> getCitasPendientes(Mujer mujer, User usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	private Predicate getCitasPendientesPredicate(Mujer mujer) {
		QCitacion cita = QCitacion.citacion;
		Date now = new Date();
		return cita.mujer
				.eq(mujer)
				.and(cita.acudio.eq(false))
				.and(cita.cita.after(now).or(cita.cita.eq(now))
						.and(cita.hora.gt(df.format(now))));
	}

}
