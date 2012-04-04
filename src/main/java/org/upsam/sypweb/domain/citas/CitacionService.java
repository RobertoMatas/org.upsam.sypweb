package org.upsam.sypweb.domain.citas;

import java.util.List;

import javax.ejb.Remote;

import org.upsam.sypweb.view.CitacionView;

@Remote
public interface CitacionService {

	List<CitacionView> getCitasPendientes(Long mujerId);
	
	List<CitacionView> getCitasPendientes(Long mujerId, String userName);
	
	List<CitacionView> getCitasDisponibles(Integer servicioId);
	
	void citar(Long mujerId, CitacionView cita);
}
