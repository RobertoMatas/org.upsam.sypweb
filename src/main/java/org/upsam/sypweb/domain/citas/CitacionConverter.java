package org.upsam.sypweb.domain.citas;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.converter.Converter;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerConverter;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.view.CitacionView;
import org.upsam.sypweb.view.MujerView;

@Component
public class CitacionConverter extends AbstractConvert<Citacion, CitacionView> {

	/**
	 * {@link Converter} de {@link Mujer} a {@link MujerView}
	 */
	private MujerConverter mujerConverter;

	/**
	 * @param mujerConverter
	 */
	@Inject
	public CitacionConverter(MujerConverter mujerConverter) {
		super();
		this.mujerConverter = mujerConverter;
	}

	@Override
	public CitacionView convert(Citacion source) {
		CitacionView view = null;
		if (source != null) {
			Servicio servicio = source.getServicio();
			view = new CitacionView(source.getId(), servicio.getId(), servicio.getDescripcion(), servicio.getResponsable().getUserName(), source.getCita(), source.getHora(), source.getAcudio());
			view.setMujer(mujerConverter.convert(source.getMujer()));
		}
		return view;
	}

}
