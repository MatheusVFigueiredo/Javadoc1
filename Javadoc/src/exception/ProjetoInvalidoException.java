package exception;

public class ProjetoInvalidoException extends Exception {
	public ProjetoInvalidoException(){
		super("Projeto invalido");
	}
	public ProjetoInvalidoException(String msg){
		super(msg);
	}
}
