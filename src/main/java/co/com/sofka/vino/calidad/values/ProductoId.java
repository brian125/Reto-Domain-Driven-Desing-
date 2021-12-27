package co.com.sofka.vino.calidad.values;

import co.com.sofka.domain.generic.Identity;

public class ProductoId extends Identity {

    public ProductoId(String valor) {
        super(valor);
    }

    public ProductoId() {
    }

    public static ProductoId fromString(String valor){
        return new ProductoId(valor);
    }
}

