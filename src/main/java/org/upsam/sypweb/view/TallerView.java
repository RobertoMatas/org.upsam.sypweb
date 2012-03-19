package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

public class TallerView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3017910110769351579L;
	/**
	 * Nombre del curso
	 */
	private String taller;
	/**
	 * Fecha de inicio
	 */
	private Date inicio;
	/**
	 * Fecha de fin
	 */
	private Date fin;

	/**
	 * @param taller
	 * @param inicio
	 * @param fin
	 */
	public TallerView(String taller, Date inicio, Date fin) {
		super();
		this.taller = taller;
		this.inicio = inicio;
		this.fin = fin;
	}

	/**
	 * @return the taller
	 */
	public String getTaller() {
		return taller;
	}

	/**
	 * @param taller
	 *            the taller to set
	 */
	public void setTaller(String taller) {
		this.taller = taller;
	}

	/**
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

}
