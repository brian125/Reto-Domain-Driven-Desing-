package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreNorma implements ValueObject<String> {

    private final String nombreNorma;

    public NombreNorma(String nombreNorma) {
        Objects.requireNonNull(nombreNorma, "El nombre de la norma no puede ir vacio");
        this.nombreNorma = nombreNorma;
    }

    public String getNombreNorma() {
        return nombreNorma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreNorma that = (NombreNorma) o;
        return Objects.equals(nombreNorma, that.nombreNorma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreNorma);
    }


    @Override
    public String value() {
        return nombreNorma;
    }
}
