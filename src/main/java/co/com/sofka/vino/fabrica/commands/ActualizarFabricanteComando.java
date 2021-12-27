package co.com.sofka.vino.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.fabrica.values.NombreFabricante;

public class ActualizarFabricanteComando extends Command {

    private final FabricaId fabricaId;
    private final NombreFabricante nombreFabricante;

    public ActualizarFabricanteComando(FabricaId fabricaId, NombreFabricante nombreFabricante) {
        this.fabricaId = fabricaId;
        this.nombreFabricante = nombreFabricante;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public NombreFabricante getNombreFabricante() {
        return nombreFabricante;
    }
}
