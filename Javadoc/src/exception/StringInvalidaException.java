package exception;

public class StringInvalidaException extends Exception{
	public StringInvalidaException(){
		super("String invalida");
	}
	
	public StringInvalidaException(String messagem){
		super(messagem);
	}
}
