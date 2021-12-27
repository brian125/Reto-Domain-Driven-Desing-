package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.pedido.Cliente;
import co.com.sofka.vino.pedido.Factura;
import co.com.sofka.vino.pedido.QuejaReclamoSugerencia;
import co.com.sofka.vino.pedido.values.PedidoId;

import java.util.Set;

public class PedidoAgregado extends DomainEvent {

    private final PedidoId pedidoId;
    private final Set<QuejaReclamoSugerencia> quejaReclamoSugerencia;
    private final Factura factura;
    private final  Cliente cliente;
    private final FabricaId fabricaId;

    public PedidoAgregado(PedidoId pedidoId, Factura factura, Cliente cliente, Set<QuejaReclamoSugerencia> quejaReclamoSugerencia,FabricaId fabricaId) {
        super("sofka.pedido.pedidoagregado");
        this.pedidoId = pedidoId;
        this.factura = factura;
        this.cliente = cliente;
        this.quejaReclamoSugerencia = quejaReclamoSugerencia;
        this.fabricaId = fabricaId;
    }

    public Set<QuejaReclamoSugerencia> getQuejaReclamoSugerencia() {
        return quejaReclamoSugerencia;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Factura getFactura() {
        return factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }
}
