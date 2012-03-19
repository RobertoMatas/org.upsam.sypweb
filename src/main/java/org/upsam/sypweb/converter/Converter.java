package org.upsam.sypweb.converter;

import java.io.Serializable;
import java.util.List;

public interface Converter<SRC, DEST extends Serializable> {

	DEST convert(SRC source);
	
	List<DEST> convert(Iterable<SRC> sources);
}
