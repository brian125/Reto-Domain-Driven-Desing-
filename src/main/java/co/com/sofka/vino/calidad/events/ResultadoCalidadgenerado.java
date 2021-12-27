package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ResultadoCalidadgenerado extends DomainEvent {

    private final String resultadoCalidad;
    private final String detalle;

    public ResultadoCalidadgenerado(String resultadoCalidad, String detalle) {
        super("sofka.calidad.resultadocalidadgenerado");
        this.resultadoCalidad = resultadoCalidad;
        this.detalle = detalle;
    }

    public String getResultadoCalidad() {
        return resultadoCalidad;
    }

    public String getDetalle() {
        return detalle;
    }
}
