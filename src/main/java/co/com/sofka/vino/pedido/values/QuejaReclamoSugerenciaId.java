package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class QuejaReclamoSugerenciaId extends Identity {

    public QuejaReclamoSugerenciaId(String valor) {
        super(valor);
    }

    public QuejaReclamoSugerenciaId() {
    }

    public static QuejaReclamoSugerenciaId fromString(String valor) {
        return new QuejaReclamoSugerenciaId(valor);
    }
}
