package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

public class MujerView extends BusqMujerView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1705456000652755141L;
	/**
	 * 
	 */
	private Long id;
	/**
	 * Email
	 */
	private String email;
	/**
	 * 
	 */
	private Date fechaNac;
	/**
	 * 
	 */
	private Date fechaAlta;
	/**
	 * 
	 */
	private Boolean empadronada;
	/**
	 * 
	 */
	private DomicilioView domicilio;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param fechaNac
	 *            the fechaNac to set
	 */
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta
	 *            the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the empadronada
	 */
	public Boolean getEmpadronada() {
		return empadronada;
	}

	/**
	 * @param empadronada
	 *            the empadronada to set
	 */
	public void setEmpadronada(Boolean empadronada) {
		this.empadronada = empadronada;
	}

	/**
	 * @return the domicilio
	 */
	public DomicilioView getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio
	 *            the domicilio to set
	 */
	public void setDomicilio(DomicilioView domicilio) {
		this.domicilio = domicilio;
	}

}
