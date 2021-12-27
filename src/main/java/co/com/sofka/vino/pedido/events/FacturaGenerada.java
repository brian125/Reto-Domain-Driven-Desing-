package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.pedido.values.DatosCliente;
import co.com.sofka.vino.pedido.values.FacturaId;

public class FacturaGenerada extends DomainEvent {

    private final FacturaId facturaId;
    private final DatosCliente datosCliente;

    public FacturaGenerada(FacturaId facturaId, DatosCliente datosCliente) {
        super("sofka.pedido.facturagenerada");
        this.facturaId = facturaId;
        this.datosCliente = datosCliente;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }
}
