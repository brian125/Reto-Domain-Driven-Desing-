package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.Identity;

public class NormaId extends Identity {

    public NormaId(String valor) {
        super(valor);
    }

    public NormaId() {
    }

    public static NormaId fromString(String valor){
        return new NormaId(valor);
    }
}
