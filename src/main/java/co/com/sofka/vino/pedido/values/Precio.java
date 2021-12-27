package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {

    private final Double precio;

    public Precio(Double precio) {
        this.precio = precio;
    }

    public Precio sumarValor(Double valor){
        return new Precio(this.precio + valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio1 = (Precio) o;
        return Objects.equals(precio, precio1.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio);
    }


    @Override
    public Double value() {
        return precio;
    }
}
