package org.upsam.sypweb.domain.ficha;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QDocumentoAdjunto is a Querydsl query type for DocumentoAdjunto
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDocumentoAdjunto extends EntityPathBase<DocumentoAdjunto> {

    private static final long serialVersionUID = -344774026;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QDocumentoAdjunto documentoAdjunto = new QDocumentoAdjunto("documentoAdjunto");

    public final StringPath descripcion = createString("descripcion");

    public final ArrayPath<Byte> documento = createArray("documento", Byte[].class);

    public final QFicha ficha;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath tipo = createString("tipo");

    public QDocumentoAdjunto(String variable) {
        this(DocumentoAdjunto.class, forVariable(variable), INITS);
    }

    public QDocumentoAdjunto(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDocumentoAdjunto(PathMetadata<?> metadata, PathInits inits) {
        this(DocumentoAdjunto.class, metadata, inits);
    }

    public QDocumentoAdjunto(Class<? extends DocumentoAdjunto> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ficha = inits.isInitialized("ficha") ? new QFicha(forProperty("ficha"), inits.get("ficha")) : null;
    }

}

