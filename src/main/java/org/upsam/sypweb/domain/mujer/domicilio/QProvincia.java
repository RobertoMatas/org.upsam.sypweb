package org.upsam.sypweb.domain.mujer.domicilio;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QProvincia is a Querydsl query type for Provincia
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProvincia extends EntityPathBase<Provincia> {

    private static final long serialVersionUID = -1165267925;

    public static final QProvincia provincia = new QProvincia("provincia");

    public final StringPath codigo = createString("codigo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nombre = createString("nombre");

    public QProvincia(String variable) {
        super(Provincia.class, forVariable(variable));
    }

    public QProvincia(Path<? extends Provincia> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QProvincia(PathMetadata<?> metadata) {
        super(Provincia.class, metadata);
    }

}

