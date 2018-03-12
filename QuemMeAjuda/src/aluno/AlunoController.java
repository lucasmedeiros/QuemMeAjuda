package aluno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import general.Validator;
import ordenacao.Ordenador;

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

	private Map<String, Aluno> alunos;
	private Validator val;

	/**
	 * Construtor do Controller de Aluno.
	 * 
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

	public String listarAlunos(Ordenador c1) {
		String alns = "";

		List<Aluno> alunosOrdenados = new ArrayList<>(alunos.values());

		Collections.sort(alunosOrdenados, c1);

		for (int i = 0; i < alunosOrdenados.size() - 1; i++) {
			alns += alunosOrdenados.get(i).toString() + ", ";

		}

		alns += alunosOrdenados.get(alunosOrdenados.size() - 1).toString();

		return alns;
	}

	/**
	 * Metodo que retorna uma informacao especifica do aluno
	 * 
	 * @param matricula
	 *            Representa a matricula do aluno
	 * @param atributo
	 *            Representa o nome do atributo a ser retornado
	 * @return Retorna o atributo especifico
	 * @since Parte 1
	 */
	public String getInfoAluno(String matricula, String atributo) {
		val.validaString(atributo, "Erro ao consultar por atributo: atributo nao pode ser vazio ou em branco");
		val.validaString(matricula, "Erro ao consultar por atributo: matricula nao pode ser vazia ou em branco");

		val.validaObjetoNulo(alunos.get(matricula), "Erro na obtencao de informacao de aluno: Aluno nao encontrado");

		return alunos.get(matricula).getInfo(atributo);
	}

	/**
	 * Metodo de persistencia que grava os atuais alunos registrados no sistema, em
	 * um arquivo de texto.
	 * @throws IOException caso haja algum problema na leitura, ou o arquivo nao for encontrado.
	 * @since Parte 3
	 */
	public void salvar() {
		File arquivo = new File("alunos.txt");
		ObjectOutputStream escritor = null;
		try {
			escritor = new ObjectOutputStream(new FileOutputStream(arquivo));
			escritor.writeObject(this.alunos.values());
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo de persistencia que recupera para o sistema os dados de alunos previamente gravados.
	 * @throws IOException caso haja algum problema na leitura, ou o arquivo nao for encontrado.
	 * @since Parte 3
	 */
	public void carregar() {
		File arquivo = new File("alunos.txt");
		ObjectInputStream leitor = null;
		try {
			leitor = new ObjectInputStream(new FileInputStream(arquivo));
			@SuppressWarnings("unchecked")
			List<Aluno> alunosLidos = (List<Aluno>) leitor.readObject();
			for (Aluno aluno : alunosLidos) {
				this.alunos.put(aluno.getMatricula(), aluno);
			}
			leitor.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que limpa todos os dados de alunos gravados previamente.
	 * @throws FileNotFoundException caso o arquivo a ser limpo nao seja encontrado.
	 * @since Parte 3
	 */
	public void limpar() {
		File arquivo = new File("alunos.txt");
		try {
			PrintWriter escritor = new PrintWriter(arquivo);
			escritor.print("");
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
