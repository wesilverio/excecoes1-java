
package model.exceptions;

public class DomainException extends Exception{
    //Classe serialazible precisa de um controle de versão
    private static final long serialVersionUID = 1L;
    
    //para permitir instanciar passando uma mensagem e que fique armazenada dentro da escecção
    public DomainException(String message){
        super(message);
    }
}
