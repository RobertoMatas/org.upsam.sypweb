/**
 * 
 */
package org.upsam.sypweb.domain.servicio;

import java.io.Serializable;

/**
 * @author Roberto
 * 
 */
public class ServicioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8415347060697264028L;
	/**
	 * ID de servicio
	 */
	private Integer id;
	/**
	 * Descripción
	 */
	private String descripcion;

	/**
	 * @param id
	 * @param descripcion
	 */
	public ServicioDTO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

}
