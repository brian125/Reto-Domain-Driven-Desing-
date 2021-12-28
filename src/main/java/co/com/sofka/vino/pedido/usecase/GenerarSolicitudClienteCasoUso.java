package co.com.sofka.vino.pedido.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.pedido.Pedido;
import co.com.sofka.vino.pedido.commands.GenerarSolicitudClienteComando;

public class GenerarSolicitudClienteCasoUso extends UseCase<RequestCommand<GenerarSolicitudClienteComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<GenerarSolicitudClienteComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var pedido = Pedido.from(comando.getPedidoId(), retrieveEvents());

        if(comando.getCantidad() <= 0){
            throw new BusinessException(comando.getCantidad().toString(), "La cantidad solicitada por el cliente no es valida");
        }

        pedido.generarSolicutudCliente(
                comando.getCantidad()
        );

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
