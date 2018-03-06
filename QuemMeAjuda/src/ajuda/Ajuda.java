package ajuda;

import general.Validator;

/**
 * Representação abstrata de uma ajuda.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */

public abstract class Ajuda implements Ajudavel {
	
	protected int id;
	protected String matriculaTutor;
	protected String disciplina;
	protected Validator val = new Validator();

	/**
	 * Metodo para pegar o tutor requisitado na ajuda.
	 * 
	 * @return matricula do tutor requisitado.
	 */
	public String getTutor() {
		return this.matriculaTutor;
	}
	
	/**
	 * Metodo para pegar o id da ajuda.
	 * 
	 * @return id da ajuda.
	 */
	@Override
	public int getId() {
		return this.id;
	}
}
