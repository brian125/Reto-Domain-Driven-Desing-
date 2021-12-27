package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.pedido.QuejaReclamoSugerencia;

import java.util.Set;

public class ComentarioReclamoSugerenciaComprobado extends DomainEvent {

    private final Set<QuejaReclamoSugerencia> quejaReclamoSugerencias;

    public ComentarioReclamoSugerenciaComprobado(Set <QuejaReclamoSugerencia> quejaReclamoSugerencia) {
        super("sofka.pedido.comentarioreclamosugerenciacomprobado");
        this.quejaReclamoSugerencias = quejaReclamoSugerencia;
    }

    public Set<QuejaReclamoSugerencia> getQuejaReclamoSugerencias() {
        return quejaReclamoSugerencias;
    }
}
