package co.com.sofka.vino.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.fabrica.values.FabricanteId;
import co.com.sofka.vino.fabrica.values.MaterialId;

public class AgregarFabricaComando extends Command {

    private final FabricaId fabricaId;
    private final MaterialId materialId;
    private final FabricanteId fabricanteId;
    private final ProductoACalidad productoACalidad;
    private final CalidadId calidadId;

    public AgregarFabricaComando(FabricaId fabricaId, MaterialId materialId, FabricanteId fabricanteId, ProductoACalidad productoACalidad, CalidadId calidadId) {
        this.fabricaId = fabricaId;
        this.materialId = materialId;
        this.fabricanteId = fabricanteId;
        this.productoACalidad = productoACalidad;
        this.calidadId = calidadId;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public MaterialId getMaterialId() {
        return materialId;
    }

    public FabricanteId getFabricanteId() {
        return fabricanteId;
    }

    public ProductoACalidad getProductoACalidad() {
        return productoACalidad;
    }

    public CalidadId getCalidadId() {
        return calidadId;
    }
}