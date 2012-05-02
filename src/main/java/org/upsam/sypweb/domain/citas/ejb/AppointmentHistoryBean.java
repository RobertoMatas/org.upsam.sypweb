package org.upsam.sypweb.domain.citas.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.apache.commons.collections15.buffer.CircularFifoBuffer;
import org.upsam.sypweb.domain.citas.CitaDTO;

@Stateful(name = "ejb/AppointmentHistoryBean")
public class AppointmentHistoryBean implements AppointmentHistoryBeanLocal {
	/**
	 * Máximo tamaño del histórico de citas
	 */
	private final int MAX_HISTORY_SIZE = 10;
	/**
	 * Colección circular para ir descartando las citas más antiguas cuando se
	 * supere el tamaño del histórico
	 */
	private CircularFifoBuffer<CitaDTO> appointmentHistory;

	/**
	 * 
	 */
	public AppointmentHistoryBean() {
		super();
		this.appointmentHistory = new CircularFifoBuffer<CitaDTO>(MAX_HISTORY_SIZE);
	}

	@Override
	public void add(CitaDTO cita) {
		appointmentHistory.add(cita);
	}

	@Override
	public List<CitaDTO> getAppointments() {
		CitaDTO[] citasArr = new CitaDTO[appointmentHistory.size()];
		appointmentHistory.toArray(citasArr);
		return Arrays.asList(citasArr);
	}

	@Override
	@Remove
	public void finish() {
		this.appointmentHistory = null;
	}

}
