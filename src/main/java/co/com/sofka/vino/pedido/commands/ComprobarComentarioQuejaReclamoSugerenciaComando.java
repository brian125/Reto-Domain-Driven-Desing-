package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.pedido.QuejaReclamoSugerencia;
import co.com.sofka.vino.pedido.values.PedidoId;

import java.util.Set;

public class ComprobarComentarioQuejaReclamoSugerenciaComando extends Command {

    private final PedidoId pedidoId;
    private final Set<QuejaReclamoSugerencia> quejaReclamoSugerencias;

    public ComprobarComentarioQuejaReclamoSugerenciaComando(PedidoId pedidoId, Set<QuejaReclamoSugerencia> quejaReclamoSugerencias) {
        this.pedidoId = pedidoId;
        this.quejaReclamoSugerencias = quejaReclamoSugerencias;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Set<QuejaReclamoSugerencia> getQuejaReclamoSugerencias() {
        return quejaReclamoSugerencias;
    }
}
