package co.com.sofka.vino.calidad;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.calidad.values.EmpleadoCalidadId;
import co.com.sofka.vino.calidad.values.NombreEmpleadoCalidad;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.calidad.values.ResultadoCalidad;

import java.util.Objects;

public class EmpleadoCalidad extends Entity<EmpleadoCalidadId> {

    private NombreEmpleadoCalidad nombreEmpleadoCalidad;
    private ProductoAprovado productoAprovado;
    private ResultadoCalidad resultadoCalidad;

    public EmpleadoCalidad(EmpleadoCalidadId empleadoCalidadId, NombreEmpleadoCalidad nombreEmpleadoCalidad, ProductoAprovado productoAprovado, ResultadoCalidad resultadoCalidad) {
        super(empleadoCalidadId);
        this.nombreEmpleadoCalidad = nombreEmpleadoCalidad;
        this.productoAprovado = productoAprovado;
        this.resultadoCalidad = resultadoCalidad;
    }

    public void generarResultadosCalidad(String resultadoCalidad, String detalle){
        Objects.requireNonNull(resultadoCalidad, "El resultado de calidad no puede ir vacio");
        Objects.requireNonNull(detalle, "El detalle del resultado de calidad no puede ir vacio");
        this.resultadoCalidad = new ResultadoCalidad(resultadoCalidad, detalle);
    }

    public void actualizarNombreEmpleadoCalidad(NombreEmpleadoCalidad nombreEmpleadoCalidad){
        Objects.requireNonNull(nombreEmpleadoCalidad, "El nombre del empleado encargado de calidad no puede ir vacio");
        this.nombreEmpleadoCalidad = nombreEmpleadoCalidad;
    }

    public NombreEmpleadoCalidad nombreEmpleadoCalidad() {
        return nombreEmpleadoCalidad;
    }

    public ProductoAprovado productoAprovado() {
        return productoAprovado;
    }

    public ResultadoCalidad resultadoCalidad() {
        return resultadoCalidad;
    }
}
