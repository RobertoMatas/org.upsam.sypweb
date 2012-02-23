package org.upsam.sypweb.domain.aula;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QAulaAbierta is a Querydsl query type for AulaAbierta
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAulaAbierta extends EntityPathBase<AulaAbierta> {

    private static final long serialVersionUID = 988906574;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QAulaAbierta aulaAbierta = new QAulaAbierta("aulaAbierta");

    public final QTaller curso;

    public final DateTimePath<java.util.Date> fin = createDateTime("fin", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> inicio = createDateTime("inicio", java.util.Date.class);

    public final NumberPath<Integer> maxPlazas = createNumber("maxPlazas", Integer.class);

    public final ListPath<org.upsam.sypweb.domain.mujer.Mujer, org.upsam.sypweb.domain.mujer.QMujer> personas = this.<org.upsam.sypweb.domain.mujer.Mujer, org.upsam.sypweb.domain.mujer.QMujer>createList("personas", org.upsam.sypweb.domain.mujer.Mujer.class, org.upsam.sypweb.domain.mujer.QMujer.class);

    public QAulaAbierta(String variable) {
        this(AulaAbierta.class, forVariable(variable), INITS);
    }

    public QAulaAbierta(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAulaAbierta(PathMetadata<?> metadata, PathInits inits) {
        this(AulaAbierta.class, metadata, inits);
    }

    public QAulaAbierta(Class<? extends AulaAbierta> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.curso = inits.isInitialized("curso") ? new QTaller(forProperty("curso")) : null;
    }

}

