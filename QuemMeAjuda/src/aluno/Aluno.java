package aluno;

import general.Validator;
import tutor.Tutor;

/**
 * Classe Aluno que representa um aluno real, que possui informacoes como nome,
 * matri cula, email, telefone (opcional), ID do cuso, nota e se o mesmo eh
 * tutor, tambem possui algumas funcionalidades, como gerar os detalhes do
 * aluno, tornar o aluno tutor, alem de varios gets para a maioria dos atributos
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

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private String matricula;
	private String email;
	private String telefone;
	private int cursoId;
	private int nota;
	private Tutor tutor;
	
	private Validator val;

	/**
	 * Construtor da classe Aluno
	 *
	 * @param nome
	 *            Nome do aluno.
	 * @param matricula
	 *            Matricula do aluno.
	 * @param email
	 *            email do aluno.
	 * @param cursoId
	 *            id do curso do aluno.
	 * @param telefone
	 *            telefone do aluno.
	 */
	public Aluno(String nome, String matricula, String email, int cursoId, String telefone) {
		this.val = new Validator();
		ehLegal(nome, matricula, email, telefone, cursoId);
		
		this.matricula = matricula;
		this.email = email;
		this.cursoId = cursoId;
		this.telefone = telefone;
		this.nome = nome;
		this.nota = 5;
	}
	
	/**
	 * Validaçao das strings que serao utilizadas.
	 * 
	 * @param nome
	 * @param matricula
	 * @param email
	 * @param idCurso
	 */
	private void ehLegal(String nome, String matricula, String email, String telefone, int idCurso) {
		val.validaString(nome, "Erro no cadastro de aluno");
        val.validaString(matricula, "Erro no cadastro de aluno");
        val.validaString(email, "Erro no cadastro de aluno");
        val.validaNumeroMenorIgualZero(idCurso, "Erro no cadastro de aluno");
        
        if (telefone == null)
        	throw new NullPointerException("Erro no cadastro de Aluno");
	}
	
    public Tutor getTipo() {
		return tutor;
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
		Tutor novaFuncao = new Tutor(disciplina, proficiencia);
		this.tutor = novaFuncao;
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
	 * Método que gera uma representaçao em string.
	 *
	 * @return representacao em string do aluno.
	 */
	@Override
	public String toString() {
		if (telefone.trim().isEmpty()) {
			return this.matricula + " - " + this.nome + " - " + this.cursoId + " - " + this.email;
		} else {
			return this.matricula + " - " + this.nome + " - " + this.cursoId + " - " + this.telefone + " - "
					+ this.email;
		}
	}

	/**
	 * Metodo que gera um numero a partir da matricula do aluno
	 *
	 * @return numero gerado a partir da matricula.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
   * Metodo que compara dois alunos a partir dos seus nomes.
   * @param obj objeto a ser comparado.
   * @return <tr>true</tr> se o objeto é igual a this.
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
	 * Metodo para comparar.
	 */
	@Override
	public int compareTo(Aluno o) {
		return this.nome.compareTo(o.nome);
	}

	public String getInfo(String atributo) {
		switch (atributo) {
			case "nome":
				return this.nome;
			case "matricula":
				return this.matricula;
			case "email":
				return this.email;
			case "telefone":
				if (telefone.trim().isEmpty())
					return "telefone nao cadastrado";
				return this.telefone;
			case "nota":
				return "" + nota;
			case "cursoId":
				return "" + cursoId;
			default:
				throw new IllegalArgumentException("Erro ao consultar........");
		}
	}
}
