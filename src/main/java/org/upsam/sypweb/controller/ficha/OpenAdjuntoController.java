package org.upsam.sypweb.controller.ficha;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.upsam.sypweb.domain.ficha.FichaService;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.view.ByteDocumentView;

@Controller
@RequestMapping("/ficha/doc/show")
public class OpenAdjuntoController {

	/**
	 * Servicio de fachada para la gestión de {@link Mujer}
	 */
	private FichaService fichaService;

	@Inject
	public OpenAdjuntoController(FichaService fichaService) {
		this.fichaService = fichaService;
	}

	@RequestMapping
	public void showDocument(@RequestParam Long docId, HttpServletResponse response) throws IOException {
		ByteDocumentView pv = fichaService.openDocument(docId);
		response.setContentType(pv.getTipo());
		FileCopyUtils.copy(pv.getDocBytes(), response.getOutputStream());
	}

}
