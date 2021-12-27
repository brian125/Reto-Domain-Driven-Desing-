package co.com.sofka.vino.fabrica;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.vino.fabrica.events.*;

public class FabricaCambio extends EventChange {

    public FabricaCambio(Fabrica fabrica) {

            apply((FabricaAgregada evento) -> {
                fabrica.material = evento.getMaterial();
                fabrica.fabricante = evento.getFabricante();
                fabrica.productoACalidad = evento.getProductoACalidad();
                fabrica.calidadId = evento.getCalidadId();
            });

            apply((FabricanteActualizado evento) -> {
                fabrica.fabricante.actualizarNombreFabricante(evento.getNombreFabricante());
            });

            apply((FabricanteAsignado evento) -> {
                fabrica.fabricante = new Fabricante(
                        evento.getFabricanteId(),
                        evento.getNombreFabricante(),
                        evento.getProductoAprovado()
                );
            });

            apply((MaterialAsignado evento) -> {
                fabrica.material = new Material(
                  evento.getMaterialId(),
                  evento.getUva(),
                  evento.getLevadura(),
                  evento.getAzucar(),
                  evento.getOtro()
                );
            });

            apply((PedidoRecibido evento) -> {
                System.out.println("El pedido del producto " + evento.getProductoAprovado() + "ha sido recibido");
            });

    }
}
