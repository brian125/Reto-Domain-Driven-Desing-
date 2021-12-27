package co.com.sofka.vino.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.fabrica.values.FabricanteId;
import co.com.sofka.vino.fabrica.values.NombreFabricante;

public class AsignarFabricanteComando extends Command {

    private final FabricaId fabricaId;
    private final FabricanteId fabricanteId;
    private final NombreFabricante nombreFabricante;
    private final ProductoAprovado productoAprovado;

    public AsignarFabricanteComando(FabricaId fabricaId, FabricanteId fabricanteId, NombreFabricante nombreFabricante, ProductoAprovado productoAprovado) {
        this.fabricaId = fabricaId;
        this.fabricanteId = fabricanteId;
        this.nombreFabricante = nombreFabricante;
        this.productoAprovado = productoAprovado;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
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
