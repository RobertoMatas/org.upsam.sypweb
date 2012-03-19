package org.upsam.sypweb.domain.aula;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.view.TallerView;

@Component
public class AulaConverter extends AbstractConvert<AulaAbierta, TallerView> {

	@Override
	public TallerView convert(AulaAbierta source) {
		TallerView view = null;
		if (source != null) {
			view = new TallerView(source.getCurso().getTaller(), source.getInicio(), source.getFin());
		}
		return view;
	}

}
