package co.com.sofka.vino.fabrica.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.fabrica.Fabrica;
import co.com.sofka.vino.fabrica.commands.AgregarFabricaComando;

public class AsignarMaterialCasoUso extends UseCase<RequestCommand<AgregarFabricaComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarFabricaComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var fabrica = Fabrica.from(comando.getFabricaId(), retrieveEvents());

        if(!(fabrica.material() == null)){
            throw new BusinessException(comando.getFabricaId().value(),"El material ya ha sido asignado");
        }

        fabrica.asigarMaterial(
                comando.getMaterialId(),
                fabrica.material().uva(),
                fabrica.material().levadura(),
                fabrica.material().azucar(),
                fabrica.material().otro()
        );

        emit().onResponse(new ResponseEvents(fabrica.getUncommittedChanges()));
    }
}
