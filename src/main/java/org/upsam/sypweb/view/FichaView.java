package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

public class FichaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7016538868460028001L;
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private Date apertura;
	/**
	 * 
	 */
	private Date cierre;
	/**
	 * 
	 */
	private String descripcion;
	/**
	 * 
	 */
	private MujerView mujer;
	/**
	 * 
	 */
	private ServicioView servicio;

	/**
	 * @param id
	 * @param apertura
	 * @param mujer
	 * @param servicio
	 */
	public FichaView(Long id, Date apertura, MujerView mujer, ServicioView servicio) {
		super();
		this.id = id;
		this.apertura = apertura;
		this.mujer = mujer;
		this.servicio = servicio;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the apertura
	 */
	public Date getApertura() {
		return apertura;
	}

	/**
	 * @return the cierre
	 */
	public Date getCierre() {
		return cierre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the mujer
	 */
	public MujerView getMujer() {
		return mujer;
	}

	/**
	 * @return the servicio
	 */
	public ServicioView getServicio() {
		return servicio;
	}

	/**
	 * @param cierre the cierre to set
	 */
	public void setCierre(Date cierre) {
		this.cierre = cierre;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param mujer the mujer to set
	 */
	public void setMujer(MujerView mujer) {
		this.mujer = mujer;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(ServicioView servicio) {
		this.servicio = servicio;
	}

}
