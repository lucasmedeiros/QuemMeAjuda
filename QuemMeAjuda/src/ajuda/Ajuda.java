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
	
	/**
	 * Representa id da ajuda.
	 */
	protected int id;
	
	/**
	 * Representa a matricula do tutor.
	 */
	protected String matriculaTutor;
	
	/**
	 * Representa a disclina que o tutor ir� dar ajuda.
	 */
	protected String disciplina;
	
	/**
	 * Representa o validador utilizado.
	 */
	protected Validator val = new Validator();

	/**
	 * Metodo para pegar o tutor requisitado na ajuda.
	 * 
	 * @return matricula do tutor requisitado.
	 */
	public String getTutor() {
		return "Tutor - " + this.matriculaTutor + ", disciplina - " + this.disciplina;
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
