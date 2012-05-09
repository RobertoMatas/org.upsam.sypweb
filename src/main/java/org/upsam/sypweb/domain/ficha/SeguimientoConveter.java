package org.upsam.sypweb.domain.ficha;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.view.SeguimientoView;

@Component
public class SeguimientoConveter extends AbstractConvert<Seguimiento, SeguimientoView> {

	@Override
	public SeguimientoView convert(Seguimiento source) {
		SeguimientoView view = null;
		if (source != null) {
			view = new SeguimientoView(source.getId(), source.getFecha(), source.getObservaciones());
		}
		return view;
	}

}
