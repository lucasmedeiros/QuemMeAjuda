/**
 * 
 */
package aluno;

/**
 * 
 * [DESCRIÇÃO DO QUE A CLASSE É, REPRESENTA E OUTRAS INFORMAÇÕES IMPORTANTES]
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
public class Aluno implements Alunado{
 /**
	 * Atributo String que representa o nome do aluno
	 */
	private String nome;
	/**
	 * Atributo String que representa a matricula(identificador) do aluno
	 */
	private String matricula;
	/**
	 * Atributo String que representao o email do aluno
	 */
	private String email;
	/**
	 * Atributo String que representao o telefone(opcional) do aluno
	 */
	private String telefone;
	/**
	 * Atributo Inteiro que representa o id do curso do aluno
	 */
	private int cursoId;
	/**
	 * Atributo Inteiro que representa a nota avaliativa do aluno, setada
	 * inicialmente no valor 5
	 */
	private int nota;
	/**
	 * Atributo tipo que representa uma possivel funcao do aluno(Tutor, por exemplo)
	 */
	private Funcao tipo;

	/**
	 * Construtor da classe Aluno
	 * 
	 * @param nome
	 *            Nome do aluno
	 * @param matricula
	 *            Matricula do aluno
	 * @param email
	 *            email do aluno
	 * @param cursoId
	 *            id do curso do aluno
	 * @param telefone
	 *            telefone do aluno
	 */
	public Aluno(String nome, String matricula, String email, int cursoId, String telefone) {
		this.matricula = matricula;
		this.email = email;
		this.cursoId = cursoId;
		this.telefone = telefone;
		this.nome = nome;
		this.nota = 5;
	}

	/**
	 * Metodo que retorna uma representacao em String do aluno, no formato "MATRICU
	 * LA - NOME - CURSOID - TELEFONE - EMAIL",ou caso o telefone nao foi cadastrado
	 * "MATRICULA - NOME - CURSOID - EMAIL"
	 */
	public String gerarDetalhes() {
		if (telefone.trim().isEmpty()) {
			return this.matricula + " - " + this.nome + " - " + this.cursoId + " - " + this.email;
		} else {
			return this.matricula + " - " + this.nome + " - " + this.cursoId + " - " + this.telefone + " - "
					+ this.email;

		}
	}

	/**
	 * Metodo que recebe parametros para tornar o aluno em um tutor de uma
	 * disciplina especifica
	 * 
	 * @param disciplina
	 *            Disciplina que serah lecionada pelo aluno como tutor
	 * @param proficiencia
	 *            Proficiencia fornecida pelo proprio aluno em relacao a seu
	 *            conhecimento na disciplina
	 */
	public void tornarTutor(String disciplina, int proficiencia) {
		Funcao novaFuncao = new Funcao(disciplina, proficiencia);
		this.tipo = novaFuncao;
	}

	/**
	 * Metodo que retorna a String matricula
	 * 
	 * @return retorna a matricula do aluno
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Metodo que retorna a String email
	 * 
	 * @return retorna o email do aluno
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Metodo que retorna a String telefone
	 * 
	 * @return retorna o telefone do aluno
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Metodo que retorna a String nome
	 * 
	 * @return retorna o nome do aluno
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo que retorna a nota
	 * 
	 * @return retorna a nota do aluno
	 */
	public int getNota() {
		return this.nota;
	}

	/**
	 * Metodo que retorna o id do curso
	 * 
	 * @return retorna o id do curso do aluno
	 */
	public int getCursoId() {
		return this.cursoId;
	}

	/**
	 * Metodo que gera um numero a partir da matricula do aluno
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Metodo que compara dois Alunos a partir da matricula
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Metodo que compara dois alunos a partir dos seus nomes
	 */
	@Override
	public int compareTo(Aluno o) {
		return this.nome.compareTo(o.getNome());
	}

}


