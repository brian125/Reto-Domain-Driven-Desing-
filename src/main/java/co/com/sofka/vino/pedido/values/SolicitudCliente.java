package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SolicitudCliente implements ValueObject<Integer> {

    private final Integer cantidad;

    public SolicitudCliente(Integer cantidad) {
        Objects.requireNonNull(cantidad, "La cantidad de la solicitud no puede estar vacia");
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudCliente that = (SolicitudCliente) o;
        return Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad);
    }


    @Override
    public Integer value() {
        return cantidad;
    }
}
