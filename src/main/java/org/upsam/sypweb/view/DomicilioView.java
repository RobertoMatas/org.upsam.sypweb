package org.upsam.sypweb.view;

import java.io.Serializable;

public class DomicilioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8576596755204073152L;

	/**
	 * 
	 */
	private String tipoDireccion;
	/**
	 * 
	 */
	private String nombreAvenida;
	/**
	 * 
	 */
	private String piso;
	/**
	 * 
	 */
	private String letra;
	/**
	 * 
	 */
	private String poblacion;
	/**
	 * 
	 */
	private String nombreProvincia;

	/**
	 * @return the tipoDireccion
	 */
	public String getTipoDireccion() {
		return tipoDireccion;
	}

	/**
	 * @param tipoDireccion
	 *            the tipoDireccion to set
	 */
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	/**
	 * @return the nombreAvenida
	 */
	public String getNombreAvenida() {
		return nombreAvenida;
	}

	/**
	 * @param nombreAvenida
	 *            the nombreAvenida to set
	 */
	public void setNombreAvenida(String nombreAvenida) {
		this.nombreAvenida = nombreAvenida;
	}

	/**
	 * @return the piso
	 */
	public String getPiso() {
		return piso;
	}

	/**
	 * @param piso
	 *            the piso to set
	 */
	public void setPiso(String piso) {
		this.piso = piso;
	}

	/**
	 * @return the letra
	 */
	public String getLetra() {
		return letra;
	}

	/**
	 * @param letra
	 *            the letra to set
	 */
	public void setLetra(String letra) {
		this.letra = letra;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion
	 *            the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the nombreProvincia
	 */
	public String getNombreProvincia() {
		return nombreProvincia;
	}

	/**
	 * @param nombreProvincia
	 *            the nombreProvincia to set
	 */
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

}
