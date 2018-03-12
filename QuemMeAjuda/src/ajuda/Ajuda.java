package ajuda;

import java.io.Serializable;

import general.Validator;

/**
 * Representação abstrata de uma ajuda.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 2
 */

public abstract class Ajuda implements Ajudavel, Serializable {

	/**
	 * Id para serguranca de serializacao e desserializacao
	 */
	private static final long serialVersionUID = -3258558515518936564L;

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
	 * @since Parte 2
	 */
	protected Validator val = new Validator();
	
	/**
	 * Representa se a ajuda ja foi ou nao avaliada
	 */
	protected boolean foiAvalida;

	/**
	 * Metodo para pegar o tutor requisitado na ajuda.
	 * 
	 * @return matricula do tutor requisitado.
	 * @since Parte 2
	 */
	public String getTutor() {
		return "Tutor - " + this.matriculaTutor + ", disciplina - " + this.disciplina;
	}
	
	/**
	 * Metodo que retorna a String do tutor referente a ajuda
	 * @return String que representa a matricula do tutor responsavel
	 */
	public String getMatriculaTutor() {
		this.foiAvalida = true;
		return this.matriculaTutor;
	}
	
	/**
	 * Metodo que retorna se a ajuda ja foi avaliada (true) ou nao (false)
	 * @return Boolean que representa o estado da ajuda em relacao a avaliacao
	 */
	public boolean getFoiAvaliada() {
		return this.foiAvalida;
	}
	
	/**
	 * Metodo para pegar o id da ajuda.
	 * 
	 * @return id da ajuda.
	 * @since Parte 2
	 */
	@Override
	public int getId() {
		return this.id;
	}
}
