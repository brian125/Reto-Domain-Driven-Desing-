package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Properties;

public class ProductoACalidad implements ValueObject<ProductoACalidad.Properties> {

    private final String nombreProducto;
    private final String productoACalidad;

    public ProductoACalidad(String nombreProducto, String productoACalidad) {
        Objects.requireNonNull(nombreProducto, "El nombre del producto enviado a calidad no puede ser vacio");
        Objects.requireNonNull(productoACalidad, "Las caracteristicas del producto enviado A Calidad no puede ser avacio");
        this.nombreProducto = nombreProducto;
        this.productoACalidad = productoACalidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getProductoACalidad() {
        return productoACalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoACalidad that = (ProductoACalidad) o;
        return nombreProducto.equals(that.nombreProducto) && productoACalidad.equals(that.productoACalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreProducto, productoACalidad);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String nombreProducto() {
                return null;
            }

            @Override
            public String productoACalidad() {
                return null;
            }
        };
    }

    public interface Properties {
        String nombreProducto();
        String productoACalidad();
    }

}
