package org.upsam.sypweb.domain.ficha;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.converter.Converter;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerConverter;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.servicio.ServicioConverter;
import org.upsam.sypweb.view.DocumentoView;
import org.upsam.sypweb.view.FichaView;
import org.upsam.sypweb.view.MujerView;
import org.upsam.sypweb.view.SeguimientoView;
import org.upsam.sypweb.view.ServicioView;

@Component
public class FichaConverter extends AbstractConvert<Ficha, FichaView> {
	/**
	 * Converter de {@link Mujer} a {@link MujerView}
	 */
	private MujerConverter mujerConverter;
	/**
	 * {@link Converter} de {@link Servicio} a {@link ServicioView}
	 */
	private ServicioConverter servicioConverter;
	/**
	 * {@link Converter} de {@link Seguimiento} a {@link SeguimientoView}
	 */
	private SeguimientoConveter seguimientoConveter;
	/**
	 * {@link Converter} de {@link DocumentoAdjunto} a {@link DocumentoView}
	 */
	private DocumentoConveter documentoConveter;

	/**
	 * @param mujerConverter
	 * @param servicioConverter
	 */
	@Inject
	public FichaConverter(MujerConverter mujerConverter, ServicioConverter servicioConverter, SeguimientoConveter seguimientoConveter, DocumentoConveter documentoConveter) {
		super();
		this.mujerConverter = mujerConverter;
		this.servicioConverter = servicioConverter;
		this.seguimientoConveter = seguimientoConveter;
		this.documentoConveter = documentoConveter;
	}

	@Override
	public FichaView convert(Ficha source) {
		FichaView view = null;
		if (source != null) {
			view = new FichaView(source.getId(), source.getApertura(), mujerConverter.convert(source.getMujer()), servicioConverter.convert(source.getServicio()));
			view.setCierre(source.getCierre());
			view.setDescripcion(source.getDescripcion());
			view.setSeguimientos(seguimientoConveter.convert(source.getSeguimientos()));
			view.setAdjuntos(documentoConveter.convert(source.getAdjuntos()));
		}
		return view;
	}

}
