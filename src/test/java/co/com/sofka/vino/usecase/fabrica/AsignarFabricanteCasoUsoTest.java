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
import co.com.sofka.vino.fabrica.commands.ActualizarFabricanteComando;
import co.com.sofka.vino.fabrica.commands.AgregarFabricaComando;
import co.com.sofka.vino.fabrica.commands.AsignarFabricanteComando;
import co.com.sofka.vino.fabrica.events.FabricaAgregada;
import co.com.sofka.vino.fabrica.events.FabricanteActualizado;
import co.com.sofka.vino.fabrica.events.FabricanteAsignado;
import co.com.sofka.vino.fabrica.usecase.ActualizarFabricanteCasoUso;
import co.com.sofka.vino.fabrica.usecase.AsignarFabricanteCasoUso;
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
public class AsignarFabricanteCasoUsoTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asignarFabricante(){
        //Arrange
        FabricaId fabricaId = FabricaId.fromString("F0001");
        FabricanteId fabricanteId = FabricanteId.fromString("FT001");
        NombreFabricante nombreFabricante = new NombreFabricante("Felipe");
        ProductoAprovado productoAprovado = new ProductoAprovado("Casillero del diablo", 300D);

        var comando = new AsignarFabricanteComando(fabricaId,fabricanteId,nombreFabricante,productoAprovado);
        var casoUso = new AsignarFabricanteCasoUso();

        when(repository.getEventsBy("F0001")).thenReturn(eventos());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(fabricaId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("El fabricante ya ha sido asignado", mensaje);
    }

    @Test
    void asignarFabricanteError(){
        //Arrange
        FabricaId fabricaId = FabricaId.fromString("F0001");
        FabricanteId fabricanteId = FabricanteId.fromString("FT001");
        NombreFabricante nombreFabricante = new NombreFabricante("Felipe");
        ProductoAprovado productoAprovado = new ProductoAprovado("Casillero del diablo", 300D);

        var comando = new AsignarFabricanteComando(fabricaId,fabricanteId,nombreFabricante,productoAprovado);
        var casoUso = new AsignarFabricanteCasoUso();

        when(repository.getEventsBy("F0001")).thenReturn(eventoFabricaError());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(fabricaId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("El fabricante ya ha sido asignado", mensaje);
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
        events.add(new FabricanteAsignado(
                FabricanteId.fromString("FT001"),
                new NombreFabricante("Felipe"),
                new ProductoAprovado("Casillero del diablo", 300D)
        ));
        return events;
    }
}