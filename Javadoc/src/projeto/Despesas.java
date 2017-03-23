package projeto;

import util.ExcecoesProjetos;
import util.Util;

public class Despesas {
	private double valor;
	private String descricao;

	public Despesas(double valor, String descricao) throws Exception {
			
		this.valor = valor;
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
