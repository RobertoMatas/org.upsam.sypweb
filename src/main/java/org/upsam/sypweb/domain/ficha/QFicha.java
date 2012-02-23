package org.upsam.sypweb.domain.ficha;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QFicha is a Querydsl query type for Ficha
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFicha extends EntityPathBase<Ficha> {

    private static final long serialVersionUID = 762279050;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QFicha ficha = new QFicha("ficha");

    public final ListPath<DocumentoAdjunto, QDocumentoAdjunto> adjuntos = this.<DocumentoAdjunto, QDocumentoAdjunto>createList("adjuntos", DocumentoAdjunto.class, QDocumentoAdjunto.class);

    public final DateTimePath<java.util.Date> apertura = createDateTime("apertura", java.util.Date.class);

    public final BooleanPath cerrada = createBoolean("cerrada");

    public final DateTimePath<java.util.Date> cierre = createDateTime("cierre", java.util.Date.class);

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.upsam.sypweb.domain.mujer.QMujer mujer;

    public final ListPath<Seguimiento, QSeguimiento> seguimientos = this.<Seguimiento, QSeguimiento>createList("seguimientos", Seguimiento.class, QSeguimiento.class);

    public final org.upsam.sypweb.domain.servicio.QServicio servicio;

    public QFicha(String variable) {
        this(Ficha.class, forVariable(variable), INITS);
    }

    public QFicha(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFicha(PathMetadata<?> metadata, PathInits inits) {
        this(Ficha.class, metadata, inits);
    }

    public QFicha(Class<? extends Ficha> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mujer = inits.isInitialized("mujer") ? new org.upsam.sypweb.domain.mujer.QMujer(forProperty("mujer"), inits.get("mujer")) : null;
        this.servicio = inits.isInitialized("servicio") ? new org.upsam.sypweb.domain.servicio.QServicio(forProperty("servicio"), inits.get("servicio")) : null;
    }

}

