package co.com.sofka.vino.calidad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.Calidad;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.NombreNorma;
import co.com.sofka.vino.calidad.values.PautasNorma;

public class GenerarNormaComando extends Command {

    private final CalidadId calidadId;
    private final NombreNorma nombreNorma;
    private final PautasNorma pautasNorma;

    public CalidadId getCalidadId() {
        return calidadId;
    }

    public NombreNorma getNombreNorma() {
        return nombreNorma;
    }

    public PautasNorma getPautasNorma() {
        return pautasNorma;
    }

    public GenerarNormaComando(CalidadId calidadId, NombreNorma nombreNorma, PautasNorma pautasNorma) {
        this.calidadId = calidadId;
        this.nombreNorma = nombreNorma;
        this.pautasNorma = pautasNorma;
    }
}
