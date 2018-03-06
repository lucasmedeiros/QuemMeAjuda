package ajuda;

import java.util.ArrayList;
import java.util.List;

import general.Validator;

/**
 * Representação da classe que controla a entidade Ajuda.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 2
 */

public class AjudaController {

	private List<Ajudavel> ajudas;
	private Validator val;

	/**
	 * Construtor de AjudaController.
	 * 
	 * @since Parte 2
	 */
	public AjudaController() {
		ajudas = new ArrayList<>();
		val = new Validator();
	}

	/**
	 * Metodo para gerar um ID para uma ajuda.
	 * 
	 * @return id gerado para uma ajuda.
	 * @since Parte 2
	 */
	private int idAjuda() {
		return ajudas.size() + 1;
	}

	/**
	 * Metodo para efetuar o cadastro de uma ajuda online.
	 * 
	 * @param matTutor
	 *            matricula do tutor.
	 * @param disciplina
	 *            disciplina que a ajuda foi requisitada.
	 * @since Parte 2
	 */
	public int pedirAjudaOnline(String matTutor, String disciplina) {
		val.validaString(disciplina, "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");

		int id = idAjuda();
		ajudas.add(new AjudaOnline(id, matTutor, disciplina));
		return id;
	}

	/**
	 * Metodo para efetuar o cadastro de uma ajuda presencial.
	 * 
	 * @param matTutor
	 *            matricula do tutor.
	 * @param disciplina
	 *            disciplina que a ajuda foi requisitada.
	 * @param horario
	 *            horario da ajuda presencial.
	 * @param dia
	 *            dia da ajuda presencial.
	 * @param local
	 *            local da ajuda presencial.
	 * @since Parte 2
	 */
	public int pedirAjudaPresencial(String matTutor, String disciplina, String horario, String dia,
			String localInteresse) {
		val.validaString(disciplina, "Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");

		int id = idAjuda();
		ajudas.add(new AjudaPresencial(id, matTutor, disciplina, horario, dia, localInteresse));
		return id;
	}

	/**
	 * Metodo para pegar informaçao da ajuda.
	 * 
	 * @param atributo
	 *            string que define que tipo de informaçao sobre ajuda deve ser
	 *            retornada.
	 * @param idAjuda
	 *            id da ajuda.
	 * @return informaçao sobre ajuda.
	 * @since Parte 2
	 */
	public String getInfoAjuda(String atributo, int idAjuda) {
		val.validaString(atributo, "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");

		Ajudavel a = ajudaCadastrada(idAjuda, "Erro ao tentar recuperar info da ajuda ");
		val.validaObjetoNulo(a, "Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		return a.getInfo(atributo);
	}

	/**
	 * Metodo para pegar o tutor requisitado na ajuda.
	 * 
	 * @param idAjuda
	 *            id da ajuda.
	 * @return matricula do tutor requisitado.
	 * @since Parte 2
	 */
	public String pegarTutor(int idAjuda) {
		Ajudavel ajuda = ajudaCadastrada(idAjuda, "Erro ao tentar recuperar tutor ");
		val.validaObjetoNulo(ajuda, "Erro ao tentar recuperar tutor : id nao encontrado ");

		return ajuda.getTutor();
	}

	/**
	 * Metodo que verifica se uma ajuda esta cadastrada.
	 * 
	 * @param idAjuda
	 *            id da ajuda a ser consultada.
	 * @param msg
	 *            mensagem de erro.
	 * @return caso exista, retorna um objeto Ajudavel, senao, retorna null
	 * @since Parte 2
	 */
	private Ajudavel ajudaCadastrada(int idAjuda, String msg) {
		val.validaNumeroMenorIgualZero(idAjuda, msg + ": id nao pode menor que zero ");

		for (Ajudavel a : ajudas) {
			if (a.getId() == idAjuda)
				return a;
		}
		return null;
	}

}
