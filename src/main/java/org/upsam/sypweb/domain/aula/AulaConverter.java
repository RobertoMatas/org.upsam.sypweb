package org.upsam.sypweb.domain.aula;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.view.AulaAbiertaView;

@Component
public class AulaConverter extends AbstractConvert<AulaAbierta, AulaAbiertaView> {

	@Override
	public AulaAbiertaView convert(AulaAbierta source) {
		AulaAbiertaView view = null;
		if (source != null) {			
			view = new AulaAbiertaView();
			view.setFin(source.getFin());
			view.setId(source.getId());
			view.setInicio(source.getInicio());
			view.setNumAlumnos(source.getPersonas().size());
			view.setTaller(source.getCurso().getTaller());
			view.setNumPlazas(source.getMaxPlazas());
		}
		return view;
	}

}
