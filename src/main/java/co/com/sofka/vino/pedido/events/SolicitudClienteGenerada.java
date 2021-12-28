package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.pedido.values.PedidoId;
import co.com.sofka.vino.pedido.values.SolicitudCliente;

public class SolicitudClienteGenerada extends DomainEvent {

    private final SolicitudCliente solicitudCliente;

    public SolicitudClienteGenerada(SolicitudCliente solicitudCliente) {
        super("sofka.pedido.solicitudCliente");
        this.solicitudCliente = solicitudCliente;
    }

    public SolicitudCliente getSolicitudCliente() {
        return solicitudCliente;
    }
}
