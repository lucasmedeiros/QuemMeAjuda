package ordenacao;

import java.util.Comparator;

import aluno.Aluno;

public class OrdenarMatricula implements Ordenador, Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return  o1.compareTo(o2);
	}

}
