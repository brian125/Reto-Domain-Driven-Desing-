package co.com.sofka.vino.usecase.fabrica;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.values.CalidadId;
import co.com.sofka.vino.calidad.values.ProductoACalidad;
import co.com.sofka.vino.calidad.values.ProductoAprovado;
import co.com.sofka.vino.fabrica.Fabricante;
import co.com.sofka.vino.fabrica.Material;
import co.com.sofka.vino.fabrica.commands.AsignarMaterialComando;
import co.com.sofka.vino.fabrica.events.FabricaAgregada;
import co.com.sofka.vino.fabrica.events.MaterialAsignado;
import co.com.sofka.vino.fabrica.usecase.AsignarMaterialCasoUso;
import co.com.sofka.vino.fabrica.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsignarMaterialCasoUsoTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asignarMaterial(){
        //Arrange
        FabricaId fabricaId = FabricaId.fromString("F0001");
        MaterialId materialId = MaterialId.fromString("M0001");
        Uva uva = new Uva("Uva morada del tibet");
        String levadura = "Polvo para hornear";
        String azucar = "Azucar Morena";
        String otro = null;

        var comando = new AsignarMaterialComando(fabricaId, materialId, uva, levadura, azucar, otro);
        var casoUso= new AsignarMaterialCasoUso();

        when(repository.getEventsBy("F0001")).thenReturn(eventos());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(fabricaId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("El material ya ha sido asignado", mensaje);
    }

    @Test
    void asignarFabricanteError(){
        //Arrange
        FabricaId fabricaId = FabricaId.fromString("F0001");
        MaterialId materialId = MaterialId.fromString("M0001");
        Uva uva = new Uva("Uva morada del tibet");
        String levadura = "Polvo para hornear";
        String azucar = "Azucar Morena";
        String otro = null;

        var comando = new AsignarMaterialComando(fabricaId, materialId, uva, levadura, azucar, otro);
        var casoUso= new AsignarMaterialCasoUso();

        when(repository.getEventsBy("F0001")).thenReturn(eventoFabricaError());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(fabricaId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("El material ya ha sido asignado", mensaje);
    }

    private List<DomainEvent> eventos(){
        var events = new ArrayList<DomainEvent>();
        events.add(new FabricaAgregada(
                FabricaId.fromString("F0001"),
                new Material(MaterialId.fromString("M0001"), new Uva("Uva del tibet"), "Normal", "Morena", null),
                new Fabricante(FabricanteId.fromString("FT001"),new NombreFabricante("Felipe"), new ProductoAprovado("Casillero del diablo", 300D)),
                new ProductoACalidad("Casillero del diablo", "Vino de excelente calidad"),
                CalidadId.fromString("C0002")
        ));
        return events;
    }

    private List<DomainEvent> eventoFabricaError(){
        var events = eventos();
        events.add(new MaterialAsignado(
                MaterialId.fromString("M0001"),
                new Uva("Uva morada del tibet"),
                "Polvo para hornear",
                "Azucar morena",
                null
        ));
        return events;
    }
}
