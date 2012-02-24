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
	 * 
	 */
	private Date fechaNac;
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
