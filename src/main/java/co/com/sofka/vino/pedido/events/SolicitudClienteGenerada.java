package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.pedido.values.SolicitudCliente;

public class SolicitudClienteGenerada extends DomainEvent {

    private final Integer cantidad;

    public SolicitudClienteGenerada(Integer cantidad) {
        super("sofka.pedido.solicitudCliente");
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
