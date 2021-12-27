package co.com.sofka.vino.calidad.commands;

import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.ProductoId;

public class CambiarNombreEmpleadoCalidadComando {

    private final CalidadId calidadId;
    private final ProductoId productoId;
    private final String nombreEmpleadoCalidad;

    public CalidadId getCalidadId() {
        return calidadId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public String getNombreEmpleadoCalidad() {
        return nombreEmpleadoCalidad;
    }

    public CambiarNombreEmpleadoCalidadComando(CalidadId calidadId, ProductoId productoId, String nombreEmpleadoCalidad) {
        this.calidadId = calidadId;
        this.productoId = productoId;
        this.nombreEmpleadoCalidad = nombreEmpleadoCalidad;
    }
}
