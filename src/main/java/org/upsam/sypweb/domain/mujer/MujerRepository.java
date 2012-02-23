package org.upsam.sypweb.domain.mujer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MujerRepository extends QueryDslPredicateExecutor<Mujer>, JpaRepository<Mujer, Long>, JpaSpecificationExecutor<Mujer> {

}
