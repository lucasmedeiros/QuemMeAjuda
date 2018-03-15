package ajuda;

/**
 * Representaçao de uma Ajuda Online.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 2
 */

public class AjudaOnline extends Ajuda {

	/**
	 * Id para serguranca de serializacao e desserializacao
	 */
	private static final long serialVersionUID = 8253720340600769746L;

	/**
	 * Construtor de AjudaOnline.
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor responsavel pela ajuda.
	 * @param disciplina
	 *            disciplina que o aluno quer ajuda.
	 * @since Parte 2
	 */
	public AjudaOnline(int id, String matriculaTutor, String disciplina) {
		this.id = id;
		val.validaString(matriculaTutor,
				"Erro no pedido de ajuda presencial: matricula de tutor nao pode ser vazio ou em branco");
		this.val.validaString(disciplina, "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		this.matriculaTutor = matriculaTutor;
		this.disciplina = disciplina;
	}

	/**
	 * Metodo para pegar informaçao da ajuda.
	 * 
	 * @param atributo
	 *            string que define que tipo de informaçao sobre ajuda deve ser
	 *            retornada.
	 * @return informaçao sobre ajuda.
	 * @since Parte 2
	 */
	@Override
	public String getInfo(String atributo) {
		this.val.validaString(atributo,
				"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		switch (atributo.toLowerCase()) {
		case "disciplina":
			return this.disciplina;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

}
