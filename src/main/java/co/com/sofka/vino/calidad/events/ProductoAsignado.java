package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.NombreProducto;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.calidad.values.ProductoId;

public class ProductoAsignado extends DomainEvent {

    private final ProductoId productoId;
    private final NombreProducto nombreProducto;
    private final ProductoACalidad productoACalidad;

    public ProductoAsignado(ProductoId productoId, NombreProducto nombreProducto, ProductoACalidad productoACalidad) {
        super("sofka.calidad.productoasignado");
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.productoACalidad = productoACalidad;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }

    public ProductoACalidad getProductoACalidad() {
        return productoACalidad;
    }
}
