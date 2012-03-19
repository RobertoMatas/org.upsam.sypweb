package org.upsam.sypweb.domain.citas;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.view.CitacionView;

@Component
public class CitacionConverter extends AbstractConvert<Citacion, CitacionView> {

	@Override
	public CitacionView convert(Citacion source) {
		CitacionView view = null;
		if (source != null) {
			Servicio servicio = source.getServicio();
			view = new CitacionView(source.getId(), servicio.getDescripcion(),
					servicio.getResponsable().getUserName(), source.getCita(),
					source.getHora(), source.getAcudio());
		}
		return view;
	}

}
