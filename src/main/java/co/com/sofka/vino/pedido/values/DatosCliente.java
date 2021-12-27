package co.com.sofka.vino.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosCliente implements ValueObject<DatosCliente.Properties> {

    private final String nombre;
    private final String telefono;

    public DatosCliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosCliente that = (DatosCliente) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String nombre() {
                return null;
            }

            @Override
            public String telefono() {
                return null;
            }
        };
    }

    public interface Properties{
        String nombre();
        String telefono();
    }
}
