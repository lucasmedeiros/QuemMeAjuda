package aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import general.Validator;

/**
 * Representação da classe que controla a entidade Aluno.
 *
 * @authors
 * <ol>
 * <i> Diego Gama </i> 
 * <i> Jessé Souza </i> 
 * <i> Lucas Medeiros </i> 
 * <i> Mikael Amaral </i>
 * </ol>
 * @since Parte 1
 */
public class AlunoController {

	private Map<String, Aluno> alunos;
	private Validator val;

	/**
	 * Construtor do Controller de Aluno.
	 * @since Parte 1
	 */
	public AlunoController() {
		alunos = new HashMap<String, Aluno>();
		val = new Validator();
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
	 * @since Parte 1
	 */
	public void cadastrarAluno(String nome, String matricula, String email, int idCurso, String telefone) {

		val.validaString(matricula, "Erro no cadastro de aluno: matricula nao pode ser vazia ou em branco");

		Aluno a = new Aluno(nome, matricula, email, idCurso, telefone);

		if (!alunos.containsKey(matricula))
			alunos.put(matricula, a);
		else
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");

	}

	/**
	 * Metodo para recuperar os dados de um aluno. getTutor
	 * 
	 * @param matricula
	 *            matricula do aluno.
	 * @return representaçao em string do aluno procurado.
	 * @since Parte 1
	 */
	public String recuperarAluno(String matricula) {
		val.validaString(matricula, "Erro na consulta de aluno: matricula nao pode estar vazia ou em branco");

		val.validaObjetoNulo(alunos.get(matricula), "Erro na busca por aluno: Aluno nao encontrado");

		return alunos.get(matricula).toString();
	}

	/**
	 * Metodo para tornar um aluno tutor.
	 * 
	 * @param matricula
	 *            matricula do aluno.
	 * @param disciplina
	 *            disciplina que sera ministrada na tutoria.
	 * @param proficiencia
	 *            valor de conhecimento que o proprio tutor atribui a ele mesmo na
	 *            disciplina.
	 * @param tutorController
	 *            controller de Tutor, que eh obtido da Facade.
	 * @since Parte 1
	 */
	public Aluno disponivelParaTutor(String matricula) {
		val.validaString(matricula, "Erro na definicao de papel: matricula nao pode estar vazia ou em branco");

		val.validaObjetoNulo(alunos.get(matricula), "Erro na definicao de papel: Tutor nao encontrado");

		return alunos.get(matricula);
	}

	
	/**
	 * Método para listar todos os alunos cadastrados.
	 *
	 * @return representaçao em string dos alunos cadastrados no sistema.
	 * @since Parte 1
	 */
	/**
	public String listarAlunos() {
		String alns = "";

		Collections.sort(alunos);

		for (int i = 0; i < this.alunos.size() - 1; i++) {
			alns += this.alunos.get(i).toString() + ", ";

		}

		alns += this.alunos.get(this.alunos.size() - 1).toString();

		return alns;
	}

	/**
	 * Metodo que retorna uma informacao especifica do aluno
	 * @param matricula Representa a matricula do aluno
	 * @param atributo Representa o nome do atributo a ser retornado
	 * @return Retorna o atributo especifico
	 * @since Parte 1
	 */
	public String getInfoAluno(String matricula, String atributo) {
		val.validaString(atributo, "Erro ao consultar por atributo: atributo nao pode ser vazio ou em branco");
		val.validaString(matricula, "Erro ao consultar por atributo: matricula nao pode ser vazia ou em branco");

		val.validaObjetoNulo(alunos.get(matricula), "Erro na obtencao de informacao de aluno: Aluno nao encontrado");

		return alunos.get(matricula).getInfo(atributo);
	}


}
