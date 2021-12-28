package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.NombreNorma;
import co.com.sofka.vino.calidad.values.PautasNorma;

public class NormaGenerada extends DomainEvent {

    private final NombreNorma nombreNorma;
    private final PautasNorma pautasNorma;

    public NormaGenerada(NombreNorma nombreNorma, PautasNorma pautasNorma) {
        super("sofka.calidad.normagenerada");
        this.nombreNorma = nombreNorma;
        this.pautasNorma = pautasNorma;
    }

    public NombreNorma getNombreNorma() {
        return nombreNorma;
    }

    public PautasNorma getPautasNorma() {
        return pautasNorma;
    }
}
