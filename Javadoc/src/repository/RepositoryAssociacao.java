package repository;

import java.util.ArrayList;

import participacao.AlunoGraduando;
import participacao.AlunoPosGraduando;
import participacao.Participacao;
import participacao.Professor;
import projeto.Projeto;

public class RepositoryAssociacao {
	private ArrayList<Participacao> associacoes;
	
	public RepositoryAssociacao(){
		associacoes = new ArrayList<>();
	}
	
	public void adicionaAssociacao(Participacao part){
		associacoes.add(part);
	}
	
	public boolean getPossuiProfessor(int codigo){
		int aux = 0;
		for(int i=0;i<associacoes.size();i++){
			if(associacoes.get(i).getCodprojeto() == codigo && associacoes.get(i) instanceof Professor){
				return true;
			}
		}
		return false;
	}
	
	public boolean getPossuiGraduando(int codigo){
		int aux = 0;
		for(int i=0;i<associacoes.size();i++){
			if(associacoes.get(i).getCodprojeto() == codigo && associacoes.get(i) instanceof AlunoGraduando){
				return true;
			}
		}
		return false;
	}
	
	public int getQuantCoordenador(int codigo){
		int aux = 0;
		for(int i=0;i<associacoes.size();i++){
			if(associacoes.get(i).getCodprojeto() == codigo && associacoes.get(i) instanceof Professor){
				Participacao assoc = (Professor)(associacoes.get(i));
				if((boolean) ((Professor) assoc).isCoordenador()){
						aux++;
				}
			}
		}
		return aux;
	}
	
	public void removerParticipacoes(int codigo, String cpf){
		for(int i=0; i<associacoes.size(); i++){
			if(associacoes.get(i).getCodprojeto() == codigo && associacoes.get(i).getCpfpessoa().equals(cpf)){
				associacoes.remove(i);
			}
		}
	}
	
	public int getQuantidadeAlunosProjeto(int codigo){
		int aux = 0;
		for(int i=0; i<associacoes.size(); i++){
			if(associacoes.get(i).getCodprojeto() == codigo && associacoes.get(i) instanceof AlunoGraduando){
				aux++;
			}
		}
		return aux;
	}
	
	public int getQuantidadeParticipantes(int codigo){
		int aux = 0;
		for(int i=0; i<associacoes.size(); i++){
			if(associacoes.get(i).getCodprojeto() == codigo){
				aux++;
			}
		}
		if(aux > 5){
			aux = 5;
		}
		return aux;
	}

	public ArrayList<Participacao> getAssociacoes() {
		return associacoes;
	}
	
	
}
