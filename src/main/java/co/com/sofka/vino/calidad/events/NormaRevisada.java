package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.PautasNorma;

public class NormaRevisada extends DomainEvent {

    private final PautasNorma pautasNorma;

    public NormaRevisada(PautasNorma pautasNorma) {
        super("sofka.calidad.normarevisada");
        this.pautasNorma = pautasNorma;
    }

    public PautasNorma getPautasNorma() {
        return pautasNorma;
    }
}
