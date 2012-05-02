package org.upsam.sypweb.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends QueryDslPredicateExecutor<User>, JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	
	User findByUserName(String userName);
}
