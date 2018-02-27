package tutor;

import java.util.Map;
import java.util.NoSuchElementException;

import aluno.Aluno;
import general.Validator;

import java.util.HashMap;

/**
 * 
 * [DESCRIÇÃO DO QUE A CLASSE É, REPRESENTA E OUTRAS INFORMAÇÕES
 * IMPORTANTES]
 * 
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i>
 *          <i> Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
public class TutorController {

	/**
	 * Representa o validador do programa.
	 */
	private Validator val;

	/**
	 * Representa uma lista de tutores.
	 */
	private Map<String, Aluno> tutores;

	/**
	 * Representa o construtor do Controller de Tutor.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Aluno>();
		this.val = new Validator();
	}

	private void verificaTutor(String email, String msg) {
		if (!this.tutores.containsKey(email)) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Metodo responsavel por retornar a descricao textual de um Tutor.
	 * 
	 * A descricao segue o modelo:
	 * 
	 * @param matricula
	 *            Matricula do tutor em questao.
	 * 
	 * @return String A descricao textual do tutor.
	 */
	public String recuperaTutor(String matricula) {
		val.validaString(matricula, "Matricula nao pode ser vazia ou nula.");
		return this.getTutor(matricula).toString();
	}

	/**
	 * 
	 * @param matricula
	 *            A matricula do tutor em questao.
	 * @return retorna o aluno relacionado a matricula
	 */
	private Aluno getTutor(String matricula) {
		for (Aluno aluno : tutores.values()) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;

			}
		}

		throw new NoSuchElementException("Erro na busca por tutor: Tutor nao encontrado");
	}

	/**
	 * Metodo responsavel por retornar uma lista de todos os tutores.
	 * 
	 * @return tutores Uma lista com todos os Tutores registrados.
	 */
	public String listarTutores() {
		String lista = "";

		for (Aluno aluno : tutores.values()) {
			lista += aluno.toString() + "\n";
		}

		return lista;
	}

	/**
	 * Metodo responsavel por cadastrar um horario disponivel do tutor.
	 * 
	 * @param email
	 *            O email do tutor
	 * @param local
	 *            O local de encontro com o tutor.
	 * @param dia
	 *            O dia disponivel do tutor.
	 * 
	 */
	public void cadastraHorario(String email, String horario, String dia) {
		this.verificaTutor(email, "Erro no cadastrar horario: tutor nao cadastrado");
		val.validaString(email, "Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Erro no cadastrar horario: email precisa ter arroba.");
		val.validaString(horario, "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		this.tutores.get(email).getTipo().adicionarHorario(dia, horario);
	}

	/**
	 * 
	 * Metodo responsavel por cadastrar um local disponivel do tutor.
	 * 
	 * @param email
	 *            O email do tutor
	 * @param local
	 *            O local de encontro com o tutor.
	 * 
	 */
	public void cadastraLocal(String email, String local) {
		this.verificaTutor(email, "Erro no cadastrar local de atendimento: tutor nao cadastrado");
		val.validaString(email, "Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Necessario que o email tenha arroba.");
		val.validaString(local, "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		this.tutores.get(email).getTipo().adicionarLocal(local);
	}

	/**
	 * Metodo responsavel por consultar um horario disponivel do tutor.
	 * 
	 * @param email
	 *            O email do tutor
	 * @param local
	 *            O local de encontro com o tutor.
	 * @param dia
	 *            O dia disponivel do tutor.
	 * 
	 * @return boolean Retorna se o local esta ou nao disponivel para o tutor.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		
		this.verificaTutor(email, "Erro no consultar horario de atendimento: tutor nao cadastrado");
		val.validaString(email, "Erro ao consultar horario de atendimento: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Erro ao consultar horario de atendimento: email precisa ter arroba.");
		val.validaString(horario, "Erro ao consultar horario de atendimento: horario nao pode ser vazio ou em branco");
		return this.tutores.get(email).getTipo().consultarHorario(dia, horario);
	}

	/**
	 * 
	 * Metodo responsavel por consultar um local disponivel do tutor.
	 * 
	 * @param email
	 *            O email do tutor
	 * @param local
	 *            O local de encontro com o tutor.
	 * @return boolean Retorna se o horario esta ou nao disponivel para o tutor.
	 * 
	 * 
	 */
	public boolean consultaLocal(String email, String local) {
		this.verificaTutor(email, "Erro no consultar local de atendimento: tutor nao cadastrado");
		val.validaString(email, "Erro no consultar local de atendimento: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Necessario que o email tenha arroba.");
		val.validaString(local, "Erro no consultar local de atendimento: local nao pode ser vazio ou em branco");
		return this.tutores.get(email).getTipo().consultarLocal(local);
	}

}
