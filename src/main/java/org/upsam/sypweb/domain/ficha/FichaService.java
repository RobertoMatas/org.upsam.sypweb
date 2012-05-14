package org.upsam.sypweb.domain.ficha;

import java.io.IOException;
import java.util.List;

import org.upsam.sypweb.controller.ficha.DocumentoForm;
import org.upsam.sypweb.view.ByteDocumentView;
import org.upsam.sypweb.view.FichaView;
import org.upsam.sypweb.view.SeguimientoView;

public interface FichaService {

	FichaView abrirFicha(Long citaId, Long mujerId, String userName);

	FichaView findFichaAbierta(Long mujerId, Integer servicioId);

	void save(FichaView ficha);

	SeguimientoView abrirSeguimiento(Long fichaId);

	void save(SeguimientoView seg);

	boolean save(DocumentoForm doc) throws IOException;

	ByteDocumentView openDocument(Long docId);

	void close(Long fichaId);
	
	List<FichaView> history(Long mujerId);

}
