package org.upsam.sypweb.view;

import java.util.List;

public class MujerDetailedView extends MujerView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5791316290854112709L;
	/**
	 * Servicios utilizados por esta mujer
	 */
	private List<ServicioView> usedServices;
	/**
	 * Citas pendientes de la mujer
	 */
	private List<CitacionView> citasPendientes;
	/**
	 * Historíco de citas
	 */
	private List<CitacionView> historicoCitas;
	/**
	 * Talleres a los que ha acudido la mujer
	 */
	private List<AulaAbiertaView> talleres;

	/**
	 * @return the usedServices
	 */
	public List<ServicioView> getUsedServices() {
		return usedServices;
	}

	/**
	 * @param usedServices
	 *            the usedServices to set
	 */
	public void setUsedServices(List<ServicioView> usedServices) {
		this.usedServices = usedServices;
	}

	/**
	 * @return the citasPendientes
	 */
	public List<CitacionView> getCitasPendientes() {
		return citasPendientes;
	}

	/**
	 * @param citasPendientes
	 *            the citasPendientes to set
	 */
	public void setCitasPendientes(List<CitacionView> citasPendientes) {
		this.citasPendientes = citasPendientes;
	}

	/**
	 * @return the historicoCitas
	 */
	public List<CitacionView> getHistoricoCitas() {
		return historicoCitas;
	}

	/**
	 * @param historicoCitas
	 *            the historicoCitas to set
	 */
	public void setHistoricoCitas(List<CitacionView> historicoCitas) {
		this.historicoCitas = historicoCitas;
	}

	/**
	 * @return the talleres
	 */
	public List<AulaAbiertaView> getTalleres() {
		return talleres;
	}

	/**
	 * @param talleres
	 *            the talleres to set
	 */
	public void setTalleres(List<AulaAbiertaView> talleres) {
		this.talleres = talleres;
	}

}
