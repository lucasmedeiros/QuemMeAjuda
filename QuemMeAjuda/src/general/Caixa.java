package general;

/**
 * Classe que representa o caixa do sistema, possuindo metodos para retornar o
 * total presente no caixa no momento, calcular o quanto deve ser adicionado ao
 * caixa nas doacoes e retornar o valor a ser destinado ao tutor relacionado as
 * doacoes
 * 
 * @author jesse
 *
 */

public class Caixa {
	private int caixa;

	/**
	 * Construtor da classe Caixa
	 */
	public Caixa() {
		this.caixa = 0;
	}

	/**
	 * Metodo que retorna o dinheiro do caixa
	 * 
	 * @return Retorna o valor guardado no caixa
	 */
	public int TotalDinheiroSistema() {
		return this.caixa;
	}

	/**
	 * Metodo que recebe a doacao e o valor da pontuacao do tutor e com essas
	 * informacoes, adiciona a devida quantia da doacao no caixa do sistema e
	 * retorna o valor a ser adicionado a classe Tutor
	 */
	public double doar(int doacao, double pontuacao) {
		this.caixa += (int) Math.floor((1 - calcularPorcentagemTutor(pontuacao)) * doacao);
		return Math.floor(calcularPorcentagemTutor(pontuacao) * doacao);
	}

	/**
	 * Metodo para calcular a porcentagem a ser destinada da doacao ao tutor baseado
	 * na nota que o mesmo possui no momento da doacao
	 * 
	 * @param pontuacao
	 *            Representao a nota qualitativa do tutor
	 * @return Retorna um double que representa a porcentagem do tutor em relacao a
	 *         doacao ao mesmo
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
