package co.com.sofka.vino.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.values.FabricaId;

public class RecibirPedidoComando extends Command {

    private final FabricaId fabricaId;
    private final ProductoAprovado productoAprovado;

    public RecibirPedidoComando(FabricaId fabricaId, ProductoAprovado productoAprovado) {
        this.fabricaId = fabricaId;
        this.productoAprovado = productoAprovado;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public ProductoAprovado getProductoAprovado() {
        return productoAprovado;
    }
}
