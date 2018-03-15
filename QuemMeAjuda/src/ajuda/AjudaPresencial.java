package ajuda;

/**
 * Representaçao de uma Ajuda Presencial.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 2
 */

public class AjudaPresencial extends Ajuda {

	/**
	 * Id para serguranca de serializacao e desserializacao
	 */
	private static final long serialVersionUID = -7512160153448892114L;

	/**
	 * Representa o horario da ajuda.
	 */
	private String horario;

	/**
	 * Representa o dia da ajuda.
	 */
	private String dia;

	/**
	 * Representa o local da ajuda.
	 */
	private String local;

	/**
	 * Construtor de Ajuda Presencial.
	 * 
	 * @param id
	 *            O id da Ajuda.
	 * @param matriculaTutor
	 *            A matricula do respectivo aluno.
	 * @param disciplina
	 *            A disciplina que o aluno receber� ajuda.
	 * @param horario
	 *            O hor�rio da ajuda.
	 * @param dia
	 *            O dia da ajuda.
	 * @param local
	 *            O local da ajuda.
	 * @since Parte 2
	 */
	public AjudaPresencial(int id, String matriculaTutor, String disciplina, String horario, String dia, String local) {
		this.id = id;
		val.validaString(matriculaTutor,
				"Erro no pedido de ajuda presencial: matricula de tutor nao pode ser vazio ou em branco");
		this.val.validaString(disciplina,
				"Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		this.val.validaString(horario, "Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		this.val.validaString(dia, "Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		this.val.validaString(local,
				"Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		this.matriculaTutor = matriculaTutor;
		this.disciplina = disciplina;
		this.horario = horario;
		this.dia = dia;
		this.local = local;
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
		case "dia":
			return this.dia;
		case "horario":
			return this.horario;
		case "localinteresse":
			return this.local;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

	@Override
	public String getTutor() {
		return "Tutor - " + this.matriculaTutor + ", horario - " + this.horario + ", dia - " + this.dia + ", local - "
				+ this.local + ", disciplina - " + this.disciplina;
	}

}
