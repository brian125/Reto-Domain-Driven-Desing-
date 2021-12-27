package co.com.sofka.vino.pedido.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.pedido.Pedido;
import co.com.sofka.vino.pedido.commands.AgregarFacturaComando;

public class AgregarFacturaCasoUso extends UseCase<RequestCommand<AgregarFacturaComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarFacturaComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var pedido = Pedido.from(comando.getPedidoId(), retrieveEvents());

        if(!(pedido.factura() == null)){
            throw new BusinessException(comando.getPedidoId().value(), "La factura ya ha sido asignada");
        }

        pedido.generarFactura(
                pedido.factura().identity(),
                comando.getDatosCliente()
        );

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
