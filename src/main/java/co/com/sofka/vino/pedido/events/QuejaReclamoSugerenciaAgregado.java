package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.pedido.values.Comentario;
import co.com.sofka.vino.pedido.values.QuejaReclamoSugerenciaId;

public class QuejaReclamoSugerenciaAgregado extends DomainEvent {

    private final QuejaReclamoSugerenciaId quejaReclamoSugerenciaId;
    private final Comentario comentario;

    public QuejaReclamoSugerenciaAgregado(QuejaReclamoSugerenciaId quejaReclamoSugerenciaId, Comentario comentario) {
        super("sofka.pedido.quejareclamosugerenciaagregado");
        this.quejaReclamoSugerenciaId = quejaReclamoSugerenciaId;
        this.comentario = comentario;
    }

    public QuejaReclamoSugerenciaId getQuejaReclamoSugerenciaId() {
        return quejaReclamoSugerenciaId;
    }

    public Comentario getComentario() {
        return comentario;
    }
}
