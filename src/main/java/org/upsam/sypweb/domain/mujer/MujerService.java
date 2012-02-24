package org.upsam.sypweb.domain.mujer;

import java.util.List;

import org.upsam.sypweb.view.BusqMujerView;
import org.upsam.sypweb.view.MujerView;

public interface MujerService {

	List<MujerView> findAll(BusqMujerView filter);
}
