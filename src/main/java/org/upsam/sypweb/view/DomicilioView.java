package org.upsam.sypweb.view;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DomicilioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8576596755204073152L;
	/**
	 * 
	 */
	@NotNull
	private Integer tipoDireccionId;
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
	private Integer numero;
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
	private String escalera;
	/**
	 * 
	 */
	private String poblacion;
	/**
	 * 
	 */
	@NotNull
	private Integer provinciaId;
	/**
	 * 
	 */
	private String nombreProvincia;

	/**
	 * @return the tipoDireccionId
	 */
	public Integer getTipoDireccionId() {
		return tipoDireccionId;
	}

	/**
	 * @param tipoDireccionId
	 *            the tipoDireccionId to set
	 */
	public void setTipoDireccionId(Integer tipoDireccionId) {
		this.tipoDireccionId = tipoDireccionId;
	}

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
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	 * @return the escalera
	 */
	public String getEscalera() {
		return escalera;
	}

	/**
	 * @param escalera
	 *            the escalera to set
	 */
	public void setEscalera(String escalera) {
		this.escalera = escalera;
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
	 * @return the provinciaId
	 */
	public Integer getProvinciaId() {
		return provinciaId;
	}

	/**
	 * @param provinciaId
	 *            the provinciaId to set
	 */
	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
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
