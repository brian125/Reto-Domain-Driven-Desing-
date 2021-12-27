package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {

    public ClienteId(String uuid) {
        super(uuid);
    }

    public ClienteId() {
    }

    public static ClienteId fromString(String valor){
        return new ClienteId(valor);
    }
}
