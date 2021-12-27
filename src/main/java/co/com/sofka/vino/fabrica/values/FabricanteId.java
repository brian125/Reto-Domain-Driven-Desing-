package co.com.sofka.vino.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class FabricanteId extends Identity {

    public FabricanteId(String valor) {
        super(valor);
    }

    public FabricanteId() {
    }

    public static FabricanteId fromString(String valor){
        return new FabricanteId(valor);
    }
}
