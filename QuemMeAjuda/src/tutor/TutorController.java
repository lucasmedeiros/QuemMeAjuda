package tutor;

import java.util.Map;
import java.util.NoSuchElementException;

import aluno.Aluno;
import general.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * Classe TutorControle que controla metodos e informacoes referentes ao
 * controle da classe Tutor, como tornar um aluno tutor, listar todos os
 * tutores, alem de cadastrar e retornar horarios e locais de atendimento dos
 * mesmos
 * 
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
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
	 * 
	 * @since Parte 1
	 */
	public TutorController() {
		this.tutores = new HashMap<>();
		this.val = new Validator();
	}

	/**
	 * Metodo privado que verifica, a partiri do email, se o tutor esta
	 * cadastrado
	 * 
	 * @param email
	 *            Email do Tutor
	 * @param msg
	 *            Mensagem a ser retornada caso o tutor nao esteja cadastrado
	 * @since Parte 1
	 */
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
	 * @since Parte 1
	 */
	public String recuperaTutor(String matricula) {
		val.validaString(matricula, "Matricula nao pode ser vazia ou nula.");
		return this.getTutor(matricula).toString();
	}

	/**
	 * Metodo que torna um aluno especifico em tutor
	 * 
	 * @param aluno
	 *            Aluno que sera o novo tutor
	 * @param disciplina
	 *            Disciplina que o aluno irah titular
	 * @param proficiencia
	 *            Proficiencia que o aluno tem na disciplian, segundo o mesmo
	 * @since Parte 1
	 */
	public void tornaTutor(Aluno aluno, String disciplina, int proficiencia) {
		val.validaString(disciplina, "Erro ao atribuir tarefa: disciplina nao pode estar vazia ou em branco");
		val.validaProficiencia(proficiencia, "Erro na definicao de papel: Proficiencia invalida");

		if (aluno.getTipo() == null) {
			aluno.tornarTutor(disciplina, proficiencia);
			this.tutores.put(aluno.getEmail(), aluno);
		} else {
			aluno.getTipo().adicionaDisciplina(disciplina, proficiencia);
		}
	}

	/**
	 * 
	 * @param matricula
	 *            A matricula do tutor em questao.
	 * @return retorna o aluno relacionado a matricula
	 * @since Parte 1
	 */
	public Aluno getTutor(String matricula) {
		for (Aluno aluno : this.tutores.values()) {
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
	 * @since Parte 1
	 */
	public String listarTutores() {
		String listaTutores = "";

		List<Aluno> tutoresOrdenados = new ArrayList<>(tutores.values());

		Collections.sort(tutoresOrdenados);

		for (int i = 0; i < tutoresOrdenados.size() - 1; i++) {
			listaTutores += tutoresOrdenados.get(i).toString() + ", ";

		}

		listaTutores += tutoresOrdenados.get(tutoresOrdenados.size() - 1).toString();

		return listaTutores;
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
	 * @since Parte 1
	 * 
	 */
	public void cadastraHorario(String email, String horario, String dia) {
		val.validaString(email, "Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Erro no cadastrar horario: email precisa ter arroba.");
		val.validaString(horario, "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		val.validaString(dia, "Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		this.verificaTutor(email, "Erro no cadastrar horario: tutor nao cadastrado");
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
	 * @since Parte 1
	 * 
	 */
	public void cadastraLocal(String email, String local) {
		val.validaString(email, "Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Necessario que o email tenha arroba.");
		val.validaString(local, "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		this.verificaTutor(email, "Erro no cadastrar local de atendimento: tutor nao cadastrado");
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
	 * @since Parte 1
	 */
	public boolean consultaHorario(String email, String horario, String dia) {

		if (!this.tutores.containsKey(email))
			return false;
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
	 * @since Parte 1
	 */
	public boolean consultaLocal(String email, String local) {
		if (!this.tutores.containsKey(email))
			return false;
		val.validaString(email, "Erro no consultar local de atendimento: email nao pode ser vazio ou em branco");
		val.validaEmail(email, "Necessario que o email tenha arroba.");
		val.validaString(local, "Erro no consultar local de atendimento: local nao pode ser vazio ou em branco");
		return this.tutores.get(email).getTipo().consultarLocal(local);
	}

	/**
	 * Metodo que verifica qual tutor esta disponivel para ajuda em determinada
	 * disciplina.
	 * 
	 * @param disciplina
	 *            nome da disciplina.
	 * @param msg
	 *            mensagem de erro.
	 * @return matricula do tutor selecionado para a ajuda.
	 */
	public String tutorParaAjuda(String disciplina, String msg) {
		val.validaString(disciplina, msg + ": DISCIPLINA INVALIDA");
		int maiorNota = Integer.MIN_VALUE;
		Aluno aluno = null;

		for (Aluno a : tutores.values()) {
			Tutor tutor = a.getTipo();
			if (tutor.temDisciplina(disciplina)) {
				int nota = tutor.getNotaTutor();
				if (nota > maiorNota) {
					aluno = a;
					maiorNota = nota;
				}
			}
		}

		val.validaObjetoNulo(aluno, "ERRO");
		return aluno.toString();
	}

}
