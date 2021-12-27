package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.ProductoAprovado;

public class ProductoAprovadoAgregado extends DomainEvent {


    private final String nombre;
    private final Double precio;

    public ProductoAprovadoAgregado(String nombre, Double precio) {
        super("sofka.pedido.productoagregado");
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
}
