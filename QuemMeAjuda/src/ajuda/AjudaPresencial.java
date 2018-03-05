package ajuda;

public class AjudaPresencial extends Ajuda {

	private String horario;
	private String dia;
	private String local;

	public AjudaPresencial(String matriculaTutor, String disciplina, String horario, String dia, String local) {
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

	@Override
	public String getInfoAjuda(String atributo) {
		this.val.validaString(atributo,
				"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		switch (atributo) {
		case "disciplina":
			return this.disciplina;
		case "dia":
			return this.dia;
		case "horario":
			return this.horario;
		case "localInteresse":
			return this.local;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

}
