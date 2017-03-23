package exception;

public class PessoaInvalidaException extends Exception {
	public PessoaInvalidaException(){
		super("Pessoa invalida");
	}
	public PessoaInvalidaException(String messagem){
		super(messagem);
	}
}
