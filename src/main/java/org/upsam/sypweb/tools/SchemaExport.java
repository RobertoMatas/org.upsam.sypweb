package org.upsam.sypweb.tools;

import org.hibernate.cfg.AnnotationConfiguration;
import org.upsam.sypweb.domain.aula.AulaAbierta;
import org.upsam.sypweb.domain.aula.Taller;
import org.upsam.sypweb.domain.citas.Citacion;
import org.upsam.sypweb.domain.ficha.DocumentoAdjunto;
import org.upsam.sypweb.domain.ficha.Ficha;
import org.upsam.sypweb.domain.ficha.Seguimiento;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.mujer.Nombre;
import org.upsam.sypweb.domain.mujer.domicilio.Domicilio;
import org.upsam.sypweb.domain.mujer.domicilio.Provincia;
import org.upsam.sypweb.domain.mujer.domicilio.TipoDireccion;
import org.upsam.sypweb.domain.servicio.Horario;
import org.upsam.sypweb.domain.servicio.Servicio;
import org.upsam.sypweb.domain.user.User;

public class SchemaExport {
	private static final String FILENAME = System.getProperty("java.io.tmpdir") + "script.sql";

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Horario.class);
		config.addAnnotatedClass(Servicio.class);
		config.addAnnotatedClass(Nombre.class);
		config.addAnnotatedClass(Mujer.class);
		config.addAnnotatedClass(Domicilio.class);
		config.addAnnotatedClass(Provincia.class);
		config.addAnnotatedClass(TipoDireccion.class);
		config.addAnnotatedClass(Ficha.class);
		config.addAnnotatedClass(Seguimiento.class);
		config.addAnnotatedClass(DocumentoAdjunto.class);
		config.addAnnotatedClass(Citacion.class);
		config.addAnnotatedClass(AulaAbierta.class);
		config.addAnnotatedClass(Taller.class);
		
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/concejalia");
		config.setProperty("hibernate.connection.username", "postgres");
		config.setProperty("hibernate.connection.password", "postgres");
		/*
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		config.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
		config.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:.");
		config.setProperty("hibernate.connection.username", "sa");
		config.setProperty("hibernate.connection.password", "");
		*/
		org.hibernate.tool.hbm2ddl.SchemaExport schemaExport = new org.hibernate.tool.hbm2ddl.SchemaExport(config);
		schemaExport.setOutputFile(FILENAME);
		schemaExport.create(true, false);
		System.out.println("Fichero creado en: " + FILENAME);
	}
}
