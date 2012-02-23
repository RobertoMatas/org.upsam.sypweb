package org.upsam.sypweb.domain.mujer;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QNombre is a Querydsl query type for Nombre
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QNombre extends BeanPath<Nombre> {

    private static final long serialVersionUID = -1774480734;

    public static final QNombre nombre1 = new QNombre("nombre1");

    public final StringPath apellido1 = createString("apellido1");

    public final StringPath apellido2 = createString("apellido2");

    public final StringPath dni = createString("dni");

    public final StringPath nombre = createString("nombre");

    public QNombre(String variable) {
        super(Nombre.class, forVariable(variable));
    }

    public QNombre(Path<? extends Nombre> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QNombre(PathMetadata<?> metadata) {
        super(Nombre.class, metadata);
    }

}

