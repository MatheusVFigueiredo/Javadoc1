package projeto;

/**
 * Extensao
 * Classe que representa o tipo Extensao contendo uma heranca de Projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param impacto
 *           - indica a atuacao direta na sociedade.
 */

import java.util.Calendar;
import java.util.Date;

import util.ExcecoesAssociacao;
import util.ExcecoesProjetos;
import util.Util;

public class Extensao extends Projeto {

	private int impacto;

	public Extensao(int cod, String nome, String objetivo, Date data, int impacto, int duracao) throws Exception {
		super(cod, nome, objetivo, data, duracao);
		ExcecoesProjetos.validaImpacto(impacto);
		this.impacto = impacto;
	}

	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

}
