package org.upsam.sypweb.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConvert<SRC, DEST extends Serializable> implements Converter<SRC, DEST> {

	@Override
	public List<DEST> convert(Iterable<SRC> sources) {
		List<DEST> dest = new ArrayList<DEST>();
		for (SRC src : sources) {
			dest.add(convert(src));
		}
		return dest;
	}

}
