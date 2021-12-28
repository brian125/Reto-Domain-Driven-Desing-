package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.pedido.values.PedidoId;
import co.com.sofka.vino.pedido.values.SolicitudCliente;

public class GenerarSolicitudClienteComando extends Command {

    private final PedidoId pedidoId;
    private final SolicitudCliente solicitudCliente;

    public GenerarSolicitudClienteComando(PedidoId pedidoId, SolicitudCliente solicitudCliente) {
        this.pedidoId = pedidoId;
        this.solicitudCliente = solicitudCliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public SolicitudCliente getSolicitudCliente() {
        return solicitudCliente;
    }
}
