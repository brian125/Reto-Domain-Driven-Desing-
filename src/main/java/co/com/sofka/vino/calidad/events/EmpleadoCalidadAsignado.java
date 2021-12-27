package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.EmpleadoCalidad;
import co.com.sofka.vino.calidad.values.EmpleadoCalidadId;
import co.com.sofka.vino.calidad.values.NombreEmpleadoCalidad;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.calidad.values.ResultadoCalidad;

import java.util.UUID;

public class EmpleadoCalidadAsignado extends DomainEvent {

    private final EmpleadoCalidadId empleadoCalidadId;
    private final NombreEmpleadoCalidad nombreEmpleadoCalidad;
    private final ProductoAprovado productoAprovado;
    private final ResultadoCalidad resultadoCalidad;

    public EmpleadoCalidadId empleadoCalidadId(){
        return empleadoCalidadId;
    }

    public EmpleadoCalidadAsignado(EmpleadoCalidadId empleadoCalidadId, NombreEmpleadoCalidad nombreEmpleadoCalidad, ProductoAprovado productoAprovado, ResultadoCalidad resultadoCalidad) {
        super("sofka.calidad.empleadocalidadasignado");
        this.empleadoCalidadId = empleadoCalidadId;
        this.nombreEmpleadoCalidad = nombreEmpleadoCalidad;
        this.productoAprovado = productoAprovado;
        this.resultadoCalidad = resultadoCalidad;
    }

    public EmpleadoCalidadId getEmpleadoCalidadId() {
        return empleadoCalidadId;
    }

    public NombreEmpleadoCalidad getNombreEmpleadoCalidad() {
        return nombreEmpleadoCalidad;
    }

    public ProductoAprovado getProductoAprovado() {
        return productoAprovado;
    }

    public ResultadoCalidad getResultadoCalidad() {
        return resultadoCalidad;
    }
}
