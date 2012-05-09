package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

public class SeguimientoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680958074002528572L;
	/**
	 * ID de seguimiento
	 */
	private Long id;
	/**
	 * Fecha de seguimiento
	 */
	private Date fecha;
	/**
	 * Observaciones
	 */
	private String observaciones;

	/**
	 * @param fecha
	 * @param observaciones
	 */
	public SeguimientoView(Long id, Date fecha, String observaciones) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
