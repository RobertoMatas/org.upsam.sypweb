package org.upsam.sypweb.domain.aula;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QTaller is a Querydsl query type for Taller
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaller extends EntityPathBase<Taller> {

    private static final long serialVersionUID = -803126267;

    public static final QTaller taller1 = new QTaller("taller1");

    public final StringPath codigo = createString("codigo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath taller = createString("taller");

    public QTaller(String variable) {
        super(Taller.class, forVariable(variable));
    }

    public QTaller(Path<? extends Taller> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QTaller(PathMetadata<?> metadata) {
        super(Taller.class, metadata);
    }

}

