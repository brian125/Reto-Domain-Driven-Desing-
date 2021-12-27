package co.com.sofka.vino.fabrica;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.values.FabricanteId;
import co.com.sofka.vino.fabrica.values.NombreFabricante;

import java.util.Objects;

public class Fabricante extends Entity<FabricanteId> {

    private NombreFabricante nombreFabricante;
    private ProductoAprovado productoAprovado;

    public Fabricante(FabricanteId fabricanteId, NombreFabricante nombreFabricante, ProductoAprovado productoAprovado) {
        super(fabricanteId);
        Objects.requireNonNull(fabricanteId, "El id del fabricante no puede ir vacio");
        Objects.requireNonNull(nombreFabricante, "El nombre del fabricante no puede ir vacio");
        Objects.requireNonNull(productoAprovado, "El productoAprovado no puede ir vacio");
        this.nombreFabricante = nombreFabricante;
        this.productoAprovado = productoAprovado;
    }

    public void realizarProductoACalidad(String nombreProductoAprovado, Double precio){
        Objects.requireNonNull(nombreProductoAprovado, "El nombre del producto que ya fue aprovado no puede ir vacio");
        Objects.requireNonNull(precio, "El precio del producto ya aprovado no puede ir vacio");
        this.productoAprovado = new ProductoAprovado(nombreProductoAprovado, precio);
    }

    public void actualizarNombreFabricante(NombreFabricante nombreFabricante){
        this.nombreFabricante = nombreFabricante;
    }

    public NombreFabricante nombreFabricante() {
        return nombreFabricante;
    }

    public ProductoAprovado productoAprovado() {
        return productoAprovado;
    }
}
