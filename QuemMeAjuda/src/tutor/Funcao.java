package tutor;

/**
 * 
 * A classe abstrata Funcao representa o pai de diferentes papeis que um Aluno
 * pode desempenhar. Esta Funcao deve ser desempenhada em uma determinada
 * disciplina.
 * 
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
public abstract class Funcao {

	protected String disciplina;

	/**
	 * Constroi um objeto Funcao.
	 * 
	 * @param disciplina
	 *            a disciplina na qual esta Funcao sera desempenhada.
	 * @since Parte 1
	 */
	public Funcao(String disciplina) {
		ehLegal(disciplina);
		this.disciplina = disciplina;
	}

	/**
	 * Metodo de validacao de disciplina
	 * 
	 * @param disciplina
	 *            o campo a ser validado.
	 *
	 * @exception NullPointerException
	 *                se disciplina for null.
	 * @exception IllegalArgumentException
	 *                se disciplina for uma String vaiza.
	 * @since Parte 1
	 */
	private void ehLegal(String disciplina) {
		if (disciplina == null)
			throw new NullPointerException("Erro na definicao de papel: disciplina nao pode ser vazia ou em branco");
		if (disciplina.trim().equals(""))
			throw new IllegalArgumentException(
					"Erro na definicao de papel: disciplina nao pode ser vazia ou em branco");
	}

	/**
	 * Retorna a disciplina desempenhada nesta Funcao.
	 * 
	 * @return a disciplina desempenhada nesta Funcao.
	 * @since Parte 1
	 */
	public String getDisciplina() {
		return this.disciplina;
	}

}
