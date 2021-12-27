package co.com.sofka.vino.calidad;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.events.*;
import co.com.sofka.vino.calidad.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Calidad extends AggregateEvent<CalidadId> {

    protected Set<Producto> producto;
    protected EmpleadoCalidad empleadoCalidad;
    protected Norma norma;

    public Calidad(CalidadId calidadId,Producto producto, EmpleadoCalidad empleadoCalidad, Norma norma) {
        super(calidadId);
        subscribe(new CalidadCambio(this));
        appendChange(new CalidadCreado(calidadId,producto, empleadoCalidad, norma));
    }

    public Calidad(CalidadId calidadId) {
        super(calidadId);
        subscribe(new CalidadCambio(this));
    }

    public static Calidad from(CalidadId calidadId, List<DomainEvent> events){
        var calidad = new Calidad(calidadId);
        events.forEach(calidad::applyEvent);
        return calidad;
    }

    public void asignarEmpleadoCalidad(EmpleadoCalidadId empleadoCalidadId, NombreEmpleadoCalidad nombreEmpleadoCalidad, ProductoAprovado productoAprovado, ResultadoCalidad resultadoCalidad){
        Objects.requireNonNull(empleadoCalidadId, "El id del empleado de calidad no puede ir vacio");
        Objects.requireNonNull(nombreEmpleadoCalidad, "El nombre del empleado de calidad no puede ir vacio");
        Objects.requireNonNull(productoAprovado, "El producto aprovado por el empleado de calidad no puede ir vacio");
        Objects.requireNonNull(resultadoCalidad, "El resultado generado por el empleado de calidad no puede ir vacio");
        appendChange(new EmpleadoCalidadAsignado(empleadoCalidadId,nombreEmpleadoCalidad, productoAprovado,resultadoCalidad));
    }

    public void generarResultadoCalidad(String resultadoCalidad, String detalle){
        Objects.requireNonNull(resultadoCalidad, "El resultado de calidad no puede ir vacio");
        Objects.requireNonNull(detalle, "El detalle del resultado de calidad no puede ir vacio");
        appendChange(new ResultadoCalidadgenerado(resultadoCalidad, detalle));
    }

    public void cambiarEmpleadoCalidad(NombreEmpleadoCalidad nombre){
        Objects.requireNonNull(nombre, "El nombre del empleado de calidad no puede ir vacio");
        this.empleadoCalidad.actualizarNombreEmpleadoCalidad(nombre);
        appendChange(new NombreEmpleadoCalidadCambiado(nombre));
    }

    //TODO generar pautas Norma, tambien en la clase norma
    public void generarNorma(){

    }

    //TODO RevisarPautasNorma tambein en la clase norma
    public void revisarCumplimientoPautasNorma(){

    }

    public void asignarProducto(ProductoId productoId, NombreProducto nombreProducto, ProductoACalidad productoACalidad){
        Objects.requireNonNull(productoId, "El id del producto no puede ir vacio");
        Objects.requireNonNull(nombreProducto, "El nombre del producto no puede ir vacio");
        Objects.requireNonNull(productoACalidad, "El producto enviado a calidad no puede ir vacio");
        appendChange(new ProductoAsignado(productoId, nombreProducto, productoACalidad));
    }

    public Set<Producto> producto() {
        return producto;
    }

    public EmpleadoCalidad empleadoCalidad() {
        return empleadoCalidad;
    }

    public Norma norma() {
        return norma;
    }
}
