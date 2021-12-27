package co.com.sofka.vino.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.fabrica.values.NombreFabricante;

public class FabricanteActualizado extends DomainEvent {

    private final NombreFabricante nombreFabricante;

    public FabricanteActualizado(NombreFabricante nombreFabricante) {
        super("sofka.calidad.fabricante actualizado");
        this.nombreFabricante = nombreFabricante;
    }

    public NombreFabricante getNombreFabricante() {
        return nombreFabricante;
    }
}
