package co.com.sofka.vino.calidad;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.vino.calidad.events.*;

import java.util.HashSet;

public class CalidadCambio extends EventChange {

    public CalidadCambio(Calidad calidad) {

        apply((CalidadCreado evento) -> {
            calidad.producto = new HashSet<>();
            calidad.empleadoCalidad = evento.getEmpleadoCalidad();
        });

        apply((EmpleadoCalidadAsignado evento) -> {
            calidad.empleadoCalidad = new EmpleadoCalidad(
                    evento.getEmpleadoCalidadId(),
                    evento.getNombreEmpleadoCalidad(),
                    evento.getProductoAprovado(),
                    evento.getResultadoCalidad()
            );
        });

        apply((NombreEmpleadoCalidadCambiado evento) -> {
            calidad.empleadoCalidad.actualizarNombreEmpleadoCalidad(evento.getNombre());
        });

        apply((ProductoAsignado evento) -> {
            calidad.producto.add(new Producto(
               evento.getProductoId(),
               evento.getNombreProducto(),
               evento.getProductoACalidad()
            ));
        });

        apply((ResultadoCalidadgenerado evento) ->
                calidad.empleadoCalidad.generarResultadosCalidad(
                        evento.getResultadoCalidad(),
                        evento.getDetalle()
                ));
    }
}
