package org.upsam.sypweb.domain.mujer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.domicilio.Domicilio;
import org.upsam.sypweb.view.BusqMujerView;
import org.upsam.sypweb.view.DomicilioView;
import org.upsam.sypweb.view.MujerView;

import com.mysema.query.types.Predicate;

@Transactional(readOnly = true)
@Service
public class MujerServiceImpl implements MujerService {

	/**
	 * Repositorio de la entidad {@link Mujer}
	 */
	private MujerRepository mujerRepository;

	/**
	 * @param mujerRepository
	 */
	@Inject
	public MujerServiceImpl(MujerRepository mujerRepository) {
		super();
		this.mujerRepository = mujerRepository;
	}

	@Override
	public List<MujerView> findAll(BusqMujerView filter) {
		Predicate predicate = getPredicate(filter);
		
		Iterable<Mujer> it = mujerRepository.findAll(predicate);
		List<MujerView> mujeres = new ArrayList<MujerView>();
		for (Mujer mujer : it) {
			mujeres.add(toViewBean(mujer));
		}
		return mujeres;
	}

	private Predicate getPredicate(BusqMujerView filter) {
		return null;
	}

	private MujerView toViewBean(Mujer mujer) {
		MujerView view = null;
		DomicilioView dView = null;
		if (mujer != null) {
			view = new MujerView();
			dView = new DomicilioView();
			Domicilio domicilio = mujer.getDomicilio();
			Nombre nombre = mujer.getNombre();
			dView.setLetra(String.valueOf(domicilio.getLetra()));
			dView.setNombreAvenida(domicilio.getNombreAvenida());
			dView.setNombreProvincia(domicilio.getProvincia().getNombre());
			dView.setPiso(domicilio.getPiso() != null ? domicilio.getPiso().toString() : "");
			dView.setPoblacion(domicilio.getPoblacion());
			dView.setTipoDireccion(domicilio.getTipoDireccion().getTipo());
			view.setDomicilio(dView);
			view.setApellido1(nombre.getApellido1());
			view.setApellido2(nombre.getApellido2());
			view.setDni(nombre.getDni());
			view.setFechaNac(mujer.getFechaNac());
			view.setTelfFijo(mujer.getTelfFijo());
			view.setTelfMovil(mujer.getTelfMovil());
			view.setId(mujer.getId());			
		}
		return view;
	}

}
