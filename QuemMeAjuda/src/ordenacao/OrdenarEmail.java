package ordenacao;

import java.util.Comparator;

import aluno.Aluno;

public class OrdenarEmail implements Ordenador, Comparator<Aluno>{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		if (a1.getEmail().compareTo(a2.getEmail()) == 0) {
			return a1.compareTo(a2);
		}
		return a1.getEmail().compareTo(a2.getEmail());
	}

}
