package co.com.sofka.vino.fabrica.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.vino.fabrica.Fabrica;
import co.com.sofka.vino.fabrica.commands.AgregarFabricaComando;
import co.com.sofka.vino.fabrica.commands.AsignarMaterialComando;

public class AsignarMaterialCasoUso extends UseCase<RequestCommand<AsignarMaterialComando>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsignarMaterialComando> requestCommand) {
        var comando = requestCommand.getCommand();
        var fabrica = Fabrica.from(comando.getFabricaId(), retrieveEvents());

        if(!(fabrica.material() == null)){
            throw new BusinessException(comando.getFabricaId().value(),"El material ya ha sido asignado");
        }

        fabrica.asigarMaterial(
                comando.getMaterialId(),
                comando.getUva(),
                comando.getLevadura(),
                comando.getAzucar(),
                comando.getOtro()
        );

        emit().onResponse(new ResponseEvents(fabrica.getUncommittedChanges()));
    }
}
