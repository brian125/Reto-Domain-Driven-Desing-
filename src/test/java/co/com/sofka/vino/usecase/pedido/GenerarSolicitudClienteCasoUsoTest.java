package co.com.sofka.vino.usecase.pedido;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vino.fabrica.values.FabricaId;
import co.com.sofka.vino.pedido.Cliente;
import co.com.sofka.vino.pedido.Factura;
import co.com.sofka.vino.pedido.QuejaReclamoSugerencia;
import co.com.sofka.vino.pedido.commands.GenerarSolicitudClienteComando;
import co.com.sofka.vino.pedido.events.PedidoAgregado;
import co.com.sofka.vino.pedido.events.SolicitudClienteGenerada;
import co.com.sofka.vino.pedido.usecase.GenerarSolicitudClienteCasoUso;
import co.com.sofka.vino.pedido.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenerarSolicitudClienteCasoUsoTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void generarSolicitudCliente(){
        //Arrange
        PedidoId pedidoId = PedidoId.fromString("PD001");
        SolicitudCliente solicitudCliente = new SolicitudCliente(100);

        var comando = new GenerarSolicitudClienteComando(pedidoId,solicitudCliente);
        var casoUso = new GenerarSolicitudClienteCasoUso();

        when(repository.getEventsBy("PD001")).thenReturn(eventos());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(pedidoId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("La cantidad solicitada por el cliente no es valida", mensaje);
    }

    @Test
    void agregarFacturaError(){
        //Arrange
        PedidoId pedidoId = PedidoId.fromString("PD001");
        SolicitudCliente solicitudCliente = new SolicitudCliente(100);

        var comando = new GenerarSolicitudClienteComando(pedidoId,solicitudCliente);
        var casoUso = new GenerarSolicitudClienteCasoUso();

        when(repository.getEventsBy("PD001")).thenReturn(eventoPedidoError());
        casoUso.addRepository(repository);

        //Act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(pedidoId.value())
                    .syncExecutor(casoUso, new RequestCommand<>(comando))
                    .orElseThrow();
        }).getMessage();

        Assertions.assertEquals("La cantidad solicitada por el cliente no es valida", mensaje);
    }

    private List<DomainEvent> eventos(){
        var events = new ArrayList<DomainEvent>();
        events.add(new PedidoAgregado(
                PedidoId.fromString("PD001"),
                new Factura(FacturaId.fromString("FAC01"), new DatosCliente("Carlos", "600104")),
                new Cliente(ClienteId.fromString("CLI01"), new SolicitudCliente(100),new DatosCliente("Carlos", "60104")),
                new QuejaReclamoSugerencia(QuejaReclamoSugerenciaId.fromString("QRS01"), new Comentario("Vino sin sabor", false)),
                FabricaId.fromString("F0001")
        ));
        return events;
    }

    private List<DomainEvent> eventoPedidoError(){
        var events = eventos();
        events.add(new SolicitudClienteGenerada(
                new SolicitudCliente(100)
        ));
        return events;
    }

}