package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.EmpleadoCalidad;
import co.com.sofka.vino.calidad.Norma;
import co.com.sofka.vino.calidad.Producto;
import co.com.sofka.vino.calidad.values.CalidadId;

public class CalidadCreado extends DomainEvent {

    private final CalidadId calidadId;
    private final Producto producto;
    private final EmpleadoCalidad empleadoCalidad;
    private final Norma norma;

    public CalidadCreado(CalidadId calidadId,Producto producto, EmpleadoCalidad empleadoCalidad, Norma norma) {
        super("sofka.calidad.calidadcreado");
        this.calidadId = calidadId;
        this.producto = producto;
        this.empleadoCalidad = empleadoCalidad;
        this.norma = norma;
    }

    public Producto getProducto() {
        return producto;
    }
    public CalidadId getCalidadId() {
        return calidadId;
    }

    public EmpleadoCalidad getEmpleadoCalidad() {
        return empleadoCalidad;
    }

    public Norma getNorma() {
        return norma;
    }
}
