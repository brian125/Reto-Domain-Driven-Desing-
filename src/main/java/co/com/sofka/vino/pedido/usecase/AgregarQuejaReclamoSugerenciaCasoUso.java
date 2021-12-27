package co.com.sofka.vino.pedido.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.pedido.Pedido;
import co.com.sofka.vino.pedido.commands.AgregarQuejaReclamoSugerenciaComando;

public class AgregarQuejaReclamoSugerenciaCasoUso extends UseCase<RequestCommand<AgregarQuejaReclamoSugerenciaComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarQuejaReclamoSugerenciaComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var pedido = Pedido.from(comando.getPedidoId(), retrieveEvents());

        if(!(pedido.quejaReclamoSugerencia() == null)){
            throw new BusinessException(comando.getPedidoId().value(), "La queja reclamo o sugerencia ya ha sido agregada");
        }

        pedido.agregarQuejaReclamoSugerencia(
                comando.getQuejaReclamoSugerenciaId(),
                comando.getComentario()
        );

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
