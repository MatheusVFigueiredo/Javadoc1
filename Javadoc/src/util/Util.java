package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import exception.CpfInvalidoException;
import exception.EntradaInvalidaException;
import exception.PessoaInvalidaException;
import exception.StringInvalidaException;
import pessoa.Pessoa;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import repository.RepositoryProjeto;

public class Util {
	public static final String ERRO_NOME_NULO_VAZIO = "Nome nulo ou vazio";
	public static final String ERRO_CADASTRAR_PESSOA = "Erro no cadastro de pessoa: ";
	public static final String ERRO_INT_DOUBLE = "Valor invalido";
	public static final String ERRO_ATUALIZACAO_PESSOA = "Erro na atualizacao de pessoa: ";
	public static final String ERRO_CONSULTA_PESSOA  = "Erro na consulta de pessoa: ";
	public static final String ERRO_CADASTRAR_PROJETO = "Erro no cadastro de projeto: ";
	public static final String ERRO_CONSULTA_PROJETO = "Erro na consulta de projeto: ";
	public static final String ERRO_CADASTRO_PESSOA = "Erro no cadastro de pessoa: ";
	public static final String ERRO_ATUALIZAO_PROJETO = "Erro na atualizacao de projeto: ";
	public static final String ERRO_NAO_PODE_SER = " nao pode ser vazio ou nulo";
	public static final String ERRO_OBTENCAO_CODIGO = "Erro na obtencao de codigo de projeto: ";
	public static final String ERRO_ASSOCIACAO = "Erro na associacao de pessoa a projeto: ";
	public static final String ERRO_REMOCAO_PARTICIPACAO = "Erro na remocao de participacao: ";
	private static final String ERRO_MONITORIA_CONSULTA = "Monitoria nao possui ";
	private static final String ERRO_PED_CONSULTA = "PED nao possui ";
	private static final String ERRO_EXTENSAO_CONSULTA = "Extensao nao possui ";
	private static final String ERRO_PET_CONSULTA = "PET nao possui ";

	private Util(){}

	
	public static boolean validaData(Calendar data){
		if(data == null){
			return false;
		}
			return true;
	}
	
	public static String[] listaAtributosInteiros(){
		String[] listaAtributosInterios = {"Duracao", "Rendimento", "Impacto", "prodTecnica", "prodAcademica","Patentes"};
		return listaAtributosInterios;
	}
	
	public static String[] listaAtributosProjetos(){
		String[] listaAtributosProjetos = {"Nome","Objetivo","Disciplina","Periodo","Participacoes","Duracao","Rendimento",
		"Impacto", "Producao tecnica", "Producao academica", "Patentes", "Data de inicio"};
		return listaAtributosProjetos;
	}
	
	public static boolean checarAtributoProjeto(String atributo){
		for(int i=0; i<listaAtributosProjetos().length; i++){
			if(atributo.equals(listaAtributosProjetos()[i])){
				return false;
			}
		}
				return true;
	}
	
	public static void alteraAtributoPED(PED projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("prodTecnica")){
			projeto.setProdTecnica(aux);
		}
		if(atributo.equalsIgnoreCase("prodAcademica")){
			projeto.setProdAcademica(aux);
		}
		if(atributo.equalsIgnoreCase("patentes")){
			projeto.setPatentes(aux);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
	}
	
	public static void alteraAtributoPET(PET projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			projeto.setRendimento(aux);
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			projeto.setImpacto(aux);
		}
		if(atributo.equalsIgnoreCase("prodTecnica")){
			projeto.setProdTecnica(aux);
		}
		if(atributo.equalsIgnoreCase("prodAcademica")){
			projeto.setProdAcademica(aux);
		}
		if(atributo.equalsIgnoreCase("patentes")){
			projeto.setPatentes(aux);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
	}
	
	public static void alteraAtributoMonitoria(Monitoria projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
		if(atributo.equalsIgnoreCase("Disciplina")){
			projeto.setDiscEspec(valor);
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			projeto.setRendimento(aux);
		}
		if(atributo.equalsIgnoreCase("Periodo")){
			projeto.setPeriodoLetivo(valor);
		}
	}
	
