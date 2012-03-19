package org.upsam.sypweb.facade;

import org.upsam.sypweb.view.MujerDetailedView;

public interface MujerServiceFacade {

	MujerDetailedView find(Long mujerId);
}
