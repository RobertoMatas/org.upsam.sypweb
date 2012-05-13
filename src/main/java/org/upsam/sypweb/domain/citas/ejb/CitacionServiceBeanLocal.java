package org.upsam.sypweb.domain.citas.ejb;

import java.util.List;

import javax.ejb.Local;

import org.upsam.sypweb.view.CitacionView;

@Local
public interface CitacionServiceBeanLocal {

	List<CitacionView> getCitasPendientes(Long mujerId);
	
	List<CitacionView> getCitasPendientes(Long mujerId, String userName);
	
	List<CitacionView> getCitasDisponibles(Integer servicioId);
	
	void citar(Long mujerId, CitacionView cita, AppointmentHistoryBeanLocal history);

	List<CitacionView> getDailyAppointment(String userName);

	void cancel(Long citaId);
}
