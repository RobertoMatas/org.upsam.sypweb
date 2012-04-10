package org.upsam.sypweb.async;

import org.upsam.sypweb.domain.citas.CitaDTO;

public interface NotificationService {
	
	void sendAppointmentConfirmation(final CitaDTO cita);
}
