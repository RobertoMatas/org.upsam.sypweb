package org.upsam.sypweb.domain.mujer;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QMujer is a Querydsl query type for Mujer
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMujer extends EntityPathBase<Mujer> {

    private static final long serialVersionUID = 219105782;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QMujer mujer = new QMujer("mujer");

    public final ListPath<org.upsam.sypweb.domain.citas.Citacion, org.upsam.sypweb.domain.citas.QCitacion> citaciones = this.<org.upsam.sypweb.domain.citas.Citacion, org.upsam.sypweb.domain.citas.QCitacion>createList("citaciones", org.upsam.sypweb.domain.citas.Citacion.class, org.upsam.sypweb.domain.citas.QCitacion.class);

    public final org.upsam.sypweb.domain.mujer.domicilio.QDomicilio domicilio;

    public final BooleanPath empadronada = createBoolean("empadronada");

    public final DateTimePath<java.util.Date> fechaAlta = createDateTime("fechaAlta", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaNac = createDateTime("fechaNac", java.util.Date.class);

    public final ListPath<org.upsam.sypweb.domain.ficha.Ficha, org.upsam.sypweb.domain.ficha.QFicha> fichas = this.<org.upsam.sypweb.domain.ficha.Ficha, org.upsam.sypweb.domain.ficha.QFicha>createList("fichas", org.upsam.sypweb.domain.ficha.Ficha.class, org.upsam.sypweb.domain.ficha.QFicha.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QNombre nombre;

    public final ListPath<org.upsam.sypweb.domain.aula.AulaAbierta, org.upsam.sypweb.domain.aula.QAulaAbierta> talleres = this.<org.upsam.sypweb.domain.aula.AulaAbierta, org.upsam.sypweb.domain.aula.QAulaAbierta>createList("talleres", org.upsam.sypweb.domain.aula.AulaAbierta.class, org.upsam.sypweb.domain.aula.QAulaAbierta.class);

    public final StringPath telfFijo = createString("telfFijo");

    public final StringPath telfMovil = createString("telfMovil");

    public QMujer(String variable) {
        this(Mujer.class, forVariable(variable), INITS);
    }

    public QMujer(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMujer(PathMetadata<?> metadata, PathInits inits) {
        this(Mujer.class, metadata, inits);
    }

    public QMujer(Class<? extends Mujer> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.domicilio = inits.isInitialized("domicilio") ? new org.upsam.sypweb.domain.mujer.domicilio.QDomicilio(forProperty("domicilio"), inits.get("domicilio")) : null;
        this.nombre = inits.isInitialized("nombre") ? new QNombre(forProperty("nombre")) : null;
    }

}

