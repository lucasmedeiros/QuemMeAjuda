package general;

/**
 * Classe que representa o caixa do sistema, possuindo metodos para retornar o
 * total presente no caixa no momento, calcular o quanto deve ser adicionado ao
 * caixa nas doacoes e retornar o valor a ser destinado ao tutor relacionado as
 * doacoes.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 2
 */

public class Caixa {
	private int caixa;

	/**
	 * Construtor da classe Caixa.
	 * @since Parte 2
	 */
	public Caixa() {
		this.caixa = 0;
	}

	/**
	 * Metodo que retorna o dinheiro do caixa
	 * 
	 * @return retorna o valor guardado no caixa
	 * @since Parte 2
	 */
	public int TotalDinheiroSistema() {
		return this.caixa;
	}

	/**
	 * Metodo que recebe a doacao e o valor da pontuacao do tutor e com essas
	 * informacoes, adiciona a devida quantia da doacao no caixa do sistema e
	 * retorna o valor a ser adicionado a classe Tutor.
	 * 
	 * @param doacao
	 * 		      valor bruto em centavos a ser doado a um tutor.
	 * @param pontuacao
	 *            criterio para calculo do valor liquido.
	 * 
	 * @since Parte 2
	 */
	public int doar(int doacao, double pontuacao) {
		double porcentagemTutor = calcularPorcentagemTutor(pontuacao);
		int taxaSistema = (int) Math.ceil((1 - porcentagemTutor) * doacao);
		this.caixa += taxaSistema;
		doacao -= taxaSistema;
		return (int) Math.floor(doacao);
	}

	/**
	 * Metodo para calcular a porcentagem a ser destinada da doacao ao tutor baseado
	 * na nota que o mesmo possui no momento da doacao
	 * 
	 * @param pontuacao
	 *            representao a nota qualitativa do tutor.
	 * @return retorna um double que representa a porcentagem do tutor em relacao a
	 *         doacao ao mesmo.
	 * @since Parte 2
	 */
	private double calcularPorcentagemTutor(double pontuacao) {
		if (pontuacao >= 4.5) {
			return (9 + (pontuacao - 4.5)) / 10;
		} else if (pontuacao < 3.0) {
			return (4 - (3.0 - pontuacao)) / 10;
		} else {
			return 0.8;
		}
	}
}
