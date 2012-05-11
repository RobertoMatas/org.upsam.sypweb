package org.upsam.sypweb.view;

import java.io.Serializable;

public class DocumentoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7882219806380036613L;
	/**
	 * ID de documento adjunto
	 */
	private Long id;
	/**
	 * Tipo MIME del documento
	 */
	private String tipo;
	/**
	 * Descripción del documento
	 */
	private String descripcion;

	/**
	 * @param id
	 * @param tipo
	 * @param descripcion
	 */
	public DocumentoView(Long id, String tipo, String descripcion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
