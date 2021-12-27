package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreProducto implements ValueObject<String> {

    private final String nombreProducto;

    public NombreProducto(String nombreProducto) {
        Objects.requireNonNull(nombreProducto, "El nombre del producto enviado a calidad no puede ser vacio");
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreProducto that = (NombreProducto) o;
        return Objects.equals(nombreProducto, that.nombreProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreProducto);
    }

    @Override
    public String value() {
        return nombreProducto;
    }
}
