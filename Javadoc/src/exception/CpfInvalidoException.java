package exception;

public class CpfInvalidoException extends Exception{
	public CpfInvalidoException(){
		super("Cpf inválido");
	}
	
	public CpfInvalidoException(String messagem){
		super(messagem);
	}
}
