package org.upsam.sypweb.domain.mujer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Mujer> findAll(Predicate filter) {
		Iterable<Mujer> it = mujerRepository.findAll(filter);
		List<Mujer> mujeres = new ArrayList<Mujer>();
		for (Mujer mujer : it) {
			mujeres.add(mujer);
		}
		return mujeres;
	}

}
