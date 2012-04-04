package org.upsam.sypweb.domain.mujer;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.upsam.sypweb.converter.AbstractConvert;
import org.upsam.sypweb.domain.mujer.domicilio.Domicilio;
import org.upsam.sypweb.domain.mujer.domicilio.Provincia;
import org.upsam.sypweb.domain.mujer.domicilio.TipoDireccion;
import org.upsam.sypweb.view.DomicilioView;
import org.upsam.sypweb.view.MujerView;

@Component
public class MujerConverter extends AbstractConvert<Mujer, MujerView> {

	@Override
	public MujerView convert(Mujer source) {
		MujerView view = null;
		DomicilioView dView = null;
		if (source != null) {
			view = new MujerView();
			dView = new DomicilioView();
			Domicilio domicilio = source.getDomicilio();
			Nombre nombre = source.getNombre();
			dView.setLetra(String.valueOf(domicilio.getLetra()));
			dView.setNombreAvenida(domicilio.getNombreAvenida());
			dView.setNombreProvincia(domicilio.getProvincia().getNombre());
			dView.setPiso(domicilio.getPiso() != null ? domicilio.getPiso().toString() : "");
			dView.setPoblacion(domicilio.getPoblacion());
			dView.setTipoDireccion(domicilio.getTipoDireccion().getTipo());
			dView.setTipoDireccionId(domicilio.getTipoDireccion().getId());
			dView.setEscalera(domicilio.getEscalera());
			dView.setProvinciaId(domicilio.getProvincia().getId());
			dView.setNumero(domicilio.getNumero());
			view.setDomicilio(dView);
			view.setNombre(nombre.getNombre());
			view.setApellido1(nombre.getApellido1());
			view.setApellido2(nombre.getApellido2());
			view.setDni(nombre.getDni());
			view.setFechaAlta(source.getFechaAlta());
			view.setEmpadronada(source.getEmpadronada());
			view.setFechaNac(source.getFechaNac());
			view.setTelfFijo(source.getTelfFijo());
			view.setTelfMovil(source.getTelfMovil());
			view.setId(source.getId());
			view.setEmail(nombre.getEmail());
		}
		return view;
	}
	/**
	 * 
	 * @param source
	 * @return
	 */
	public void convert(final MujerView source, Mujer destination) {
		if (source != null) {
			if (destination == null) {
				destination = new Mujer();
			}
			DomicilioView dView = source.getDomicilio();
			Domicilio domicilio = destination.getDomicilio() != null ? destination.getDomicilio() : new Domicilio();
			TipoDireccion tp = domicilio.getTipoDireccion() != null ? domicilio.getTipoDireccion() : new TipoDireccion();
			Provincia provincia = domicilio.getProvincia() != null ? domicilio.getProvincia() : new Provincia();
			if (dView != null) {
				domicilio.setEscalera(dView.getEscalera());
				domicilio.setLetra(StringUtils.hasText(dView.getLetra()) ? dView.getLetra().charAt(0) : null);
				domicilio.setNombreAvenida(dView.getNombreAvenida());
				domicilio.setNumero(dView.getNumero());
				domicilio.setPiso(StringUtils.hasText(dView.getPiso()) ? Integer.parseInt(dView.getPiso()) : 0);
				domicilio.setPoblacion(dView.getPoblacion());
				//provincia.setNombre(dView.getNombreProvincia());
				if (provincia.getId() == null) {
					provincia.setId(dView.getProvinciaId());
					provincia.setCodigo(dView.getNombreProvincia().toUpperCase());
				}
				//tp.setTipo(dView.getTipoDireccion());
				tp.setId(dView.getTipoDireccionId());
				destination.setDomicilio(domicilio);
				destination.setFechaAlta(new Date());
				destination.setFechaNac(source.getFechaNac());
				destination.setEmpadronada(source.getEmpadronada());
				Nombre nombre = new Nombre();
				nombre.setApellido1(source.getApellido1());
				nombre.setApellido2(source.getApellido2());
				nombre.setDni(source.getDni());
				nombre.setEmail(source.getEmail());
				nombre.setNombre(source.getNombre());
				destination.setNombre(nombre);
				destination.setTelfFijo(source.getTelfFijo());
				destination.setTelfMovil(source.getTelfMovil());
			}
		}
	}
}
