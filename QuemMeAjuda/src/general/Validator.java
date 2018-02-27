package general;

/**
 * Classe para realizar a validação de dados que serão utilizados no sistema.
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
public class Validator {

    /**
     * Método para fazer validação de uma string.
     *
     * @param str string a ser validada.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaString(String str, String msg) {
    	if (str == null)
    		throw new NullPointerException(msg);
    	
        if (str.trim().isEmpty())
            throw new IllegalArgumentException(msg);
    }

    /**
     * Método que valida um número menor ou igual a zero.
     *
     * @param num número a ser validado.
     * @param msg mensagem a ser exibida caso nao passe na validação.
     */
    public void validaNumeroMenorIgualZero(int num, String msg) {
        if (num <= 0)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Metodo para validar um objeto, se ele eh nulo ou nao.
     *
     * @param o objeto a ser validado.
     * @param msg mensagem a ser exibida caso nao passe na validacao.
     */
    public void validaObjetoNulo(Object o, String msg) {
        if (o == null)
            throw new NullPointerException(msg);
    }
    
    /**
     * Método para validar proficiencia.
     * 
     * @param proficiencia valor da proficiencia.
     * @param msg mensagem de erro.
     */
    public void validaProficiencia(int proficiencia, String msg) {
    	if (proficiencia < 1 || proficiencia > 5)
    		throw new IllegalArgumentException(msg);
    }
    
    /**
     * Metodo responsavel por validar o email do aluno.
     * 
     * @param email
     * 		O email do aluno em questao.
     * @param msg
     * 		A mensagem que vai ser lan�ada se um erro for detectado.
     */
    public void validaEmail(String email, String msg) {
    	if(email.indexOf("@") == -1 || email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@')
    		throw new IllegalArgumentException(msg);
    }
}
