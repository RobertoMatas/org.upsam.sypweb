package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

public class AulaAbiertaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1548628337608320312L;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * Fecha de inicio
	 */
	private Date inicio;
	/**
	 * Fecha de fin
	 */
	private Date fin;
	/**
	 * Número de plazas de esta edición del curso
	 */
	private Integer numPlazas;
	/**
	 * Número de alumnos inscritos
	 */
	private Integer numAlumnos;
	/**
	 * Nombre del taller
	 */
	private String taller;

	/**
	 * 
	 */
	public AulaAbiertaView() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the numPlazas
	 */
	public Integer getNumPlazas() {
		return numPlazas;
	}

	/**
	 * @param numPlazas
	 *            the numPlazas to set
	 */
	public void setNumPlazas(Integer numPlazas) {
		this.numPlazas = numPlazas;
	}

	/**
	 * @return the numAlumnos
	 */
	public Integer getNumAlumnos() {
		return numAlumnos;
	}

	/**
	 * @param numAlumnos
	 *            the numAlumnos to set
	 */
	public void setNumAlumnos(Integer numAlumnos) {
		this.numAlumnos = numAlumnos;
	}

	/**
	 * @return the plazasLibre
	 */
	public Integer getPlazasLibres() {
		return this.numPlazas - this.numAlumnos;
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
}
