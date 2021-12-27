package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.fabrica.values.FabricaId;

public class FabricaAsociada extends DomainEvent {

    private final FabricaId fabricaId;

    public FabricaAsociada(FabricaId fabricaId) {
        super("sofka.pedido.fabricaasociada");
        this.fabricaId = fabricaId;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }
}
