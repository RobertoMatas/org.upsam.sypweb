package org.upsam.sypweb.domain.citas;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitaDTO implements Serializable {
	/**
	 * Formato de salida de fecha
	 */
	private final DateFormat df = new SimpleDateFormat("EEEE, dd/MM/yyyy");

	/**
	 * 
	 */
	private static final long serialVersionUID = -9095375181166326736L;
	/**
	 * Servicio al que se refiere la cita
	 */
	private String servicio;
	/**
	 * Día de la cita
	 */
	private String cita;
	/**
	 * Hora
	 */
	private String hora;
	/**
	 * Nombre y apellidos de la mujer citada
	 */
	private String nombre;
	/**
	 * Email de la mujer citada
	 */
	private String email;

	/**
	 * @param servicio
	 * @param cita
	 * @param hora
	 * @param nombre
	 * @param email
	 */
	public CitaDTO(String servicio, Date cita, String hora, String nombre, String email) {
		super();
		this.servicio = servicio;
		this.cita = df.format(cita);
		this.hora = hora.substring(0, 2) + ":" + hora.substring(4, 6);
		this.nombre = nombre;
		this.email = email;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @return the cita
	 */
	public String getCita() {
		return cita;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CitaDTO [servicio=" + servicio + ", cita=" + cita + ", hora="
				+ hora + ", nombre=" + nombre + "]";
	}

}
