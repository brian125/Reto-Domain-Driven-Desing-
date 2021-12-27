package co.com.sofka.vino.calidad.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.calidad.Calidad;
import co.com.sofka.vino.calidad.commands.AsignarProductoComando;

public class AsignarProductoCasoUso extends UseCase<RequestCommand<AsignarProductoComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsignarProductoComando> requestCommand) {

        var comando = requestCommand.getCommand();
        var calidad = Calidad.from(comando.getCalidadId(), retrieveEvents());

        if(!(calidad.producto() == null)){
            throw new BusinessException(comando.getCalidadId().value(), "El producto enviado a calidad ya ha sido asignado");
        }

        calidad.asignarProducto(
                comando.getProductoId(),
                comando.getNombreProducto(),
                comando.getProductoACalidad()
                );

        emit().onResponse(new ResponseEvents(calidad.getUncommittedChanges()));
    }

}
