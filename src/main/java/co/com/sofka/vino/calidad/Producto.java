package co.com.sofka.vino.calidad;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.calidad.values.NombreProducto;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.calidad.values.ProductoId;

import java.util.Objects;

public class Producto extends Entity<ProductoId> {

    private NombreProducto nombreProducto;
    private ProductoACalidad productoACalidad;

    public Producto (ProductoId productoId, NombreProducto nombreProducto, ProductoACalidad productoACalidad){
        super(productoId);
        this.nombreProducto = nombreProducto;
        this.productoACalidad = productoACalidad;
    }

    public void asignarProducto(String nombreProducto, String productoACalidad){
        Objects.requireNonNull(nombreProducto, "Nombre del producto no puede ser vacio");
        Objects.requireNonNull(productoACalidad, "El producto enviado a calidad no pueser ser vacio");
        this.productoACalidad = new ProductoACalidad(nombreProducto, productoACalidad);
    }

    public void cambiarNombreProducto(NombreProducto nombreProducto) {
        Objects.requireNonNull(nombreProducto, "El nombre del producto no puede ir vacio");
        this.nombreProducto = nombreProducto;
    }

    public NombreProducto nombreProducto() {
        return nombreProducto;
    }

    public ProductoACalidad productoACalidad() {
        return productoACalidad;
    }
}
