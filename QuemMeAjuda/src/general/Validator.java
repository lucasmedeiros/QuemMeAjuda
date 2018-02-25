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
        if (str == null || str.trim().isEmpty())
            throw new IllegalArgumentException(msg);
    }

    /**
     * Método que valida um número menor ou igual a zero.
     *
     * @param num número a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaNumeroMenorIgualZero(int num, String msg) {
        if (num <= 0)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Método para validar um objeto, se ele é nulo ou não.
     *
     * @param o objeto a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaObjetoNulo(Object o, String msg) {
        if (o == null)
            throw new NullPointerException(msg);
    }
}
