package co.com.sofka.vino.calidad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.Calidad;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.NombreProducto;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.calidad.values.ProductoId;

public class AsignarProductoComando extends Command {

    private final CalidadId calidadId;
    private final ProductoId productoId;
    private final NombreProducto nombreProducto;
    private final ProductoACalidad productoACalidad;

    public CalidadId getCalidadId() {
        return calidadId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public ProductoACalidad getProductoACalidad() {
        return productoACalidad;
    }

    public AsignarProductoComando(CalidadId calidadId, ProductoId productoId,NombreProducto nombreProducto ,ProductoACalidad productoACalidad) {
        this.calidadId = calidadId;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.productoACalidad = productoACalidad;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }
}
