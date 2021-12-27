package co.com.sofka.vino.calidad.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.calidad.Calidad;
import co.com.sofka.vino.calidad.commands.AsignarEmpleadoCalidadComando;

public class AsignarEmpleadoCalidadCasoUso extends UseCase<RequestCommand<AsignarEmpleadoCalidadComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsignarEmpleadoCalidadComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var calidad = Calidad.from(comando.getCalidadId(), retrieveEvents());

        if(!(calidad.empleadoCalidad()== null)){
            throw new BusinessException(comando.getCalidadId().value(), "El empleado de calidad ya ha sido asignado");
        }

        calidad.asignarEmpleadoCalidad(
                comando.getEmpleadoCalidadId(),
                comando.getNombreEmpleadoCalidad(),
                comando.getProductoAprovado(),
                comando.getResultadoCalidad()
        );

        emit().onResponse(new ResponseEvents(calidad.getUncommittedChanges()));
    }
}