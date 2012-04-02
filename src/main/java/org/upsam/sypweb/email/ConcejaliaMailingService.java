package org.upsam.sypweb.email;

import org.upsam.sypweb.domain.citas.CitaDTO;

public interface ConcejaliaMailingService {

	void sendAppointmentConfirmation(final CitaDTO cita);
}
