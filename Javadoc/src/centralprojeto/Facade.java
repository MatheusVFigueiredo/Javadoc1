package centralprojeto;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import controllers.ParticipacaoController;
import controllers.PessoaController;
import controllers.ProjetoController;
import easyaccept.EasyAccept;
import exception.EntradaInvalidaException;
import exception.StringInvalidaException;

public class Facade {
	
	private PessoaController controllerPessoa;
	private ProjetoController controllerProjeto;
	private ParticipacaoController controllerParticipacao;
	
	public void iniciaSistema(){};
	public void fechaSistema(){};
	public Facade(){
		controllerPessoa = new PessoaController();
		controllerProjeto = new ProjetoController();
		controllerParticipacao = new ParticipacaoController(controllerPessoa.getRepository(), controllerProjeto.getRepository());
	}
	
	public String cadastraPessoa(String cpf, String nome, String email) throws Exception{
		return controllerPessoa.cadastraPessoa(cpf, nome, email);
	}
	
	public void editaPessoa(String cpf, String atributo, String valor) throws Exception{
		controllerPessoa.atualizaPessoa(cpf, atributo, valor);
	}
	
	public void removePessoa(String cpf) throws EntradaInvalidaException{
		controllerPessoa.removePessoa(cpf);
	}
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception{
		return controllerPessoa.mostrarAtributoPessoa(cpf, atributo);
	}
	
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date data, int duracao) throws Exception{
		return controllerProjeto.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, data, duracao);
	}
	
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date data, int duracao) throws Exception{
		return controllerProjeto.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, data, duracao);
	}
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, Date data, int duracao) throws Exception{
		return controllerProjeto.adicionaExtensao(nome, objetivo, impacto, data, duracao);
	}
	
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date data, int duracao) throws Exception{
		return controllerProjeto.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, data, duracao);
	}
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception{
		return controllerProjeto.getInfoProjeto(codigo, atributo);
	}
	
	public int getCodigoProjeto(String nome) throws Exception{
		return controllerProjeto.getCodigoProjeto(nome);
	}
	
	public void editaProjeto(int codigo, String atributo, String valor) throws Exception{
		controllerProjeto.atualizaProjeto(codigo, atributo, valor);
	}
	
	public void removeProjeto(int codigo) throws Exception{
		controllerProjeto.removeProjeto(codigo);
	}
	
	public void associaProfessor(String cpf, int codigo, boolean coordenador, double valorHora, int qntHoras) throws Exception{
		controllerParticipacao.associaProfessor(cpf, codigo, coordenador, valorHora, qntHoras);
	}
	
	public void associaGraduando(String cpf, int codigo, double valorHora, int qntHoras) throws Exception{
		controllerParticipacao.associaGraduando(cpf, codigo, valorHora, qntHoras);
	}
	
	public void associaProfissional(String cpf, int codigo, String cargo, double valorHora, int quantHoras) throws Exception{
		controllerParticipacao.associaProfissional(cpf, codigo, cargo, valorHora, quantHoras);
	}
	
	public void associaPosGraduando(String cpf, int codigo, String nivel, double valorHora, int quantHoras) throws Exception{
		controllerParticipacao.associaPosGraduando(cpf, codigo, nivel, valorHora, quantHoras);
	}
	
	public void removeParticipacao(String cpf, int codigo) throws Exception{
		controllerParticipacao.removeParticipacao(cpf, codigo);
	}
	
	public double calculaPontuacaoPorParticipacao(String cpf){
		return controllerParticipacao.getPontuacaoPessoa(cpf);
	}
	
	public double getValorBolsa(String cpf){
		return controllerParticipacao.getValorBolsa(cpf);
	}
	
	public static void main(String[] args){
		args = new String[]{"centralprojeto.facade",
				"acceptance_tests/us1_test.txt",
				"acceptance_tests/us1_test_exception.txt",
				"acceptance_tests/us2_test.txt",
				"acceptance_tests/us2_test_exception.txt",
				"acceptance_tests/us3_test.txt",
				"acceptance_tests/us3_test_exception.txt",
				"acceptance_tests/us4_test.txt",
				"acceptance_tests/us5_test.txt"
				};
		EasyAccept.main(args);
	}
}
