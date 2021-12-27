package co.com.sofka.vino.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class FabricaId extends Identity {

    public FabricaId(String valor) {
        super(valor);
    }

    public FabricaId() {
    }

    public static FabricaId fromString(String valor){
        return new FabricaId(valor);
    }
}
