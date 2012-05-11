package org.upsam.sypweb.view;

import java.io.InputStream;

public class ByteDocumentView extends DocumentoView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6731090429004022707L;
	/**
	 * Fichero físico
	 */
	private InputStream docBytes;
	
	/**
	 * 
	 * @param id
	 * @param tipo
	 * @param descripcion
	 */
	public ByteDocumentView(Long id, String tipo, String descripcion) {
		super(id, tipo, descripcion);
	}
	/**
	 * @return the docBytes
	 */
	public InputStream getDocBytes() {
		return docBytes;
	}
	/**
	 * @param docBytes the docBytes to set
	 */
	public void setDocBytes(InputStream docBytes) {
		this.docBytes = docBytes;
	}

}
