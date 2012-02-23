package org.upsam.sypweb.domain.mujer.domicilio;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QDomicilio is a Querydsl query type for Domicilio
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDomicilio extends EntityPathBase<Domicilio> {

    private static final long serialVersionUID = 257984995;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QDomicilio domicilio = new QDomicilio("domicilio");

    public final StringPath escalera = createString("escalera");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ComparablePath<Character> letra = createComparable("letra", Character.class);

    public final StringPath nombreAvenida = createString("nombreAvenida");

    public final NumberPath<Integer> numero = createNumber("numero", Integer.class);

    public final NumberPath<Integer> piso = createNumber("piso", Integer.class);

    public final StringPath poblacion = createString("poblacion");

    public final QProvincia provincia;

    public final QTipoDireccion tipoDireccion;

    public QDomicilio(String variable) {
        this(Domicilio.class, forVariable(variable), INITS);
    }

    public QDomicilio(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDomicilio(PathMetadata<?> metadata, PathInits inits) {
        this(Domicilio.class, metadata, inits);
    }

    public QDomicilio(Class<? extends Domicilio> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.provincia = inits.isInitialized("provincia") ? new QProvincia(forProperty("provincia")) : null;
        this.tipoDireccion = inits.isInitialized("tipoDireccion") ? new QTipoDireccion(forProperty("tipoDireccion")) : null;
    }

}

