package co.com.sofka.vino.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.pedido.values.DatosCliente;
import co.com.sofka.vino.pedido.values.FacturaId;
import co.com.sofka.vino.pedido.values.Precio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Factura extends Entity<FacturaId> {

    private Set<ProductoAprovado> productos;
    private DatosCliente datosCliente;
    private Precio precio;

    public Factura(FacturaId facturaId, DatosCliente datosCliente) {
        super(facturaId);
        Objects.requireNonNull(datosCliente, "Los datos del cliente no pueden estar vacios");
        this.datosCliente = datosCliente;
        this.productos = new HashSet<>();
    }

    public void calcularPrecio(){
        productos.stream()
                .forEach(productos -> this.precio = this.precio.sumarValor(productos.getPrecio()));
    }

    public void agregarProducto(String nombre, Double precio){
        Objects.requireNonNull(nombre, "El nombre del producto a facturar no puede estar vacio");
        Objects.requireNonNull(precio, "El precio del producto no puede ser vacio");
        productos.add(new ProductoAprovado(nombre,precio));
    }

    public void actualizarFactura(String nombre, String telefono){
        Objects.requireNonNull(nombre, "El nombre del cliente que esta en la factura a actualizar no puede estar vacio");
        Objects.requireNonNull(telefono, "El telefono del cliente que esta en la factura a actualizar no puede estar vacio");
        this.datosCliente = new DatosCliente(nombre,telefono);
    }

    public Set<ProductoAprovado> getProductos() {
        return productos;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public Precio getPrecio() {
        return precio;
    }
}
