package co.com.sofka.vino.pedido.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.pedido.Pedido;
import co.com.sofka.vino.pedido.commands.ActualizarClienteComando;
import co.com.sofka.vino.pedido.values.PedidoId;

public class ActualizarClienteCasoUso extends UseCase<RequestCommand<ActualizarClienteComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarClienteComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var pedido = Pedido.from(comando.getPedidoId(), retrieveEvents());

        if(!(pedido.cliente()==null)){
            throw new BusinessException(comando.getPedidoId().value(), "El cliente ya ha sido actualizado");
        }

        pedido.actualizarCliente(
                comando.getNombre(),
                comando.getTelefono()
        );

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
