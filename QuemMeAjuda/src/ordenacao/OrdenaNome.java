package ordenacao;

/**
 * Classe OrdenaNome que que implemente as classes Ordenator e Comparator, e retorna um inteiro para ordenacao baseado
 * na ordem lexicografica do atributo nome da classe Aluno
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

public class OrdenaNome implements Comparator<Aluno>, Ordenador{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		if (a1.getNome().compareTo(a2.getNome()) == 0) {
			return a1.compareTo(a2);
		}
		return a1.getNome().compareTo(a2.getNome());
	}


}
