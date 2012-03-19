package org.upsam.sypweb.domain.citas;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.servicio.Servicio;

public interface CitacionRepository extends QueryDslPredicateExecutor<Citacion>, JpaRepository<Citacion, Long>, JpaSpecificationExecutor<Citacion> {

	List<Citacion> findByMujer(Mujer mujer);
	
	List<Citacion> findByServicioAndCitaGreaterThan(Servicio servicio, Date cita);
}
