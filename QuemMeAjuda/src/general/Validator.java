package general;

/**
 * Classe para realizar a validação de dados que serão utilizados no sistema.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
public class Validator {

	/**
	 * Método para fazer validação de uma string.
	 *
	 * @param str
	 *            string a ser validada.
	 * @param msg
	 *            mensagem a ser exibida caso não passe na validação.
	 * @since Parte 1
	 */
	public void validaString(String str, String msg) {
		if (str == null)
			throw new NullPointerException(msg);

		if (str.trim().isEmpty())
			throw new IllegalArgumentException(msg);
	}
	
	/**
	 * Metodo que valida um numero, que precisa estar em determinado intervalo.
	 * 
	 * @param num numero a ser validado.
	 * @param inicioIntervalo inicio do intervalo
	 * @param finalIntervalo final do intervalo
	 * @param msgMaior mensagem a ser exibida caso o numero esteja acima do intervalo
	 * @param msgMenor mensagem a ser exibida caso o numero esteja abaixo do intervalo
	 */
	public void validaNumeroEmIntervalo(int num, int inicioIntervalo, int finalIntervalo, String msgMaior, String msgMenor) {
		if (num < inicioIntervalo)
			throw new IllegalArgumentException(msgMenor);
		
		if (num > finalIntervalo)
			throw new IllegalArgumentException(msgMaior);
	}

	/**
	 * Metodo para validar um objeto, se ele eh nulo ou nao.
	 *
	 * @param o
	 *            objeto a ser validado.
	 * @param msg
	 *            mensagem a ser exibida caso nao passe na validacao.
	 * @since Parte 1
	 */
	public void validaObjetoNulo(Object o, String msg) {
		if (o == null)
			throw new NullPointerException(msg);
	}

	/**
	 * Método para validar proficiencia.
	 * 
	 * @param proficiencia
	 *            valor da proficiencia.
	 * @param msg
	 *            mensagem de erro.
	 * @since Parte 1
	 */
	public void validaProficiencia(int proficiencia, String msg) {
		if (proficiencia < 1 || proficiencia > 5)
			throw new IllegalArgumentException(msg);
	}

	/**
	 * Metodo responsavel por validar o email do aluno.
	 * 
	 * @param email
	 *            O email do aluno em questao.
	 * @param msg
	 *            A mensagem que vai ser lancada se um erro for detectado.
	 * @since Parte 1
	 */
	public void validaEmail(String email, String msg) {
		if (email.indexOf("@") == -1 || email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@')
			throw new IllegalArgumentException(msg);
	}
}
