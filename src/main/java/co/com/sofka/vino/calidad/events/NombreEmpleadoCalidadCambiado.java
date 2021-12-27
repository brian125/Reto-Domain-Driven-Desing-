package co.com.sofka.vino.calidad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.NombreEmpleadoCalidad;

public class NombreEmpleadoCalidadCambiado extends DomainEvent {

    private final NombreEmpleadoCalidad nombre;

    public NombreEmpleadoCalidadCambiado(NombreEmpleadoCalidad nombre) {
        super("sofka.calidad.nombreempleadocalidadcambiado");
        this.nombre = nombre;
    }

    public NombreEmpleadoCalidad getNombre() {
        return nombre;
    }
}
