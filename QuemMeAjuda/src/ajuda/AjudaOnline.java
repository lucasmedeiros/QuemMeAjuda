package ajuda;

public class AjudaOnline extends Ajuda {

	public AjudaOnline(String matriculaTutor, String disciplina) {
		this.val.validaString(disciplina, "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		this.matriculaTutor = matriculaTutor;
		this.disciplina = disciplina;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		this.val.validaString(atributo, "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		switch (atributo) {
		case "disciplina":
			return this.disciplina;
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

}
