package org.upsam.sypweb.view;

import java.io.Serializable;

public class ServicioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8954042510944669898L;
	/**
	 * Identificador de servicio
	 */
	private Integer id;
	/**
	 * Nombre del servicio
	 */
	private String service;
	/**
	 * Nombre del responsable del servicio
	 */
	private String responsable;

	/**
	 * 
	 * @param id
	 * @param service
	 * @param responsable
	 */
	public ServicioView(Integer id, String service, String responsable) {
		super();
		this.id = id;
		this.service = service;
		this.responsable = responsable;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable
	 *            the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

}
