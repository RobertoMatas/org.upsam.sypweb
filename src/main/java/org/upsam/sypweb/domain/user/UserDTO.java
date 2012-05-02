package org.upsam.sypweb.domain.user;

import java.io.Serializable;

import org.upsam.sypweb.domain.servicio.ServicioDTO;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2724638406403777833L;
	/**
	 * Nombre de usuario
	 */
	private String userName;
	/**
	 * Rol
	 */
	private Role authority;
	/**
	 * Servicio del cual es resposable (si el usuario tiene rol de especialista)
	 */
	private ServicioDTO servicio;

	/**
	 * @param userName
	 */
	public UserDTO(String userName) {
		super();
		this.userName = userName;
		this.authority = Role.ROLE_ADMINISTRATIVO;
	}

	/**
	 * @param userName
	 * @param servicio
	 */
	public UserDTO(String userName, ServicioDTO servicio) {
		super();
		this.userName = userName;
		this.servicio = servicio;
		if (servicio != null) {
			this.authority = Role.ROLE_ESPECIALISTA;
		} else {
			this.authority = Role.ROLE_ADMINISTRATIVO;
		}
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the authority
	 */
	public Role getAuthority() {
		return authority;
	}

	/**
	 * @return the servicio
	 */
	public ServicioDTO getServicio() {
		return servicio;
	}
}
