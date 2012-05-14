package org.upsam.sypweb.domain.servicio;

import java.util.List;

import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.user.UserDTO;
import org.upsam.sypweb.view.ServicioView;

public interface ServicioService {
	
	List<ServicioView> getUsedUservicesBy(Mujer mujer);
	
	List<ServicioView> getServicesBy(String userName);
	
	UserDTO findUserByUserName(String userName);
}
