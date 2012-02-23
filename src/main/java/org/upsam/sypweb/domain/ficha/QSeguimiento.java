package org.upsam.sypweb.domain.ficha;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QSeguimiento is a Querydsl query type for Seguimiento
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSeguimiento extends EntityPathBase<Seguimiento> {

    private static final long serialVersionUID = -1304033734;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSeguimiento seguimiento = new QSeguimiento("seguimiento");

    public final DateTimePath<java.util.Date> fecha = createDateTime("fecha", java.util.Date.class);

    public final QFicha ficha;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath observaciones = createString("observaciones");

    public QSeguimiento(String variable) {
        this(Seguimiento.class, forVariable(variable), INITS);
    }

    public QSeguimiento(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSeguimiento(PathMetadata<?> metadata, PathInits inits) {
        this(Seguimiento.class, metadata, inits);
    }

    public QSeguimiento(Class<? extends Seguimiento> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ficha = inits.isInitialized("ficha") ? new QFicha(forProperty("ficha"), inits.get("ficha")) : null;
    }

}

