package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Comentario implements ValueObject<Comentario.Properties> {

    private final String detalle;
    private final Boolean tipoComentario;

    public Comentario(String detalle, Boolean tipoComentario) {
        this.detalle = detalle;
        this.tipoComentario = tipoComentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(detalle, that.detalle) && Objects.equals(tipoComentario, that.tipoComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detalle, tipoComentario);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String detalle() {
                return null;
            }

            @Override
            public Boolean tipoComentario() {
                return null;
            }
        };
    }


    public interface Properties{
        String detalle();
        Boolean tipoComentario();
    }
}
