package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.vino.calidad.Calidad;

public class CalidadId extends Identity {

    public CalidadId(String valor) {
        super(valor);
    }

    public CalidadId() {
    }

    public static CalidadId fromString(String valor){
        return new CalidadId(valor);
    }
}
