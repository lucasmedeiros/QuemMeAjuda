package ajuda;

/**
 * Representaçao de uma Ajuda Online.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */

public class AjudaOnline extends Ajuda {

	/**
	 * Construtor de AjudaOnline.
	 * 
	 * @param matriculaTutor matricula do tutor responsavel pela ajuda.
	 * @param disciplina disciplina que o aluno quer ajuda.
	 */
	public AjudaOnline(int id, String matriculaTutor, String disciplina) {
		this.id = id;
		this.val.validaString(disciplina, "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		this.matriculaTutor = matriculaTutor;
		this.disciplina = disciplina;
	}

	@Override
	public String getInfo(String atributo) {
		this.val.validaString(atributo, "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		switch (atributo.toLowerCase()) {
		case "disciplina":
			return this.disciplina;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

}
