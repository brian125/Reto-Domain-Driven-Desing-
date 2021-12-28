package co.com.sofka.vino.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.pedido.values.Comentario;
import co.com.sofka.vino.pedido.values.QuejaReclamoSugerenciaId;

import java.util.Objects;

public class QuejaReclamoSugerencia extends Entity<QuejaReclamoSugerenciaId> {

    private Comentario comentario;

    public QuejaReclamoSugerencia(QuejaReclamoSugerenciaId quejaReclamoSugerenciaId, Comentario comentario) {
        super(quejaReclamoSugerenciaId);
        this.comentario = comentario;
    }

    public void comprobarComentario(){

    }

    public Comentario getComentario() {
        return comentario;
    }
}
