package co.com.sofka.vino.fabrica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreFabricante implements ValueObject<String> {

    private final String nombreFabricante;

    public NombreFabricante(String nombreFabricante) {
        Objects.requireNonNull(nombreFabricante, "El nombre del fabricante no puede estar vacio");
        this.nombreFabricante = nombreFabricante;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreFabricante that = (NombreFabricante) o;
        return Objects.equals(nombreFabricante, that.nombreFabricante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFabricante);
    }


    @Override
    public String value() {
        return nombreFabricante;
    }
}
