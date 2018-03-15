package ordenacao;


/**
 * Classe OrdenaEmail que que implemente as classes Ordenator e Comparator, e retorna um inteiro para ordenacao baseado
 * na ordem lexicografica dos atributos email da classe Aluno
 * 
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
import java.util.Comparator;

import aluno.Aluno;

public class OrdenaEmail implements Ordenador, Comparator<Aluno>{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		if (a1.getEmail().compareTo(a2.getEmail()) == 0) {
			return a1.compareTo(a2);
		}else {
			return a1.getEmail().compareTo(a2.getEmail());
	}

	}
	
}
