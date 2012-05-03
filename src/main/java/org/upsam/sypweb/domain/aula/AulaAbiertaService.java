package org.upsam.sypweb.domain.aula;

import java.util.List;

import org.upsam.sypweb.view.AulaAbiertaView;

public interface AulaAbiertaService {

	List<AulaAbiertaView> findTalleresApuntados(Long mujerId);

	List<AulaAbiertaView> findTalleresOfertados(Long mujerId);

	List<AulaAbiertaView> findTalleresApuntadosEnCurso(Long mujerId);

	void inscribir(Long aulaId, Long mujerId);

	void cancelarInscripcion(Long aulaId, Long mujerId);

}
