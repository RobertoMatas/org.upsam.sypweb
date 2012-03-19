package org.upsam.sypweb.domain.citas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.servicio.Horario;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.servicio.ServicioRepository;
import org.upsam.sypweb.domain.user.User;
import org.upsam.sypweb.view.CitacionView;

import com.mysema.query.types.Predicate;

@Transactional(readOnly = true)
@Service
public class CitacionServiceImpl implements CitacionService {
	private static final int MAX_CITAS = 20;
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
	 * Repositorio de la entidad {@link Servicio}
	 */
	private ServicioRepository servicioRepository;

	/**
	 * 
	 * @param citacionRepository
	 * @param citacionConverter
	 */
	@Inject
	public CitacionServiceImpl(CitacionRepository citacionRepository, ServicioRepository servicioRepository, 
			CitacionConverter citacionConverter) {
		super();
		this.servicioRepository = servicioRepository;
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

	@Override
	public List<CitacionView> getCitasDisponibles(Integer servicioId) {
		List<CitacionView> citaciones = null;
		List<Citacion> citasDadas = null;
		List<Horario> setHorarios = null;
		Iterator<Horario> horarios = null;

		Horario horario = null;
		CitacionView citacion = null;
		Citacion citaDada = null;
		Calendar calendar = null;
		Date fechaCita = null;
		Date fechaDada = null;
		Date hoy = new Date();
		String horaHorario = null;
		String horaDada = null;
		String horaCita = null;
		int diaSemHorario = 0;
		int diaSemCitaDada = 0;
		int diaSemCita = 0;
		int semAnoCitaDada = 0;
		int semAnoCita = 0;
		boolean libre = false;
		int i = 0, n = 0, j = 0;
		int hh = 0;
		String hhCita = null;
		Servicio servicio = servicioRepository.findOne(servicioId);
		if (servicio != null) {
			// obtenemos el horario de atención del servicio en cuestión
			setHorarios = servicio.getDisponibilidad();
			if (setHorarios != null) {
				// obtenemos la lista de las citas ya concedidas para este
				// servicio
				citasDadas = citacionRepository
						.findByServicioAndCitaGreaterThan(servicio, hoy);
			}

			// mientras no hayamos obtenido el número de citas a devolver
			while (j < MAX_CITAS) {

				if (fechaCita == null) {
					fechaCita = hoy;
					calendar = new GregorianCalendar();
					calendar.setTime(fechaCita);
					calendar.add(Calendar.HOUR_OF_DAY, 1); // empieza a buscar
															// cita una hora mas
															// tarde
				} else {
					calendar = new GregorianCalendar();
					calendar.setTime(fechaCita);
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					calendar.set(Calendar.HOUR_OF_DAY, 0);
				}
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				fechaCita = calendar.getTime();

				hh = calendar.get(Calendar.HOUR_OF_DAY);
				hhCita = String.valueOf(hh);
				if (hh < 10) {
					hhCita = "0" + hhCita;
				}

				horaCita = hhCita + "0000";
				diaSemCita = calendar.get(java.util.Calendar.DAY_OF_WEEK);
				semAnoCita = calendar.get(java.util.Calendar.WEEK_OF_YEAR);

				horarios = setHorarios.iterator();
				while (horarios.hasNext()) {
					horario = horarios.next();
					horaHorario = horario.getHora();
					diaSemHorario = horario.getDiaSemana();

					libre = false;
					if ((diaSemCita == diaSemHorario)
							&& (horaCita.compareTo(horaHorario) < 0)) {

						libre = true;
						if (citasDadas != null) {
							n = citasDadas.size();
							// buscamos si la posible cita obtenida ya ha sido
							// dada
							for (i = 0; i < n; i++) {
								citaDada = citasDadas.get(i);
								fechaDada = citaDada.getCita();
								horaDada = citaDada.getHora();
								calendar = new GregorianCalendar();
								calendar.setTime(fechaDada);
								diaSemCitaDada = calendar
										.get(java.util.Calendar.DAY_OF_WEEK);
								semAnoCitaDada = calendar
										.get(java.util.Calendar.WEEK_OF_YEAR);

								// si coincide con alguna dada salimos del bucle
								// para comenzar a buscar una nueva
								if ((diaSemCitaDada == diaSemHorario)
										&& (horaDada.equals(horaHorario) && (semAnoCitaDada == semAnoCita))) {

									libre = false;
									break;
								}
							}
						}
					}

					// si no ha sido dada la cita anteriormente la guardamos en
					// la lista resultado
					if (libre) {
						j++;
						citacion = new CitacionView(new Long(j), servicio.getId(),
								servicio.getDescripcion(), servicio.getResponsable().getUserName(),
								fechaCita, horaHorario, false);
						if (citaciones == null) {
							citaciones = new ArrayList<CitacionView>(MAX_CITAS);
						}
						citaciones.add(citacion);
					}

				}
			}
		}

		return citaciones;
	}

}
