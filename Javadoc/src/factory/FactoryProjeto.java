package factory;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import util.ExcecoesProjetos;
import util.Util;

public class FactoryProjeto {
	private static int cod = 0;
	public Projeto criaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, Date data, int duracao) throws Exception{
		cod++;
		Projeto projeto = new Monitoria(cod, nome,disciplina, rendimento, objetivo, periodo, data, duracao);
		return projeto;
	}
	
	public Projeto criaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date data, int duracao) throws Exception{
		cod++;
		Projeto projeto = new PET(cod, nome, objetivo, patentes, impacto, rendimento, prodTecnica, prodAcademica, data, duracao);
		return projeto;
	}
	
	public Projeto criaExtensao(String nome, String objetivo, int impacto, Date data, int duracao) throws Exception{
		cod++;
		Projeto projeto = new Extensao(cod, nome, objetivo, data, impacto, duracao);
		return projeto;
	}
	
	public Projeto criaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date data, int duracao) throws Exception{
		cod++;
		Util.verificarCategoriasPED(categoria);
		Projeto projeto = new PED(cod, nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, data, duracao);
		return projeto;
	}
}
