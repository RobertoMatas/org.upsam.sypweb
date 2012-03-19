package org.upsam.sypweb.domain.servicio;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.view.ServicioView;

@Component
public class ServicioConverter extends AbstractConvert<Servicio, ServicioView> {

	@Override
	public ServicioView convert(Servicio source) {
		ServicioView view = null;
		if (source != null) {
			view = new ServicioView(source.getId(), source.getDescripcion(), source.getResponsable().getUserName());
		}
		return view;
	}

}
