package co.com.sofka.vino.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.vino.pedido.events.*;
import co.com.sofka.vino.pedido.values.SolicitudCliente;

import java.util.HashSet;
import java.util.stream.Collectors;

public class PedidoCambio extends EventChange {
    public PedidoCambio(Pedido pedido) {

        apply((ClienteActualizado evento) -> {
            pedido.cliente.actualizarCliente(
                    evento.getNombre(),
                    evento.getTelefono()
            );
        });

        apply((ComentarioReclamoSugerenciaComprobado evento) -> {
            pedido.quejaReclamoSugerencia = evento.getQuejaReclamoSugerencias();
            var quejareclamosugerencia = pedido.quejaReclamoSugerencia.stream()
                    .filter(quejaReclamoSugerencia -> quejaReclamoSugerencia.getComentario().value().tipoComentario() == true)
                    .collect(Collectors.toSet())
                    .size();

            System.out.println("Los comentarios comprobados son: " + quejareclamosugerencia);

        });

        apply((FabricaAsociada evento) -> {
            pedido.fabricaId = evento.getFabricaId();
        });

        apply((FacturaActualizada evento) -> {
            pedido.factura.actualizarFactura(
                    evento.getNombre(),
                    evento.getTelefono()
            );
        });

        apply((FacturaGenerada evento) -> {
            pedido.factura = new Factura(
              evento.getFacturaId(),
              evento.getDatosCliente()
            );
        });

        apply((PedidoAgregado evento) -> {
            pedido.factura = evento.getFactura();
            pedido.cliente = evento.getCliente();
            pedido.quejaReclamoSugerencia = new HashSet<>();
            pedido.fabricaId = evento.getFabricaId();
        });

        apply((ProductoAprovadoAgregado evento) -> {
            pedido.factura.agregarProducto(
                    evento.getNombre(),
                    evento.getPrecio()
            );
        });

        apply ((QuejaReclamoSugerenciaAgregado evento) -> {
            pedido.quejaReclamoSugerencia.add(new QuejaReclamoSugerencia(
                    evento.getQuejaReclamoSugerenciaId(),
                    evento.getComentario()
            ));
        });

        apply((SolicitudClienteGenerada evento) -> {
            pedido.cliente.generarSolicitud(evento.getSolicitudCliente());
        });

    }
}
