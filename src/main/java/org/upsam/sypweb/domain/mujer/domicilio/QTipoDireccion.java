package org.upsam.sypweb.domain.mujer.domicilio;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QTipoDireccion is a Querydsl query type for TipoDireccion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTipoDireccion extends EntityPathBase<TipoDireccion> {

    private static final long serialVersionUID = 1789801946;

    public static final QTipoDireccion tipoDireccion = new QTipoDireccion("tipoDireccion");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoDireccion(String variable) {
        super(TipoDireccion.class, forVariable(variable));
    }

    public QTipoDireccion(Path<? extends TipoDireccion> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QTipoDireccion(PathMetadata<?> metadata) {
        super(TipoDireccion.class, metadata);
    }

}

