package org.upsam.sypweb.domain.servicio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.upsam.sypweb.domain.mujer.Mujer;

public interface ServicioRepository extends QueryDslPredicateExecutor<Servicio>, JpaRepository<Servicio, Integer>, JpaSpecificationExecutor<Servicio> {
	
	@Query("SELECT DISTINCT s " +
			"FROM Servicio s " +
			"JOIN s.citaciones citas " +
			"JOIN citas.mujer m " +
			"WHERE citas.acudio = TRUE " +
			"AND m = :mujer")
	List<Servicio> getUsedUservicesBy(@Param("mujer") Mujer mujer);
}
