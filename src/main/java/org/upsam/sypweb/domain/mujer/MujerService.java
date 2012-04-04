package org.upsam.sypweb.domain.mujer;

import java.util.List;

import org.upsam.sypweb.domain.mujer.domicilio.Provincia;
import org.upsam.sypweb.domain.mujer.domicilio.TipoDireccion;
import org.upsam.sypweb.view.BusqMujerView;
import org.upsam.sypweb.view.MujerView;

public interface MujerService {
	
	Mujer find(Long id);
	
	MujerView findForEdit(Long id);
	
	List<MujerView> findAll(BusqMujerView filter);
	
	void save(MujerView mujer);
	
	List<Provincia> getProvincias();
	
	List<TipoDireccion> getTiposDireccion();
}
