package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {

    public PedidoId(String valor) {
        super(valor);
    }

    public PedidoId() {
    }

    public static PedidoId fromString(String valor){
        return new PedidoId(valor);
    }
}
