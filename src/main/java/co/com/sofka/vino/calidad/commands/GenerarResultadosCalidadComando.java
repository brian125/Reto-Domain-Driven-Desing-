package co.com.sofka.vino.calidad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.values.CalidadId;

public class GenerarResultadosCalidadComando extends Command {

    private final CalidadId calidadId;
    private final String resultadoCalidad;
    private final String detalle;

    public CalidadId getCalidadId() {
        return calidadId;
    }

    public String getResultadoCalidad() {
        return resultadoCalidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public GenerarResultadosCalidadComando(CalidadId calidadId, String resultadoCalidad, String detalle) {
        this.calidadId = calidadId;
        this.resultadoCalidad = resultadoCalidad;
        this.detalle = detalle;
    }
}
