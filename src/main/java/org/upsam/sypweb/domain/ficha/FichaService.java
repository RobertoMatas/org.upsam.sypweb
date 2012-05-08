package org.upsam.sypweb.domain.ficha;

import org.upsam.sypweb.view.FichaView;

public interface FichaService {

	FichaView abrirFicha(Long citaId, Long mujerId, String userName);

	FichaView findFichaAbierta(Long mujerId, Integer servicioId);

	void save(FichaView ficha);

}
