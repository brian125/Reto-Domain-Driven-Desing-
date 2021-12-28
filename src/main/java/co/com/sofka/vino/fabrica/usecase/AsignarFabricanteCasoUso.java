package co.com.sofka.vino.fabrica.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.fabrica.Fabrica;
import co.com.sofka.vino.fabrica.commands.AsignarFabricanteComando;
import co.com.sofka.vino.fabrica.values.FabricaId;

public class AsignarFabricanteCasoUso extends UseCase<RequestCommand<AsignarFabricanteComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsignarFabricanteComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var fabrica = Fabrica.from(comando.getFabricaId(), retrieveEvents());

        if(!(fabrica.fabricante() == null)){
            throw new BusinessException(comando.getFabricaId().value(), "El material ya ha sido asignado");
        }

        fabrica.asignarFabricante(
                comando.getFabricanteId(),
                comando.getNombreFabricante(),
                comando.getProductoAprovado()
        );

        emit().onResponse(new ResponseEvents(fabrica.getUncommittedChanges()));
    }
}
