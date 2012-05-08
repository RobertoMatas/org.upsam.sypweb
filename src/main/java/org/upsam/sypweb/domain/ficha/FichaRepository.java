package org.upsam.sypweb.domain.ficha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface FichaRepository extends QueryDslPredicateExecutor<Ficha>, JpaRepository<Ficha, Long>, JpaSpecificationExecutor<Ficha> {
	
}
