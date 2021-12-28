package co.com.sofka.vino.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.pedido.values.ClienteId;
import co.com.sofka.vino.pedido.values.DatosCliente;
import co.com.sofka.vino.pedido.values.SolicitudCliente;

import java.util.Objects;

public class Cliente extends Entity <ClienteId> {

    private SolicitudCliente solicitudCliente;
    private DatosCliente datosCliente;

    public Cliente(ClienteId clienteId, SolicitudCliente solicitudCliente, DatosCliente datosCliente) {
        super(clienteId);
        this.solicitudCliente = solicitudCliente;
        this.datosCliente = datosCliente;
    }

    public void actualizarCliente(String nombre, String telefono){
        Objects.requireNonNull(nombre, "El nombre del cliente no puede ir vacio");
        Objects.requireNonNull(telefono, "El telefono del cliemte no puede ir vacio");
        this.datosCliente = new DatosCliente(nombre,telefono);
    }

    public void generarSolicitud(SolicitudCliente solicitudCliente){
        Objects.requireNonNull(solicitudCliente, "La solicitud del cliente no puede ir vacia");
        this.solicitudCliente = new SolicitudCliente(solicitudCliente.value());
    }

    public SolicitudCliente solicitudCliente() {
        return solicitudCliente;
    }

    public DatosCliente datosCliente() {
        return datosCliente;
    }
}
