package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductoAprovado implements ValueObject<ProductoAprovado.Properties> {

    private final String nombreProductoAprovado;
    private final Double precio;

    public ProductoAprovado(String nombreProductoAprovado, Double precio) {
        Objects.requireNonNull(nombreProductoAprovado, "El nombre del producto ya aprovado no puede estar vacio");
        Objects.requireNonNull(precio, "El precio del producto ya aprovado no puede estar vacio");
        this.nombreProductoAprovado = nombreProductoAprovado;
        this.precio = precio;
    }

    public String getNombreProductoAprovado() {
        return nombreProductoAprovado;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoAprovado that = (ProductoAprovado) o;
        return Objects.equals(nombreProductoAprovado, that.nombreProductoAprovado) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreProductoAprovado, precio);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String nombreProductoAprovado() {
                return null;
            }

            @Override
            public Double precio() {
                return null;
            }
        };
    }

    public interface Properties {
        String nombreProductoAprovado();
        Double precio();
    }
}
