package co.com.sofka.vino.pedido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.pedido.values.ClienteId;
import co.com.sofka.vino.pedido.values.FacturaId;
import co.com.sofka.vino.pedido.values.PedidoId;
import co.com.sofka.vino.pedido.values.QuejaReclamoSugerenciaId;

import java.util.Set;

public class GenerarPeridoComando extends Command {

    private final PedidoId pedidoId;
    private final FacturaId facturaId;
    private final ClienteId clienteId;
    private final Set<QuejaReclamoSugerenciaId> quejaReclamoSugerenciaId;
    private final FabricaId fabricaId;

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Set<QuejaReclamoSugerenciaId> getQuejaReclamoSugerenciaId() {
        return quejaReclamoSugerenciaId;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public GenerarPeridoComando(PedidoId pedidoId, FacturaId facturaId, ClienteId clienteId, Set<QuejaReclamoSugerenciaId> quejaReclamoSugerenciaId, FabricaId fabricaId) {
        this.pedidoId = pedidoId;
        this.facturaId = facturaId;
        this.clienteId = clienteId;
        this.quejaReclamoSugerenciaId = quejaReclamoSugerenciaId;
        this.fabricaId = fabricaId;
    }

}
