package co.com.sofka.vino.calidad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.fabrica.values.FabricaId;

public class asignarCalidadComando extends Command {

    private final FabricaId fabricaId;
    private final CalidadId calidadId;

    public asignarCalidadComando(FabricaId fabricaId, CalidadId calidadId) {
        this.fabricaId = fabricaId;
        this.calidadId = calidadId;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public CalidadId getCalidadId() {
        return calidadId;
    }
}
