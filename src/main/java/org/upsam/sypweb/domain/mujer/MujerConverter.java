package org.upsam.sypweb.domain.mujer;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.domain.mujer.domicilio.Domicilio;
import org.upsam.sypweb.view.DomicilioView;
import org.upsam.sypweb.view.MujerView;

@Component
public class MujerConverter extends AbstractConvert<Mujer, MujerView> {

	@Override
	public MujerView convert(Mujer source) {
		MujerView view = null;
		DomicilioView dView = null;
		if (source != null) {
			view = new MujerView();
			dView = new DomicilioView();
			Domicilio domicilio = source.getDomicilio();
			Nombre nombre = source.getNombre();
			dView.setLetra(String.valueOf(domicilio.getLetra()));
			dView.setNombreAvenida(domicilio.getNombreAvenida());
			dView.setNombreProvincia(domicilio.getProvincia().getNombre());
			dView.setPiso(domicilio.getPiso() != null ? domicilio.getPiso().toString() : "");
			dView.setPoblacion(domicilio.getPoblacion());
			dView.setTipoDireccion(domicilio.getTipoDireccion().getTipo());
			view.setDomicilio(dView);
			view.setApellido1(nombre.getApellido1());
			view.setApellido2(nombre.getApellido2());
			view.setDni(nombre.getDni());
			view.setFechaAlta(source.getFechaAlta());
			view.setEmpadronada(source.getEmpadronada());
			view.setFechaNac(source.getFechaNac());
			view.setTelfFijo(source.getTelfFijo());
			view.setTelfMovil(source.getTelfMovil());
			view.setId(source.getId());
			view.setEmail(nombre.getEmail());
		}
		return view;
	}

}
