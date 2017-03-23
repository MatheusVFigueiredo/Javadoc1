package util;

import java.text.SimpleDateFormat;

import exception.EntradaInvalidaException;
import exception.PessoaInvalidaException;
import exception.ProjetoInvalidoException;
import exception.StringInvalidaException;
import projeto.Projeto;

public class ExcecoesProjetos {
	public static final String ERRO_CADASTRO_OBJETIVO_NULO_VAZIO = "Objetivo nulo ou vazio";
	public static final String ERRO_ATUALIZACAO_OBJETIVO_NULO_VAZIO = "Objetivo nao pode ser vazio ou nulo";
	public static final String ERRO_CATEGORIA_INVALIDA = "Categoria invalida";
	public static final String ERRO_DURACAO_INVALIDA = "Duracao invalida";
	public static final String ERRO_PROJETO_INEXISTENTE = "Projeto nao encontrado";
	public static final String ERRO_NUMERO_PATENTES = "Numero de patentes invalido";
	public static final String ERRO_NUMERO_PROD_ACADEMICAS = "Numero de producoes academicas invalido";
	public static final String ERRO_NUMERO_PRO_TECNICAS = "Numero de producoes tecnicas invalido";
	public static final String ERRO_NOME_NULO_VAZIO = "Nome nulo ou vazio";
	public static final String ERRO_ATRIBUTO_INVALIDO = "Atributo nulo ou invalido";
	public static final String ERRO_MONITORIA_PROD_ACADEMICA = "Monitoria nao possui Producao academica";
	public static final String ERRO_FORMATO_DATA = "Formato de data invalido";
	public static final String ERRO_DISCIPLINA_NULA_VAZIA = "Disciplina nula ou vazia";
	public static final String ERRO_PERIODO_NULO_VAZIO = "Periodo nulo ou vazio";
	private static final String ERRO_DATA_NULA_VAZIA = "Data nula ou vazia";
	private static final String ERRO_DATA_INVALIDA = "Data invalida";
	private static final String ERRO_PATENTES_INVALIDO = "Numero de patentes invalido";
	private static final String ERRO_PRODUCOES_ACADEMICAS  = "Numero de producoes academicas invalido";
	private static final String ERRO_PRODUCOES_TECNICAS = "Numero de producoes tecnicas invalido";
	private static final String ERRO_FORMATO_HORA = "Formato de data invalido";
	public static final String ERRO_INT_DOUBLE = "Valor invalido";
	public static final String ERRO_NAO_PODE_SER = " nao pode ser vazio ou nulo";


	
	public static void procuraProjeto(Projeto pessoa) throws PessoaInvalidaException{
		if(pessoa==null){
			throw new PessoaInvalidaException(ERRO_PROJETO_INEXISTENTE);
		}
	}
	public static void validaPatentes(int patentes) throws EntradaInvalidaException{
		if(patentes < 0){
			throw new EntradaInvalidaException(ERRO_NUMERO_PATENTES);
		}
	}
	public static void validaDuracao(int duracao) throws EntradaInvalidaException{
		if(duracao <= 0){
			throw new EntradaInvalidaException(ERRO_DURACAO_INVALIDA);
		}
	}
	public static void validaProducoesAcademicas(int prodAcadeic) throws EntradaInvalidaException{
		if(prodAcadeic < 0){
			throw new EntradaInvalidaException(ERRO_PRODUCOES_ACADEMICAS);
		}
	}
	public static void validaProducoesTecnicas(int prodTecnicas) throws EntradaInvalidaException{
		if(prodTecnicas < 0){
			throw new EntradaInvalidaException(ERRO_PRODUCOES_TECNICAS);
		}
	}
	public static void validaData(String data) throws StringInvalidaException{
		if(data == null || data.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_DATA_NULA_VAZIA);
		}
		String regex = "[0-9][0-9]/[0-9][0-9]/[0-9]{4}";
		if(data.matches(regex)){
			throw new StringInvalidaException(ERRO_DATA_INVALIDA);
		}
	}
	public static void validaAtributo(String atributo) throws StringInvalidaException{
		if(atributo.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_ATRIBUTO_INVALIDO);
		}
	}

	public static void validaObjetivo(String objetivo) throws StringInvalidaException {
		if(objetivo.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_CADASTRO_OBJETIVO_NULO_VAZIO);
		}
	}
	
	public static void validaObjetivoAtualizacao(String objetivo) throws StringInvalidaException {
		if(objetivo.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_CADASTRO_OBJETIVO_NULO_VAZIO);
		}
	}
	
	public static void validaDisciplina(String disciplina) throws StringInvalidaException {
		if(disciplina.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_DISCIPLINA_NULA_VAZIA);
		}
	}

	public static void validaPeriodo(String periodo) throws StringInvalidaException {
		if(periodo.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_PERIODO_NULO_VAZIO);
		}
	}
	
	public static void validaProjeto(Projeto projeto) throws ProjetoInvalidoException{
		if(projeto == null){
			throw new ProjetoInvalidoException(ERRO_PROJETO_INEXISTENTE);
		}
	}
	
	public static void validaDia(String data) throws StringInvalidaException{
		SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
		String regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
		if(!aux.equals(data) || data.matches(regex)){
			throw new StringInvalidaException(ERRO_FORMATO_HORA);
		}
	}
	public static void validaRendimento(int rendimento) throws EntradaInvalidaException {
		if(rendimento < 0){
			throw new EntradaInvalidaException(ERRO_INT_DOUBLE);
		}
	}
	public static void validaImpacto(int impacto) throws EntradaInvalidaException {
		if(impacto < 0){
			throw new EntradaInvalidaException(ERRO_INT_DOUBLE);
		}
	}
	public static void validaNome(String nome) throws StringInvalidaException {
		if(nome == null || nome.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_NOME_NULO_VAZIO);
		}		
	}
	
	public static void validaAtualizacao(String valor) throws EntradaInvalidaException{
		if(valor.trim().isEmpty()){
			throw new EntradaInvalidaException(ERRO_NAO_PODE_SER);
		}
	}

	
}
