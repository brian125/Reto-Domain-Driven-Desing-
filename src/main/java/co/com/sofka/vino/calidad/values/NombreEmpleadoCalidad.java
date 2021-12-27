package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreEmpleadoCalidad implements ValueObject<String> {

    private final String nombreEmpleadoCalidad;

    public NombreEmpleadoCalidad(String nombreEmpleadoCalidad) {
        Objects.requireNonNull(nombreEmpleadoCalidad, "Nombre del empleado de calidad no puede ser nulo");
        this.nombreEmpleadoCalidad = nombreEmpleadoCalidad;
    }

    public String getNombreEmpleadoCalidad() {
        return nombreEmpleadoCalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreEmpleadoCalidad that = (NombreEmpleadoCalidad) o;
        return Objects.equals(nombreEmpleadoCalidad, that.nombreEmpleadoCalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEmpleadoCalidad);
    }

    @Override
    public String value() {
        return nombreEmpleadoCalidad;
    }
}
