package org.upsam.sypweb.domain.aula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.upsam.sypweb.domain.mujer.Mujer;

@Entity
@NamedQueries({
	@NamedQuery(
		name  = "getListAulaAbiertaTalleresDisponibles",
		query = "SELECT DISTINCT aa " +
				"FROM AulaAbierta aa " +
				"WHERE aa.inicio > :fecha " +
				"AND aa.id NOT IN " +
				"( " +
					"SELECT aa2.id " +
					"FROM AulaAbierta aa2 " +
					"JOIN aa2.personas p " +
					"WHERE p = :persona " +
				" )"
	),
	@NamedQuery(
		name  = "getListAulaAbiertaNoComenzados",
		query = "SELECT DISTINCT aa " +
		        "FROM AulaAbierta aa " +
				"JOIN aa.personas p " +
				"WHERE p = :persona " +
				"AND aa.inicio > :fecha"
	),
	@NamedQuery(
		name  = "getListAulaAbiertaCursaEnFecha",
		query = "SELECT DISTINCT aa " +
				"FROM AulaAbierta aa " +
				"JOIN aa.personas p " +
				"WHERE p = :persona " +
				"AND aa.inicio <= :fecha1 " +
				"AND aa.fin >= :fecha2"
	)
})

public class AulaAbierta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Temporal(TemporalType.DATE)
	private Date fin;

	private Integer maxPlazas;

	@ManyToOne(fetch = FetchType.EAGER)
	private Taller curso;

	@ManyToMany(mappedBy = "talleres")
	private List<Mujer> personas = new ArrayList<Mujer>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

	/**
	 * @return the maxPlazas
	 */
	public Integer getMaxPlazas() {
		return maxPlazas;
	}

	/**
	 * @param maxPlazas the maxPlazas to set
	 */
	public void setMaxPlazas(Integer maxPlazas) {
		this.maxPlazas = maxPlazas;
	}

	/**
	 * @return the curso
	 */
	public Taller getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Taller curso) {
		this.curso = curso;
	}

	/**
	 * @return the personas
	 */
	public List<Mujer> getPersonas() {
		return personas;
	}

	/**
	 * @param personas the personas to set
	 */
	public void setPersonas(List<Mujer> personas) {
		this.personas = personas;
	}

}