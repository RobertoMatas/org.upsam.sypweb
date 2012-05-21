package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String email;
	/**
	 * 
	 */
	@Past
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
	@Valid
	private DomicilioView domicilio;

	/**
	 * 
	 */
	public MujerView() {
		super();
		this.domicilio = new DomicilioView();
	}

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
