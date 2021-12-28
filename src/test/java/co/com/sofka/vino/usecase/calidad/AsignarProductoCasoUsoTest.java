package co.com.sofka.vino.usecase.calidad;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.calidad.EmpleadoCalidad;
import co.com.sofka.vino.calidad.Norma;
import co.com.sofka.vino.calidad.Producto;
import co.com.sofka.vino.calidad.commands.AsignarProductoComando;
import co.com.sofka.vino.calidad.events.CalidadCreado;
import co.com.sofka.vino.calidad.events.ProductoAsignado;
import co.com.sofka.vino.calidad.usecase.AsignarProductoCasoUso;
import co.com.sofka.vino.calidad.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsignarProductoCasoUsoTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asignarProducto(){

        //Arrange
        CalidadId calidadId = CalidadId.fromString("C0001");
        ProductoId productoId = ProductoId.fromString("P0001");
        NombreProducto nombreProducto= new NombreProducto("Aubert Pinot Noir Sonoma Coast");
        ProductoACalidad productoACalidad = new ProductoACalidad("Aubert Pinot Noir Sonoma Coast","Botella de vidrio y uva del bolcan del tibet");

        var comando = new AsignarProductoComando(calidadId,productoId,nombreProducto,productoACalidad);
        var casoUso = new AsignarProductoCasoUso();

        when(repository.getEventsBy("C0001")).thenReturn(eventos());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(calidadId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("El producto enviado a calidad ya ha sido asignado", mensaje);
    }

    @Test
    void asignarProductoError(){
        //Arrange
        CalidadId calidadId = CalidadId.fromString("C0001");
        ProductoId productoId = ProductoId.fromString("P0001");
        NombreProducto nombreProducto= new NombreProducto("Aubert Pinot Noir Sonoma Coast");
        ProductoACalidad productoACalidad = new ProductoACalidad("Aubert Pinot Noir Sonoma Coast","Botella de vidrio y uva del bolcan del tibet");

        var comando = new AsignarProductoComando(calidadId,productoId,nombreProducto,productoACalidad);
        var casoUso = new AsignarProductoCasoUso();

        when(repository.getEventsBy("C0001")).thenReturn(eventoCalidadError());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(calidadId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("El producto enviado a calidad ya ha sido asignado", mensaje);
    }

    private List<DomainEvent> eventos(){
        var events = new ArrayList<DomainEvent>();
        events.add(new CalidadCreado(
                CalidadId.fromString("C0001"),
                new Producto(new ProductoId("P0001"),new NombreProducto("Aubert Pinot Noir Sonoma Coast"),new ProductoACalidad("Aubert Pinot Noir Sonoma Coast", "Uvas provenientes del volcan")),
                new EmpleadoCalidad(EmpleadoCalidadId.fromString("EC001"), new NombreEmpleadoCalidad("Brayan"), new ProductoAprovado("Aubert Pinot Noir Sonoma Coast", 250D), new ResultadoCalidad("Aprovado", "Tanto la botella como el producto estan en buen estado y cumplen las normas icontec")),
                new Norma(new NormaId("N0001"), new NombreNorma("Tiempo fermentado"),  new PautasNorma("250 Dias"))
        ));
        return events;
    }

    private List<DomainEvent> eventoCalidadError(){
        var events = eventos();
        events.add(new ProductoAsignado(
                ProductoId.fromString("P0001"),
                new NombreProducto("Aubert Pinot Noir Sonoma Coast"),
                new ProductoACalidad("Aubert Pinot Noir Sonoma Coast", "Uvas provenientes del volcan")
        ));
        return events;
    }
}