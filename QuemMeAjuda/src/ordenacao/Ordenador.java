package ordenacao;


/**
 * Interface Ordenador que serve de base para os tipos de ordenacao possiveis no sistema, como por NOME, EMAIL e MA
 * TRICULA
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

public interface Ordenador extends Comparator<Aluno>{
	
	public int compare(Aluno al1, Aluno al2);

}
