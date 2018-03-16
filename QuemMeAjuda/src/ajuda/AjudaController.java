package ajuda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import general.Validador;

/**
 * Representação da classe que controla a entidade Ajuda.
 *
 * @author
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 2
 */

public class AjudaController {

	private List<Ajuda> ajudas;
	private Validador val;
	private File file;

	/**
	 * Construtor de AjudaController.
	 * 
	 * @since Parte 2
	 */
	public AjudaController() {
		ajudas = new ArrayList<>();
		val = new Validador();
		file = new File("ajudas.txt");
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
	 * @param localInteresse
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

		Ajuda a = ajudaCadastrada(idAjuda, "Erro ao tentar recuperar info da ajuda ");
		val.validaObjetoNulo(a, "Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		return a.getInfo(atributo);
	}

	/**
	 * Metodo para pegar a representacao textual do tutor requisitado na ajuda.
	 * 
	 * @param idAjuda
	 *            id da ajuda.
	 * @return matricula do tutor requisitado.
	 * @since Parte 2
	 */
	public String pegarInfoTutor(int idAjuda) {
		Ajuda ajuda = ajudaCadastrada(idAjuda, "Erro ao tentar recuperar tutor ");
		val.validaObjetoNulo(ajuda, "Erro ao tentar recuperar tutor : id nao encontrado ");

		return ajuda.getTutor();
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
		Ajuda ajuda = ajudaCadastrada(idAjuda, "Erro ao tentar recuperar tutor ");
		val.validaObjetoNulo(ajuda, "Erro na avaliacao de tutor: id nao encontrado ");
		if (ajuda.getFoiAvaliada()) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		return ajuda.getMatriculaTutor();
	}

	/**
	 * Metodo para gravar dados em ajudas.txt, registrando os cadastros feitos para
	 * uma proxima inicializaçao do sistema.
	 */
	public void salvar() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file, true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this.ajudas);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Metodo para carregar os dados de ajuda que ja foram cadastrados em ajuda.txt
	 */
	public void carregar() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			List<Ajuda> ajudasLidas = (List<Ajuda>) ois.readObject();
			for (Ajuda a : ajudasLidas) {
				this.ajudas.add(a);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para limpar os dados de ajuda do sistema.
	 */
	public void limpar() {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que verifica se uma ajuda esta cadastrada.
	 * 
	 * @param idAjuda
	 *            id da ajuda a ser consultada.
	 * @param msg
	 *            mensagem de erro.
	 * @return caso exista, retorna um objeto Ajuda, senao, retorna null
	 * @since Parte 2
	 */
	private Ajuda ajudaCadastrada(int idAjuda, String msg) {
		val.validaNumeroEmIntervalo(idAjuda, 1, Integer.MAX_VALUE, "", msg + ": id nao pode menor que zero ");

		for (Ajuda a : ajudas) {
			if (a.getId() == idAjuda)
				return a;
		}
		return null;
	}

}
