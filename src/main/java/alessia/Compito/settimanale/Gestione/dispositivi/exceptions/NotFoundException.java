package alessia.Compito.settimanale.Gestione.dispositivi.exceptions;

import org.aspectj.weaver.ast.Not;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id){
        super("The searched Record with id " + id +"is not found");
    }
}
