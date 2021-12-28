package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.pedido.values.PedidoId;

public class GenerarSolicitudClienteComando extends Command {

    private final PedidoId pedidoId;
    private final Integer cantidad;

    public GenerarSolicitudClienteComando(PedidoId pedidoId, Integer cantidad) {
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
