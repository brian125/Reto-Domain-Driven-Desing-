package co.com.sofka.vino.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.fabrica.values.FabricanteId;
import co.com.sofka.vino.fabrica.values.NombreFabricante;

public class FabricanteAsignado extends DomainEvent {

    private final FabricanteId fabricanteId;
    private final NombreFabricante nombreFabricante;
    private final ProductoAprovado productoAprovado;

    public FabricanteAsignado(FabricanteId fabricanteId, NombreFabricante nombreFabricante, ProductoAprovado productoAprovado) {
        super("sofka.calidad.fabricanteasignado");
        this.fabricanteId = fabricanteId;
        this.nombreFabricante = nombreFabricante;
        this.productoAprovado = productoAprovado;
    }

    public FabricanteId getFabricanteId() {
        return fabricanteId;
    }

    public NombreFabricante getNombreFabricante() {
        return nombreFabricante;
    }

    public ProductoAprovado getProductoAprovado() {
        return productoAprovado;
    }
}
