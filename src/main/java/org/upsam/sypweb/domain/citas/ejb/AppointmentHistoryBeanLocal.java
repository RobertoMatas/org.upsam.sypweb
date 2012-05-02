package org.upsam.sypweb.domain.citas.ejb;

import java.util.List;

import javax.ejb.Local;

import org.upsam.sypweb.domain.citas.CitaDTO;

@Local
public interface AppointmentHistoryBeanLocal {

	void add(CitaDTO cita);
	
	void finish();
	
	List<CitaDTO> getAppointments();
}
