/**
 * 
 */
package aluno;

/**
 * Classe que serve de Interface para a classe Aluno, que possui dois metodos para
 * serem implementados na classe aluno
 * 
 * @authors 
 * <ol> 
 *  <i> Diego Gama </i>
 *  <i> Jessé Souza </i>
 *  <i> Lucas Medeiros </i>
 *  <i> Mikael Amaral </i>
 * </ol>
 * @since Parte 1
 */

public interface Alunado {

	/**
	 * Metodo que retorna uma String detalhada do aluno
	 * @return retorna a representacao, em string, do aluno
	 */
	public String gerarDetalhes();

	/**
	 * Metodo para comparar dois Alunos
	 * @param Aluno a ser comparado
	 * @return retorna um inteiro, onde caso seja < 0, significa que a this.classe eh
	 * menor que o aluno o, se for == 0 significa que sao iguais ee caso seja > 0, sig
	 * nifica que this.classe eh maior que aluno o. Eh utilizado o nome dos alunos como
	 * criterio de comparacao
	 */
	public int compareTo(Aluno o);

}
