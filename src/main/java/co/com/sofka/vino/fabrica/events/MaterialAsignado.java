package co.com.sofka.vino.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.fabrica.Material;
import co.com.sofka.vino.fabrica.values.MaterialId;
import co.com.sofka.vino.fabrica.values.Uva;

public class MaterialAsignado extends DomainEvent {

    private final MaterialId materialId;
    private final Uva uva;
    private final String levadura;
    private final String azucar;
    private final String otro;

    public MaterialAsignado(MaterialId materialId, Uva uva, String levadura, String azucar, String otro) {
        super("sofka.calidad.materialasignado");
        this.materialId = materialId;
        this.uva = uva;
        this.levadura = levadura;
        this.azucar = azucar;
        this.otro = otro;
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
