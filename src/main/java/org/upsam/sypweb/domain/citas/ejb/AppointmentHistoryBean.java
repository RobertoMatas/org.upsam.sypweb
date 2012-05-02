package org.upsam.sypweb.domain.citas.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.apache.commons.collections.buffer.CircularFifoBuffer;
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
	private CircularFifoBuffer appointmentHistory;

	/**
	 * 
	 */
	public AppointmentHistoryBean() {
		super();
		this.appointmentHistory = new CircularFifoBuffer(MAX_HISTORY_SIZE);
	}

	@Override
	public void add(CitaDTO cita) {
		appointmentHistory.add(cita);
	}

	@Override
	public List<CitaDTO> getAppointments() {
		Object[] citasArr = appointmentHistory.toArray();
		List<CitaDTO> citas = new ArrayList<CitaDTO>(citasArr.length);
		for (int i = 0; i < citasArr.length; i++) {
			citas.add(i, (CitaDTO) citasArr[i]);
		}
		return citas;
	}

	@Override
	@Remove
	public void finish() {
		this.appointmentHistory = null;
	}

}
