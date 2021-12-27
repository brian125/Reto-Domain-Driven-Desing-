package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.pedido.Factura;

public class FacturaActualizada extends DomainEvent {

    private final String nombre;
    private final String telefono;

    public FacturaActualizada(String nombre, String telefono) {
        super("sofka.pedido.facturaactualizada");
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
