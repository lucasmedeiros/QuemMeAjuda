package ordenacao;


import java.util.Comparator;

import aluno.Aluno;

public interface Ordenador extends Comparator<Aluno>{
	
	public int compare(Aluno al1, Aluno al2);

}
