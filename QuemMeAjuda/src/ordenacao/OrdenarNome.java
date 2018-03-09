package ordenacao;

import java.util.Comparator;

import aluno.Aluno;

public class OrdenarNome implements Comparator<Aluno>, Ordenador{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		if (a1.getNome().compareTo(a2.getNome()) == 0) {
			return a1.compareTo(a2);
		}
		return a1.getNome().compareTo(a2.getNome());
	}


}
