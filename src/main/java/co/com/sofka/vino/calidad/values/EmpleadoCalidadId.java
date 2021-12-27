package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.Identity;

public class EmpleadoCalidadId extends Identity {

    public EmpleadoCalidadId(String valor) {
        super(valor);
    }

    public EmpleadoCalidadId() {
    }

    public static EmpleadoCalidadId fromString(String valor){
        return new EmpleadoCalidadId(valor);
    }
}
