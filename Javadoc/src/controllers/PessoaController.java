package controllers;

import java.util.HashMap;

import exception.CpfInvalidoException;
import exception.EntradaInvalidaException;
import exception.StringInvalidaException;
import pessoa.Pessoa;
import projeto.Monitoria;
import projeto.Projeto;
import repository.RepositoryPessoa;
import util.ExcecoesPessoas;
import util.Util;

/**
 * ParticipacaoController
 * Classe que gerencia todas as operações envolvendo Pessoa.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param repositorypessoa
 *           - variavel que representa a classe RepositoryPessoa.
 */

public class PessoaController {
	
	private RepositoryPessoa repositoryPessoa;
	
	public PessoaController(){
		repositoryPessoa = new RepositoryPessoa();
	}
	
	public RepositoryPessoa getRepository(){
		return repositoryPessoa;
	}
	
	/**
     * criaPessoa
     * Metodo que cria uma nova pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param nome
     *            - nome da pessoa.
     * @param email
     *            - email da pessoa.
     *
     * @return
     * 			- pessoa criada.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	private Pessoa criaPessoa(String cpf, String nome, String email) throws Exception{
		Pessoa pessoa = new Pessoa(cpf, nome, email);
		return pessoa;
	}
	
	/**
     * cadastraPessoa
     * Metodo que cadastra uma nova pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param nome
     *            - nome da pessoa.
     * @param email
     *            - email da pessoa.
     *
     * @return
     * 			- cpf da pessoa cadastrada.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public String cadastraPessoa(String cpf, String nome, String email) throws Exception{
		try{
			ExcecoesPessoas.cpfJaCadastrado(repositoryPessoa.verificaCpfCadastrado(cpf));
			repositoryPessoa.adicionaPessoa(criaPessoa(cpf, nome, email));
			return cpf;
		}catch(Exception e){
			throw new Exception(Util.ERRO_CADASTRO_PESSOA + e.getMessage());
		}
	}
	
	/**
     * atualizaPessoa
     * Metodo que atualiza as informacoes de uma pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param atributo
     *            - atributo para atualizar a pessoa.
     * @param valor
     *            - valor para atualizar a pessoa.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void atualizaPessoa(String cpf, String atributo, String valor) throws Exception{
		try{
			ExcecoesPessoas.validaCpf(cpf);
			ExcecoesPessoas.validaAtributo(atributo);
			ExcecoesPessoas.validaValor(valor);
			ExcecoesPessoas.verificaAtributo(atributo);
			if(atributo.equals("Email")){
				ExcecoesPessoas.validaEmail(valor);
			}
			Pessoa pessoa = repositoryPessoa.getPessoa(cpf);
			alterarAtributo(pessoa, atributo, valor);
		}catch(Exception e){
			throw new Exception(Util.ERRO_ATUALIZACAO_PESSOA + e.getMessage());
		}
	}
	
	
	/**
     * alterarAtributo
     * Metodo que altera o nome e o email de uma pessoa.
     *
     * @param pessoa
     *            - pessoa a ser alterada.
     * @param atributo
     *            - atributo para atualizar a pessoa.
     * @param valor
     *            - valor para atualizar a pessoa.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	private void alterarAtributo(Pessoa pessoa, String atributo, String valor){
		if(atributo.equals("Email")){
			pessoa.setEmail(valor);
		}
		if(atributo.equals("Nome")){
			pessoa.setNome(valor);
		}
	}
	
	public void removePessoa(String cpf) throws EntradaInvalidaException{
		try{
			ExcecoesPessoas.validaCpf(cpf);
			Pessoa pessoa = repositoryPessoa.getPessoa(cpf);
			ExcecoesPessoas.procuraPessoa(pessoa);
			repositoryPessoa.removerPessoa(cpf);
		}catch(Exception e){
			throw new EntradaInvalidaException(e.getMessage());
		}
	}
	
	public String mostrarAtributoPessoa(String cpf, String atributo) throws Exception{
		try{
			ExcecoesPessoas.validaAtributo(atributo);
			ExcecoesPessoas.validaCpf(cpf);
			Pessoa pessoa = repositoryPessoa.getPessoa(cpf);
			ExcecoesPessoas.procuraPessoa(pessoa);
			if(atributo.equals("Nome")){
				return pessoa.getNome();
			}
			else if(atributo.equals("Email")){
				return pessoa.getEmail();
			}else if(atributo.equals("Participacoes")){
				return pessoa.getNomesParticipacao();
			}else{return null;}
		}catch(Exception e){
			throw new Exception(Util.ERRO_CONSULTA_PESSOA + e.getMessage());
		}
	}

}
