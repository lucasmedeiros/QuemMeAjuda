package ordenacao;

/**
 * Classe OrdenaMatricula que que implemente as classes Ordenator e Comparator, e retorna um inteiro para ordenacao baseado
 * na ordem lexicografica do atributo Matricula da classe Aluno, utilizando do comparable da classe Aluno
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

public class OrdenaMatricula implements Ordenador, Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return  o1.compareTo(o2);
	}

}
