package co.com.sofka.vino.calidad.commands;

import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.PautasNorma;

public class RevisarCumplimientoPautasNorma {

    private final CalidadId calidadId;
    private final PautasNorma pautasNorma;

    public RevisarCumplimientoPautasNorma(CalidadId calidadId, PautasNorma pautasNorma) {
        this.calidadId = calidadId;
        this.pautasNorma = pautasNorma;
    }

    public CalidadId getCalidadId() {
        return calidadId;
    }

    public PautasNorma getPautasNorma() {
        return pautasNorma;
    }
}
