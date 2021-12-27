package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity{

    public FacturaId(String uuid) {
        super(uuid);
    }

    public FacturaId() {
    }

    public static FacturaId fromString(String valor){
        return new FacturaId(valor);
    }
}
