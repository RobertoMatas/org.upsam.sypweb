package org.upsam.sypweb.view;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BusqMujerView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8781350426816793013L;
	/**
	 * 
	 */
	@NotNull
	@Size(min = 1, max = 60)
	private String nombre;
	/**
	 * 
	 */
	@NotNull
	@Size(min = 1, max = 30)
	private String apellido1;
	/**
	 * 
	 */
	@NotNull
	@Size(min = 1, max = 30)
	private String apellido2;
	/**
	 * 
	 */
	@NotNull
	@Size(min = 1, max = 9)
	private String dni;
	/**
	 * 
	 */
	private String telfFijo;
	/**
	 * 
	 */
	private String telfMovil;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1
	 *            the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2
	 *            the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the telfFijo
	 */
	public String getTelfFijo() {
		return telfFijo;
	}

	/**
	 * @param telfFijo
	 *            the telfFijo to set
	 */
	public void setTelfFijo(String telfFijo) {
		this.telfFijo = telfFijo;
	}

	/**
	 * @return the telfMovil
	 */
	public String getTelfMovil() {
		return telfMovil;
	}

	/**
	 * @param telfMovil
	 *            the telfMovil to set
	 */
	public void setTelfMovil(String telfMovil) {
		this.telfMovil = telfMovil;
	}

}
