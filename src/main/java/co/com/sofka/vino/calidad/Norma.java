package co.com.sofka.vino.calidad;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vino.calidad.values.NombreNorma;
import co.com.sofka.vino.calidad.values.NormaId;
import co.com.sofka.vino.calidad.values.PautasNorma;

import java.util.List;
import java.util.Objects;

public class Norma extends Entity<NormaId> {

    private NombreNorma nombreNorma;
    private PautasNorma pautasNorma;

    public Norma(NormaId normaId, NombreNorma nombreNorma, PautasNorma pautasNorma) {
        super(normaId);
        this.nombreNorma = nombreNorma;
        this.pautasNorma = pautasNorma;
    }

    public void actualizarNombreNorma(NombreNorma nombreNorma){
        Objects.requireNonNull(nombreNorma, "El nombre de la norma de calidad no puede ir vacio");
        this.nombreNorma = nombreNorma;
    }

    //TODO mirar como vamos a solucionar el problema de las pautas para pasar las normas
    public void revisarCumplimientoPautasNorma(List pautasNorma) {

    }

    public NombreNorma nombreNorma() {
        return nombreNorma;
    }

    public PautasNorma pautasNorma() {
        return pautasNorma;
    }
}
