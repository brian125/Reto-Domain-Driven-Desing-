package co.com.sofka.vino.calidad.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.calidad.Calidad;
import co.com.sofka.vino.calidad.commands.GenerarResultadosCalidadComando;

public class GenerarResultadoCalidadCasoUso extends UseCase<RequestCommand<GenerarResultadosCalidadComando>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarResultadosCalidadComando> RequestCommand) {
        var comando = RequestCommand.getCommand();
        var calidad = Calidad.from(comando.getCalidadId(), retrieveEvents());

        if(!((comando.getResultadoCalidad().isBlank()) || (comando.getDetalle().isBlank()))){
            throw new BusinessException(comando.getCalidadId().value(),"Para generar un resultado de calidad no puede dejar el resultado y el detalle en blanco");
        }

        calidad.generarResultadoCalidad(
                comando.getResultadoCalidad(),
                comando.getDetalle()
        );

        emit().onResponse(new ResponseEvents(calidad.getUncommittedChanges()));
    }
}
