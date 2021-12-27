package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.pedido.values.DatosCliente;
import co.com.sofka.vino.pedido.values.PedidoId;

public class AgregarFacturaComando extends Command {

    private final PedidoId pedidoId;
    private final DatosCliente datosCliente;

    public AgregarFacturaComando(PedidoId pedidoId, DatosCliente datosCliente) {
        this.pedidoId = pedidoId;
        this.datosCliente = datosCliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }
}
