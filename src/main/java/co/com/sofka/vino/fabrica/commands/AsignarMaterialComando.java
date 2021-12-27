package co.com.sofka.vino.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.fabrica.values.MaterialId;
import co.com.sofka.vino.fabrica.values.Uva;

public class AsignarMaterialComando extends Command {

    private final FabricaId fabricaId;
    private final MaterialId materialId;
    private final Uva uva;
    private final String levadura;
    private final String azucar;
    private final String otro;

    public AsignarMaterialComando(FabricaId fabricaId, MaterialId materialId, Uva uva, String levadura, String azucar, String otro) {
        this.fabricaId = fabricaId;
        this.materialId = materialId;
        this.uva = uva;
        this.levadura = levadura;
        this.azucar = azucar;
        this.otro = otro;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }

    public MaterialId getMaterialId() {
        return materialId;
    }

    public Uva getUva() {
        return uva;
    }

    public String getLevadura() {
        return levadura;
    }

    public String getAzucar() {
        return azucar;
    }

    public String getOtro() {
        return otro;
    }
}
