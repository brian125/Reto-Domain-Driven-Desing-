package co.com.sofka.vino.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.ProductoAprovado;

public class PedidoRecibido extends DomainEvent {

    private final ProductoAprovado productoAprovado;

    public PedidoRecibido(ProductoAprovado productoAprovado) {
        super("sofka.calidad.pedidorecibido");
        this.productoAprovado = productoAprovado;
    }

    public ProductoAprovado getProductoAprovado() {
        return productoAprovado;
    }
}