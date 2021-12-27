package co.com.sofka.vino.fabrica.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.fabrica.Fabrica;
import co.com.sofka.vino.fabrica.commands.ActualizarFabricanteComando;

public class ActualizarFabricanteCasoUso extends UseCase<RequestCommand<ActualizarFabricanteComando>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarFabricanteComando> RequestCommand) {
        var comando = RequestCommand.getCommand();
        var fabrica = Fabrica.from(comando.getFabricaId(), retrieveEvents());

        if(!(fabrica.fabricante() == null)){
            throw new BusinessException(comando.getFabricaId().value(), "El fabricante ya ha sido asignado");
        }

        fabrica.actualizarFabricante(
                comando.getNombreFabricante()
        );

        emit().onResponse(new ResponseEvents(fabrica.getUncommittedChanges()));
    }
}
