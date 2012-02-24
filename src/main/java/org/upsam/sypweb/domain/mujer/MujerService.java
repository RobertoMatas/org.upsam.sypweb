package org.upsam.sypweb.domain.mujer;

import java.util.List;

import com.mysema.query.types.Predicate;

public interface MujerService {

	List<Mujer> findAll(Predicate filter);
}
