package org.upsam.sypweb.domain.citas;

import java.util.List;

import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.user.User;
import org.upsam.sypweb.view.CitacionView;

public interface CitacionService {

	List<CitacionView> getCitasPendientes(Mujer mujer);
	
	List<CitacionView> getCitasPendientes(Mujer mujer, User usuario);
	
	List<CitacionView> getCitasDisponibles(Integer servicioId);
	
	void citar(Long mujerId, CitacionView cita);
}