	public static void alteraAtributoExtensao(Extensao projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			projeto.setImpacto(aux);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
	}
	
	private static boolean checarValorInteiro(String atributo){
		String[] lista = Util.listaAtributosInteiros();
		for(int i = 0; i<lista.length; i++){
			if(atributo.equals(lista[i])){
				return true;
			}
		}
			return false;
	}

	public static String retornaAtributoMonitoria(Monitoria projeto, String atributo) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Disciplina")){
			return projeto.getDiscEspec();
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			return Integer.toString(projeto.getRendimento());
		}
		if(atributo.equalsIgnoreCase("Periodo")){
			return projeto.getPeriodoLetivo();
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_MONITORIA_CONSULTA + atributo);
	}

	
	public static String retornaAtributoExtensao(Extensao projeto, String atributo) throws Exception{
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			return Integer.toString(projeto.getImpacto());
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_EXTENSAO_CONSULTA + atributo);
	}

	public static String retornaAtributoPED(PED projeto, String atributo) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("prodTecnica") || atributo.equalsIgnoreCase("Producao tecnica")){
			return Integer.toString(projeto.getProdTecnica());
		}
		if(atributo.equalsIgnoreCase("prodAcademica") || atributo.equalsIgnoreCase("Producao academica")){
			return Integer.toString(projeto.getProdAcademica());
		}
		if(atributo.equalsIgnoreCase("patentes")){
			return Integer.toString(projeto.getPatentes());
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_PED_CONSULTA + atributo);
	}

	public static String retornaAtributoPET(PET projeto, String atributo) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			return Integer.toString(projeto.getRendimento());
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			return Integer.toString(projeto.getImpacto());
		}
		if(atributo.equalsIgnoreCase("prodTecnica") || atributo.equalsIgnoreCase("Producao tecnica")){
			return Integer.toString(projeto.getProdTecnica());
		}
		if(atributo.equalsIgnoreCase("prodAcademica") || atributo.equalsIgnoreCase("Producao academica")){
			return Integer.toString(projeto.getProdAcademica());
		}
		if(atributo.equalsIgnoreCase("patentes")){
			return Integer.toString(projeto.getPatentes());
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_PET_CONSULTA + atributo);
	}
	
	public static boolean verificarCategoriasPED(String categoria) throws Exception{
		String[] categorias = {"PIBITI", "PIBIT", "PIVIC", "COOP"};
		for(int i = 0; i<categorias.length; i++){
			if(categoria.equals(categorias[i])){
				return true;
			}
		}
			throw new Exception(ExcecoesProjetos.ERRO_CATEGORIA_INVALIDA);
	}
	
	public static double pontuacaoProfessor(Projeto projeto, int quantidade){
		double aux = 0;
		if(projeto.getDuracao() >= 12){
			aux = 4*((int)(projeto.getDuracao() / 12));
		}
		if(projeto instanceof Monitoria){
			return aux;
		}
		aux += quantidade;
		return aux;
	}
	
	public static double pontuacaoGraduando(Projeto projeto){
		double aux = 0;
		int x = projeto.getDuracao() / 6;
		if(projeto instanceof Monitoria){
			aux += 1.5;
		}else{
			aux += 2.0;
		}
		return aux*x;
	}
	
	public static double pontuacaoProfissional(Projeto projeto, String cargo){
		double aux = 0;
		int x = (int) (projeto.getDuracao()/12);
		if(x==0){
			return 0;
		}
		if(cargo.equalsIgnoreCase("Desenvolvedor")){
			aux += 5;
		}else if(cargo.equalsIgnoreCase("Gerente")){
			aux += 9;
		}else if(cargo.equalsIgnoreCase("Pesquisador")){
			aux += 6;
		}
		return aux*x;
	}


	public static double validaPontuacaoAlunoGraduando(double pontMonitoria, double pontOutros) {
		double aux = 0;
		if(pontMonitoria > 6){
			aux += 6;
		}else{
			aux += pontMonitoria;
		}
		if(pontOutros > 8){
			aux+=8;
		}else{
			aux += pontOutros;
		}	
		return aux;
	}
	
	
}
