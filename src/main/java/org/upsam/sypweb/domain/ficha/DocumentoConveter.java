package org.upsam.sypweb.domain.ficha;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.view.DocumentoView;

@Component
public class DocumentoConveter extends AbstractConvert<DocumentoAdjunto, DocumentoView> {

	@Override
	public DocumentoView convert(DocumentoAdjunto source) {
		DocumentoView view = null;
		if (source != null) {
			view = new DocumentoView(source.getId(), source.getTipo(), source.getDescripcion());
		}
		return view;
	}

}
