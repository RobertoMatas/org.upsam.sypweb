package org.upsam.sypweb.domain.servicio;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QHorario is a Querydsl query type for Horario
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QHorario extends EntityPathBase<Horario> {

    private static final long serialVersionUID = 37176708;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QHorario horario = new QHorario("horario");

    public final NumberPath<Integer> diaSemana = createNumber("diaSemana", Integer.class);

    public final StringPath hora = createString("hora");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QServicio servicio;

    public final NumberPath<Integer> servicioId = createNumber("servicioId", Integer.class);

    public QHorario(String variable) {
        this(Horario.class, forVariable(variable), INITS);
    }

    public QHorario(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHorario(PathMetadata<?> metadata, PathInits inits) {
        this(Horario.class, metadata, inits);
    }

    public QHorario(Class<? extends Horario> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.servicio = inits.isInitialized("servicio") ? new QServicio(forProperty("servicio"), inits.get("servicio")) : null;
    }

}

