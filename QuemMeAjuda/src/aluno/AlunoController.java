package aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import general.Validator;
import tutor.TutorController;

/**
 * Representação da classe que controla a entidade Aluno.
 *
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
public class AlunoController {

	private List<Aluno> alunos;
	private Validator val;
	private TutorController tutorController;

	/**
	 * Construtor do Controller de Aluno.
	 */
	public AlunoController() {
		alunos = new ArrayList<>();
		val = new Validator();
		this.tutorController = new TutorController();
	}

	/**
	 * Método para cadastrar um novo aluno no sistema com telefone.
	 *
	 * @param nome
	 *            nome do aluno.
	 * @param matricula
	 *            matricula do aluno.
	 * @param email
	 *            email do aluno.
	 * @param idCurso
	 *            id do curso no qual o aluno esta matriculado.
	 * @param telefone
	 *            telefone do aluno.
	 */
	public void cadastrarAluno(String nome, String matricula, String email, int idCurso, String telefone) {

		val.validaString(matricula, "Erro no cadastro de aluno: matricula nao pode ser vazia ou em branco");

		Aluno a = alunoExiste(matricula);
		
		if (a == null)
			alunos.add(new Aluno(nome, matricula, email, idCurso, telefone));
		else
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
	}

	/**
	 * Método para cadastrar um novo aluno no sistema sem telefone
	 *
	 * @param nome
	 *            nome do aluno.
	 * @param matricula
	 *            matricula do aluno.
	 * @param email
	 *            email do aluno.
	 * @param idCurso
	 *            id do curso no qual o aluno esta matriculado.
	 */
	public void cadastrarAluno(String nome, String matricula, String email, int idCurso) {
		cadastrarAluno(nome, matricula, email, idCurso, "");
	}

	/**
	 * Método para recuperar os dados de um aluno.
	 *
	 * @param matricula
	 *            matricula do aluno.
	 * @return representaçao em string do aluno procurado.
	 */
	public String recuperarAluno(String matricula) {
		val.validaString(matricula, "Erro na consulta de aluno: matricula nao pode estar vazia ou em branco");
		
		Aluno a = alunoExiste(matricula);
		
		val.validaObjetoNulo(a, "Erro na consulta de aluno: Aluno nao existe");
		
		return a.toString();
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		val.validaString(disciplina, "Erro ao atribuir tarefa: disciplina nao pode estar vazia ou em branco");
		val.validaString(matricula, "Erro ao atribuir tarefa: matricula nao pode estar vazia ou em branco");
		val.validaProficiencia(proficiencia, "Erro ao atribuir tarefa: proficiencia invalida");
		
		Aluno a = alunoExiste(matricula);
		
		val.validaObjetoNulo(a, "Erro ao atribuir tarefa: Aluno nao existe");

		this.tutorController.tornaTutor(a, disciplina, proficiencia);
	}

	/**
	 * Método para listar todos os alunos cadastrados.
	 *
	 * @return representaçao em string dos alunos cadastrados no sistema.
	 */
	public String listarAlunos() {
		String alns = "";

		Collections.sort(alunos);

		for (int i = 0; i < this.alunos.size() - 1; i++) {
			alns += this.alunos.get(i).toString() + ", ";

		}

		alns += this.alunos.get(this.alunos.size() - 1).toString();

		return alns;
	}

	public String getInfoAluno(String matricula, String atributo) {
		val.validaString(atributo, "Erro ao consultar por atributo: atributo nao pode ser vazio ou em branco");
		val.validaString(matricula, "Erro ao consultar por atributo: matricula nao pode ser vazia ou em branco");
		Aluno a = alunoExiste(matricula);
		
		if (a == null)
			throw new IllegalArgumentException("Erro ao consultar por atributo: aluno nao cadastrado.");

		return a.getInfo(atributo);
	}

	/**
	 * Método para verificar se um aluno esta cadastrado no sistema.
	 * 
	 * @param matricula
	 *            matricula do aluno.
	 * @param msg
	 *            mensagem de erro.
	 * @return representaçao em string do aluno, se ele existir no sistema.
	 */
	private Aluno alunoExiste(String matricula) {
		for (Aluno a : alunos) {
			if (a.getMatricula().equals(matricula))
				return a;
		}
		return null;
	}
}
