package alessia.Compito.settimanale.Gestione.dispositivi.exceptions;

import org.springframework.validation.ObjectError;

import java.util.List;

public class BadRequestException extends RuntimeException{
    private List<ObjectError> errorsList;
    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(List<ObjectError> errorsList){
        super("There are some errors in the payload-validation");
        this.errorsList = errorsList;
    }
}
