package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ResultadoCalidad implements ValueObject<ResultadoCalidad.Properties> {

    private final String resultadoCalidad;
    private final String detalle;

    public ResultadoCalidad(String resultadoCalidad, String detalle) {
        Objects.requireNonNull(resultadoCalidad);
        Objects.requireNonNull(detalle, "El detalle del resultado de las pruebas de calidad no puede estar vacio");
        this.resultadoCalidad = resultadoCalidad;
        this.detalle = detalle;
    }

    public String getResultadoCalidad() {
        return resultadoCalidad;
    }

    public String getDetalle() {
        return detalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoCalidad that = (ResultadoCalidad) o;
        return Objects.equals(resultadoCalidad, that.resultadoCalidad) && Objects.equals(detalle, that.detalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultadoCalidad, detalle);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String resultadoCalidad() {
                return null;
            }

            @Override
            public String detalle() {
                return null;
            }
        };
    }

    public interface Properties {
        String resultadoCalidad();
        String detalle();
    }
}
