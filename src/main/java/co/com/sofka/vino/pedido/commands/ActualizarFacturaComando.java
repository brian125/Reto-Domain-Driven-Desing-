package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.pedido.values.PedidoId;

public class ActualizarFacturaComando extends Command {

    private final PedidoId pedidoId;
    private final String nombre;
    private final String telefono;

    public ActualizarFacturaComando(PedidoId pedidoId, String nombre, String telefono) {
        this.pedidoId = pedidoId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
