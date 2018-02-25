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
	 * Retorna a disciplina desempenhada nesta Funcao.
	 * 
	 * @return a disciplina desempenhada nesta Funcao.
	 * @since Parte 1
	 */
	public String getDisciplina() {
		return this.disciplina;
	}

}