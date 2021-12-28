package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PautasNorma implements ValueObject<String> {

    private final String pauta;

    public PautasNorma(String pauta) {
        this.pauta = pauta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PautasNorma that = (PautasNorma) o;
        return Objects.equals(pauta, that.pauta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pauta);
    }


    @Override
    public String value() {
        return pauta;
    }
}
