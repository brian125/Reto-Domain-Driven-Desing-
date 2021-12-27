package co.com.sofka.vino.fabrica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Uva implements ValueObject<String> {

    private String tipoUva;

    public Uva(String tipoUva) {
        Objects.requireNonNull(tipoUva, "El tipo de la uva para fabricar el vino no puede ir vacio");
        this.tipoUva = tipoUva;
    }

    public String getTipoUva() {
        return tipoUva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uva uva = (Uva) o;
        return Objects.equals(tipoUva, uva.tipoUva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoUva);
    }

    @Override
    public String value() {
        return tipoUva;
    }
}
