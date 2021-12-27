package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.pedido.values.Comentario;
import co.com.sofka.vino.pedido.values.PedidoId;
import co.com.sofka.vino.pedido.values.QuejaReclamoSugerenciaId;

public class AgregarQuejaReclamoSugerenciaComando extends Command {

    private final PedidoId pedidoId;
    private final QuejaReclamoSugerenciaId quejaReclamoSugerenciaId;
    private final Comentario comentario;

    public AgregarQuejaReclamoSugerenciaComando(PedidoId pedidoId, QuejaReclamoSugerenciaId quejaReclamoSugerenciaId, Comentario comentario) {
        this.pedidoId = pedidoId;
        this.quejaReclamoSugerenciaId = quejaReclamoSugerenciaId;
        this.comentario = comentario;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public QuejaReclamoSugerenciaId getQuejaReclamoSugerenciaId() {
        return quejaReclamoSugerenciaId;
    }

    public Comentario getComentario() {
        return comentario;
    }
}
