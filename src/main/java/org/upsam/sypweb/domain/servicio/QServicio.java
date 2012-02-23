package org.upsam.sypweb.domain.servicio;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QServicio is a Querydsl query type for Servicio
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QServicio extends EntityPathBase<Servicio> {

    private static final long serialVersionUID = -1417427084;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QServicio servicio = new QServicio("servicio");

    public final ListPath<org.upsam.sypweb.domain.citas.Citacion, org.upsam.sypweb.domain.citas.QCitacion> citaciones = this.<org.upsam.sypweb.domain.citas.Citacion, org.upsam.sypweb.domain.citas.QCitacion>createList("citaciones", org.upsam.sypweb.domain.citas.Citacion.class, org.upsam.sypweb.domain.citas.QCitacion.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final ListPath<Horario, QHorario> disponibilidad = this.<Horario, QHorario>createList("disponibilidad", Horario.class, QHorario.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final org.upsam.sypweb.domain.user.QUser responsable;

    public QServicio(String variable) {
        this(Servicio.class, forVariable(variable), INITS);
    }

    public QServicio(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QServicio(PathMetadata<?> metadata, PathInits inits) {
        this(Servicio.class, metadata, inits);
    }

    public QServicio(Class<? extends Servicio> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.responsable = inits.isInitialized("responsable") ? new org.upsam.sypweb.domain.user.QUser(forProperty("responsable")) : null;
    }

}

