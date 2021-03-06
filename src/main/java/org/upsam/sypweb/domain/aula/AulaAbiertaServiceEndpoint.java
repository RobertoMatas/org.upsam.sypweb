package org.upsam.sypweb.domain.aula;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.upsam.sypweb.view.AulaAbiertaView;

@WebService(serviceName = "AulaAbiertaService")
public class AulaAbiertaServiceEndpoint extends SpringBeanAutowiringSupport {
	
	@Autowired
	@Qualifier("aulaAbiertaService")
	private AulaAbiertaService aulaAbiertaService;

	@WebMethod
	public List<AulaAbiertaView> findTalleresApuntados(Long mujerId) {
		return aulaAbiertaService.findTalleresApuntados(mujerId);
	}

	@WebMethod
	public List<AulaAbiertaView> findTalleresOfertados(Long mujerId) {
		return aulaAbiertaService.findTalleresOfertados(mujerId);
	}

	@WebMethod
	public List<AulaAbiertaView> findTalleresApuntadosEnCurso(Long mujerId) {
		return aulaAbiertaService.findTalleresApuntadosEnCurso(mujerId);
	}

	@WebMethod
	public void inscribir(Long aulaId, Long mujerId) {
		aulaAbiertaService.inscribir(aulaId, mujerId);
	}

	@WebMethod
	public void cancelarInscripcion(Long aulaId, Long mujerId) {
		aulaAbiertaService.cancelarInscripcion(aulaId, mujerId);
	}
	
}
