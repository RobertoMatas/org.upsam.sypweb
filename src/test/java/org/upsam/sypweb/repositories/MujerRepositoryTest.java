package org.upsam.sypweb.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.MujerRepository;

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
}
