package co.com.sofka.vino.calidad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.vino.calidad.EmpleadoCalidad;
import co.com.sofka.vino.calidad.values.*;

public class AsignarEmpleadoCalidadComando extends Command {

    private final CalidadId calidadId;
    private final EmpleadoCalidadId empleadoCalidadId;
    private final NombreEmpleadoCalidad nombreEmpleadoCalidad;
    private final ResultadoCalidad resultadoCalidad;
    private final ProductoAprovado productoAprovado;

    public CalidadId getCalidadId() {
        return calidadId;
    }

    public EmpleadoCalidadId getEmpleadoCalidadId() {
        return empleadoCalidadId;
    }

    public NombreEmpleadoCalidad getNombreEmpleadoCalidad() {
        return nombreEmpleadoCalidad;
    }

    public ResultadoCalidad getResultadoCalidad() {
        return resultadoCalidad;
    }

    public ProductoAprovado getProductoAprovado() {
        return productoAprovado;
    }

    public AsignarEmpleadoCalidadComando(CalidadId calidadId, EmpleadoCalidadId empleadoCalidadId, NombreEmpleadoCalidad nombreEmpleadoCalidad, ResultadoCalidad resultadoCalidad, ProductoAprovado productoAprovado) {
        this.calidadId = calidadId;
        this.empleadoCalidadId = empleadoCalidadId;
        this.nombreEmpleadoCalidad = nombreEmpleadoCalidad;
        this.resultadoCalidad = resultadoCalidad;
        this.productoAprovado = productoAprovado;
    }
}
