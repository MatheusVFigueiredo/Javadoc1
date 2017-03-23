package controllers;

import java.io.ObjectInputValidation;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import exception.StringInvalidaException;
import factory.FactoryProjeto;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import repository.RepositoryPessoa;
import repository.RepositoryProjeto;
import util.ExcecoesProjetos;
import util.Util;

public class ProjetoController {
	
	private FactoryProjeto factoryProjeto;
	private RepositoryProjeto repositoryProjeto;
	
	public ProjetoController(){
		this.factoryProjeto = new FactoryProjeto();
		this.repositoryProjeto = new RepositoryProjeto();
	}
	
	public RepositoryProjeto getRepository(){
		return repositoryProjeto;
	}
	
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date data, int duracao) throws Exception{
		try{
			Projeto projeto = factoryProjeto.criaMonitoria(nome, disciplina, rendimento, objetivo, periodo, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		}catch(Exception e){
			throw new Exception(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date data, int duracao) throws Exception{
		try{			
			Projeto projeto = factoryProjeto.criaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		}catch(Exception e){
			throw new Exception(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date data, int duracao) throws Exception{
		try{
			Projeto projeto = factoryProjeto.criaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		}catch(Exception e){
			throw new Exception(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, Date data, int duracao) throws Exception{
		try{			
			Projeto projeto = factoryProjeto.criaExtensao(nome, objetivo, impacto, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		}catch(Exception e){
			throw new Exception(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	public void atualizaProjeto(int codigo, String atributo, String valor) throws Exception{
		try{
			if(atributo.equals("Data de Inicio")){
				ExcecoesProjetos.validaDia(valor);}
			if(atributo.equals("Objetivo")){
				ExcecoesProjetos.validaObjetivoAtualizacao(valor);}
			ExcecoesProjetos.validaAtualizacao(valor);
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			alteraAtributo(projeto, atributo, valor);
		}catch(Exception e){
			throw new Exception(Util.ERRO_ATUALIZAO_PROJETO + e.getMessage());
		}
	}
	
	private void alteraAtributo(Projeto projeto, String atributo, String valor) throws StringInvalidaException{
		
		if(projeto instanceof PET){
			projeto = (PET)(projeto);
			Util.alteraAtributoPET((PET) projeto, atributo, valor);
		}else
		if(projeto instanceof Extensao){
			projeto = (Extensao)(projeto);
			Util.alteraAtributoExtensao((Extensao)projeto, atributo, valor);
		}
		if(projeto instanceof PED){
			projeto = (PED)(projeto);
			Util.alteraAtributoPED((PED)projeto, atributo, valor);
		}else
		if(projeto instanceof Monitoria){
			projeto = (Monitoria)(projeto);
			Util.alteraAtributoMonitoria((Monitoria) projeto, atributo, valor);
		}
	}
	public String getInfoProjeto(int codigo, String atributo) throws Exception{
		try{
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			ExcecoesProjetos.validaProjeto(projeto);
			if(Util.checarAtributoProjeto(atributo)){throw new Exception(ExcecoesProjetos.ERRO_ATRIBUTO_INVALIDO);}
			if(projeto instanceof Monitoria){
				projeto = (Monitoria)(projeto);
				return Util.retornaAtributoMonitoria((Monitoria) projeto, atributo);
			}
			if(projeto instanceof Extensao){
				projeto = (Extensao)(projeto);
				return Util.retornaAtributoExtensao((Extensao)projeto, atributo);
			}
			if(projeto instanceof PED){
			projeto = (PED)(projeto);
			return Util.retornaAtributoPED((PED)projeto, atributo);
			}
			if(projeto instanceof PET){
			projeto = (PET)(projeto);
			return Util.retornaAtributoPET((PET)projeto, atributo);
			}
			return "";
		}catch(Exception e){
			throw new Exception(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}
			
	}
	public int getCodigoProjeto(String nome) throws Exception{
		try{
			ExcecoesProjetos.validaNome(nome);
			if(repositoryProjeto.getCodigoProjeto(nome) == -1){throw new Exception(ExcecoesProjetos.ERRO_PROJETO_INEXISTENTE);}
			return repositoryProjeto.getCodigoProjeto(nome);
		}catch(Exception e){
			throw new Exception(Util.ERRO_OBTENCAO_CODIGO + e.getMessage());
		}
	}
	
	public void removeProjeto(int codigo) throws Exception{
		try{
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			ExcecoesProjetos.validaProjeto(projeto);
			repositoryProjeto.removerProjeto(codigo);
		}catch(Exception e){
			throw new Exception(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}
	}
}
