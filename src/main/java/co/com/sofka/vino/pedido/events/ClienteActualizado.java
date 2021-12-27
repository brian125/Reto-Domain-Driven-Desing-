package co.com.sofka.vino.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.pedido.Cliente;

public class ClienteActualizado extends DomainEvent {

    private final String nombre;
    private final String telefono;

    public ClienteActualizado(String nombre, String telefono) {
        super("sofka.pedido.clienteactualizado");
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
