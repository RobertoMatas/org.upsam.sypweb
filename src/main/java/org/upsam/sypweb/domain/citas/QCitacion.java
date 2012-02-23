package org.upsam.sypweb.domain.citas;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QCitacion is a Querydsl query type for Citacion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCitacion extends EntityPathBase<Citacion> {

    private static final long serialVersionUID = 977612480;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QCitacion citacion = new QCitacion("citacion");

    public final BooleanPath acudio = createBoolean("acudio");

    public final DateTimePath<java.util.Date> cita = createDateTime("cita", java.util.Date.class);

    public final StringPath hora = createString("hora");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.upsam.sypweb.domain.mujer.QMujer mujer;

    public final org.upsam.sypweb.domain.servicio.QServicio servicio;

    public QCitacion(String variable) {
        this(Citacion.class, forVariable(variable), INITS);
    }

    public QCitacion(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCitacion(PathMetadata<?> metadata, PathInits inits) {
        this(Citacion.class, metadata, inits);
    }

    public QCitacion(Class<? extends Citacion> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mujer = inits.isInitialized("mujer") ? new org.upsam.sypweb.domain.mujer.QMujer(forProperty("mujer"), inits.get("mujer")) : null;
        this.servicio = inits.isInitialized("servicio") ? new org.upsam.sypweb.domain.servicio.QServicio(forProperty("servicio"), inits.get("servicio")) : null;
    }

}

