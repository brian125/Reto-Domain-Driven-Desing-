package co.com.sofka.vino.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.fabrica.Fabrica;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.pedido.events.*;
import co.com.sofka.vino.pedido.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pedido extends AggregateEvent<PedidoId> {

    protected Factura factura;
    protected Cliente cliente;
    protected Set<QuejaReclamoSugerencia> quejaReclamoSugerencia;
    protected FabricaId fabricaId;

    public Pedido(PedidoId pedidoId, Factura factura, Cliente cliente, QuejaReclamoSugerencia quejaReclamoSugerencia,FabricaId fabricaId) {
        super(pedidoId);
        subscribe(new PedidoCambio(this));
        appendChange(new PedidoAgregado(pedidoId,factura,cliente,quejaReclamoSugerencia,fabricaId));
    }

    public Pedido(PedidoId pedidoId) {
        super(pedidoId);
        subscribe(new PedidoCambio(this));
    }
    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }


    public void generarFactura(FacturaId facturaId, DatosCliente datosCliente) {
        Objects.requireNonNull(facturaId, "El id de la factura no puede ir vacio");
        Objects.requireNonNull(datosCliente, "Los datos del cliente a facturar no pueden estar vacios");
        appendChange(new FacturaGenerada(facturaId, datosCliente));
    }

    public void agregarQuejaReclamoSugerencia(QuejaReclamoSugerenciaId quejaReclamoSugerenciaId,Comentario comentario){
        Objects.requireNonNull(quejaReclamoSugerenciaId, "El id de la queja reclamo o sugerencia no puede ir vacio ");
        Objects.requireNonNull(comentario, "El comentario de la queja reclamo o sugerencia no puede ir vacio");
        appendChange(new QuejaReclamoSugerenciaAgregado(quejaReclamoSugerenciaId,comentario));
    }

    public void asignarFabrica(FabricaId fabricaId){
        Objects.requireNonNull(fabricaId, "El id de la fabrica que recibe el pedido no puede ir vacia");
        appendChange(new FabricaAsociada(fabricaId));
    }

    public void agregarProductoAprovado(String nombre, Double precio){
        Objects.requireNonNull(nombre, "El nombre del producto a facturar no puede ir vacio");
        Objects.requireNonNull(precio, "el precio del producto a facturar no puede ir vacio");
        appendChange(new ProductoAprovadoAgregado(nombre, precio));
    }

    public void actualizarFactura(String nombre, String telefono){
        Objects.requireNonNull(nombre, "El nombre del cliente facturado no puede ir vacio");
        Objects.requireNonNull(telefono, "El telefono del cliente facturado no puede ir vacio");
        appendChange(new FacturaActualizada(nombre, telefono));
    }

    public void comprobarComentarioQuejaReclamoSugerencia(Set<QuejaReclamoSugerencia> quejaReclamoSugerencia){
        Objects.requireNonNull(quejaReclamoSugerencia, "La queja reclamo o sugerencia a comprobar no puede ir vacio");
        appendChange(new ComentarioReclamoSugerenciaComprobado(quejaReclamoSugerencia));
    }

    public void actualizarCliente (String nombre, String telefono){
        Objects.requireNonNull(nombre, "El nombre del cliente que hace el pedido no puede ir vacio");
        Objects.requireNonNull(telefono, "El telefono del cliente que hace el pedido no puede ir vacio");
        appendChange(new ClienteActualizado(nombre, telefono));
    }

    public void generarSolicutudCliente(SolicitudCliente solicitudCliente){
        Objects.requireNonNull(solicitudCliente, "La  cantidad de la solicitud del cliente no puede ir vacia");
        appendChange(new SolicitudClienteGenerada(solicitudCliente));
    }

    public Set<QuejaReclamoSugerencia> quejaReclamoSugerencia() {
        return quejaReclamoSugerencia;
    }

    public Factura factura() {
        return factura;
    }

    public Cliente cliente() {
        return cliente;
    }

    public FabricaId fabricaId() {
        return fabricaId;
    }
}
