package co.com.sofka.vino.fabrica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.events.*;
import co.com.sofka.vino.fabrica.values.*;

import java.util.List;
import java.util.Objects;

public class Fabrica extends AggregateEvent<FabricaId> {

    protected Material material;
    protected Fabricante fabricante;
    protected ProductoACalidad productoACalidad;
    protected CalidadId calidadId;

    public Fabrica(FabricaId fabricaId, Material material, Fabricante fabricante, ProductoACalidad productoACalidad, CalidadId calidadId) {
        super(fabricaId);
        subscribe(new FabricaCambio(this));
        appendChange(new FabricaAgregada(fabricaId,material,fabricante, productoACalidad, calidadId));
    }

    public Fabrica(FabricaId fabricaId) {
        super(fabricaId);
        subscribe(new FabricaCambio(this));
    }

    public static Fabrica from(FabricaId fabricaId, List<DomainEvent> events){
        var fabrica = new Fabrica(fabricaId);
        events.forEach(fabrica::applyEvent);
        return fabrica;
    }

    public void asignarFabricante(FabricanteId fabricanteId, NombreFabricante nombreFabricante, ProductoAprovado productoAprovado){
        Objects.requireNonNull(fabricanteId, "La identificacion del fabricante no puede ir vacia");
        Objects.requireNonNull(nombreFabricante, "El nombre del fabricante no puede ir vacio");
        Objects.requireNonNull(productoAprovado, "El producto aprovado no puede ir vacio");
        appendChange(new FabricanteAsignado(fabricanteId,nombreFabricante,productoAprovado));
    }

    public void actualizarFabricante(NombreFabricante nombreFabricante){
        Objects.requireNonNull(nombreFabricante, "El nombre del fabricante no puede ir vacio");
        appendChange(new FabricanteActualizado(nombreFabricante));
    }

    public void asigarMaterial(MaterialId materialId, Uva uva, String levadura, String azucar, String otro){
        Objects.requireNonNull(materialId, "el material para fabricar el vino no puede ir vacio");
        Objects.requireNonNull(uva, "La uva para fabricar el vino no puede ir vacio");
        Objects.requireNonNull(levadura, "La levadura para fabricar el vino no puede ir vacio");
        Objects.requireNonNull(azucar, "El azucar para fabricar el vino no puede ir vacio");
        appendChange(new MaterialAsignado(materialId, uva, levadura, azucar, otro));
    }

    public void recibirPedido(){
        appendChange(new PedidoRecibido(this.fabricante().productoAprovado()));
    }

    public Material material() {
        return material;
    }

    public Fabricante fabricante() {
        return fabricante;
    }

    public ProductoACalidad productoACalidad() {
        return productoACalidad;
    }

    public CalidadId calidadId() {
        return calidadId;
    }
}
