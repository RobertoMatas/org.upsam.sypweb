package org.upsam.sypweb.domain.citas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.upsam.sypweb.domain.mujer.Mujer;

public interface CitacionRepository extends QueryDslPredicateExecutor<Citacion>, JpaRepository<Citacion, Long>, JpaSpecificationExecutor<Citacion> {

	List<Citacion> findByMujer(Mujer mujer);
}
