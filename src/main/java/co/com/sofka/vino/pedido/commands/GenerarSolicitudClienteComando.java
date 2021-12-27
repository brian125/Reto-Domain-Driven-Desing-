package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;

public class GenerarSolicitudClienteComando extends Command {

    private final Integer cantidad;

    public GenerarSolicitudClienteComando(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
