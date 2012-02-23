package org.upsam.sypweb.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerRepository;
import org.upsam.sypweb.domain.mujer.Nombre;
import org.upsam.sypweb.domain.mujer.QMujer;

import com.mysema.query.types.expr.BooleanExpression;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles("dev")
public class MujerRepositoryTest {

	@Autowired
	MujerRepository mujerRepository;

	@Test
	public void testFindById() {
		Mujer mujer = mujerRepository.findOne(1L);
		Assert.assertNotNull(mujer);
	}
	
	@Test
	public void testFindBySpec() {
		Specification<Mujer> spec = new Specification<Mujer>() {			
			@Override
			public Predicate toPredicate(Root<Mujer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<Nombre> nombre = root.<Nombre> get("nombre");
				return cb.equal(nombre.<String> get("nombre"), "Laura");	
			}
		};
		List<Mujer> mujeres = mujerRepository.findAll(spec);
		for (Mujer mujer : mujeres) {
			assertThat(mujer.getNombre().getNombre(), is("Laura"));
		}
		Assert.assertNotNull(mujeres);
	}
	
	@Test
	public void testFindByQueryDsl() {
		final BooleanExpression nombreLike = QMujer.mujer.nombre.nombre.like("Laura");
		final BooleanExpression apellido1Eq = QMujer.mujer.nombre.apellido1.eq("Steel");
		Iterable<Mujer> mujeres = mujerRepository.findAll(nombreLike.and(apellido1Eq));
		for (Mujer mujer : mujeres) {
			assertThat(mujer.getNombre().getNombre(), is("Laura"));
			assertThat(mujer.getNombre().getApellido1(), is("Steel"));
		}
		Assert.assertNotNull(mujeres);
	}
}
