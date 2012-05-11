package org.upsam.sypweb.controller.ficha;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class DocumentoForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3050382537522037638L;
	/**
	 * Descripción del documento
	 */
	@NotNull
	@Size(min = 1, max = 250)
	private String descripcion;
	/**
	 * Fichero subido
	 */
	@NotNull
	private MultipartFile file;
	/**
	 * Id de la ficha a la que pertenece
	 */
	private Long fichaId;

	/**
	 * @return the fichaId
	 */
	public Long getFichaId() {
		return fichaId;
	}

	/**
	 * @param fichaId
	 *            the fichaId to set
	 */
	public void setFichaId(Long fichaId) {
		this.fichaId = fichaId;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
