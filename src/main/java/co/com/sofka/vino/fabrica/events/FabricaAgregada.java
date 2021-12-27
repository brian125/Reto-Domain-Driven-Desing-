package co.com.sofka.vino.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.fabrica.Fabricante;
import co.com.sofka.vino.fabrica.Material;
import co.com.sofka.vino.fabrica.values.FabricaId;

public class FabricaAgregada extends DomainEvent {

    private final FabricaId fabricaId;
    private final Material material;
    private final Fabricante fabricante;
    private final ProductoACalidad productoACalidad;
    private final CalidadId calidadId;

    public FabricaAgregada(FabricaId fabricaId, Material material, Fabricante fabricante, ProductoACalidad productoACalidad, CalidadId calidadId) {
        super("sofka.calidad.fabricaagregada");
        this.fabricaId = fabricaId;
        this.material = material;
        this.fabricante = fabricante;
        this.productoACalidad = productoACalidad;
        this.calidadId = calidadId;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public Material getMaterial() {
        return material;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public ProductoACalidad getProductoACalidad() {
        return productoACalidad;
    }

    public CalidadId getCalidadId() {
        return calidadId;
    }
}
