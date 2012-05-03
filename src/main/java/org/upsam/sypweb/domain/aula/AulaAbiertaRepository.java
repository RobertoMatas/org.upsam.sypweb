package org.upsam.sypweb.domain.aula;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.upsam.sypweb.domain.mujer.Mujer;

public interface AulaAbiertaRepository extends QueryDslPredicateExecutor<AulaAbierta>, JpaRepository<AulaAbierta, Long>, JpaSpecificationExecutor<AulaAbierta> {

	@Query(
			"SELECT DISTINCT aa " +
			"FROM AulaAbierta aa " +
			"WHERE aa.inicio > :date " +
			"AND aa.id NOT IN " +
			"( " +
				"SELECT aa2.id " +
				"FROM AulaAbierta aa2 " +
				"JOIN aa2.personas p " +
				"WHERE p = :mujer " +
			" )"
	)
	List<AulaAbierta> findTalleresOfertadosByFechaAndMujer(@Param("date") Date date, @Param("mujer") Mujer mujer);
	
	@Query(
			"SELECT DISTINCT aa " +
	        "FROM AulaAbierta aa " +
			"JOIN aa.personas p " +
			"WHERE p = :mujer " +
			"AND aa.inicio > :date"
	)
	List<AulaAbierta> findTalleresNoComenzadosByFechaAndMujer(@Param("date") Date date, @Param("mujer") Mujer mujer);
	
	@Query(
			"SELECT DISTINCT aa " +
			"FROM AulaAbierta aa " +
			"JOIN aa.personas p " +
			"WHERE p = :mujer " +
			"AND aa.inicio <= :date1 " +
			"AND aa.fin >= :date2"
	)
	List<AulaAbierta> findTalleresCursadosByFechaAndMujer(@Param("date1") Date date1, @Param("date2") Date date2, @Param("mujer") Mujer mujer);
}
