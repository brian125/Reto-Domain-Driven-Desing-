package co.com.sofka.vino.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class MaterialId extends Identity {

    public MaterialId(String uuid) {
        super(uuid);
    }

    public MaterialId() {
    }

    public static MaterialId fromString(String valor){
        return new MaterialId(valor);
    }
}
