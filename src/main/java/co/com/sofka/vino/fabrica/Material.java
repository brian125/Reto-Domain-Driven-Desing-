package co.com.sofka.vino.fabrica;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.fabrica.values.MaterialId;
import co.com.sofka.vino.fabrica.values.Uva;

import java.util.List;
import java.util.Objects;

public class Material extends Entity<MaterialId> {

    private Uva uva;
    private String levadura;
    private String azucar;
    private String otro;

    public Material(MaterialId materialId, Uva uva, String levadura, String azucar, String otro) {
        super(materialId);
        Objects.requireNonNull(uva, "La uva para fabricar el vino no puede estar vacio");
        Objects.requireNonNull(levadura, "La levadura para fabricar el vino no puede estar vacio");
        Objects.requireNonNull(azucar, "El azucar para fabricar el vino no puede estar vacio");
        this.uva = uva;
        this.levadura = levadura;
        this.azucar = azucar;
        this.otro = otro;
    }

    public void revisarDisponibilidad(Boolean disponible){
        //TODO: Hacer que el fabricante revise la disponibilidad de los materiales para fabricar el producto
    }

    public Uva uva() {
        return uva;
    }

    public String levadura() {
        return levadura;
    }

    public String azucar() {
        return azucar;
    }

    public String otro() {
        return otro;
    }
}
