package ajuda;

import general.Validator;

public abstract class Ajuda implements Ajudavel {

	protected String matriculaTutor;
	protected String disciplina;
	protected Validator val;

	public String pegarTutor() {
		return this.matriculaTutor;
	}
	public abstract String getInfoAjuda(String atributo);

}
