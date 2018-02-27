package tutor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import general.Validator;

import java.util.Map;

/**
 * 
 * A classe Tutor abstrai a funcao de tutoria de um Aluno. Um Aluno eh
 * necessariamente um Tutor de uma disciplina, e possui uma determinada
 * proficiencia de 1 a 5 nela. Por padrao um Tutor possui uma nota 4, que varia
 * conforme eh avaliado, bem como uma quantia em dinheiro - inicialmente 0. O
 * Tutor possui um cojunto de lugares disponiveis para suas ajudas, e tambem um
 * horario constituinte de dia e hora para seu atendimento.
 * 
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
public class Tutor {

	private int proficiencia;
	private int dinheiro;
	private int notaTutor;
	private Set<String> locais;
	private Map<String, String> horario;
	private Map<String, Integer> disciplinas;
	
	private Validator val;

	/**
	 * Constroi um objeto Tutor.
	 * 
	 * @param disciplina
	 *            a disciplina na qual o Tutor vai ajudar.
	 * @param proficiencia
	 *            o nivel de proficiencia do Tutor nessa disciplina, definido por um
	 *            inteiro de 1 a 5.
	 * @since Parte 1
	 */
	public Tutor(String disciplina, int proficiencia) {
		this.val = new Validator();
		ehLegal(disciplina, proficiencia);
		
		this.locais = new HashSet<String>();
		this.horario = new HashMap<String, String>();
		this.proficiencia = proficiencia;
		this.dinheiro = 0;
		this.notaTutor = 4;
		
		this.disciplinas = new HashMap<String, Integer>();
		this.disciplinas.put(disciplina, proficiencia);
	}

	/**
	 * Metodo de validacao de proficiencia e disciplina
	 * 
	 * @param disciplina
	 *            a disciplina a ser validada.
	 * @param proficiencia
	 *            a proficiencia a ser validada.
	 *
	 * @exception IllegalArgumentException
	 *                se proficiencia nao estiver entre 1 e 5; e se disciplina for
	 *                String vazia.
	 * @since Parte 1
	 */
	private void ehLegal(String disciplina, int proficiencia) {
		val.validaString(disciplina, "Erro na definicao de papel: disciplina nao pode ser vazia ou em branco");
		val.validaProficiencia(proficiencia, "Erro na definicao de papel: Proficiencia invalida");
	}

	/**
	 * Retorna o valor de proficiencia do Tutor.
	 * 
	 * @return o valor de proficiencia do Tutor.
	 * @since Parte 1
	 */
	public int getProficiencia() {
		return this.proficiencia;
	}

	/**
	 * Retorna a nota atual do Tutor.
	 * 
	 * @return a nota atual do Tutor.
	 * @since Parte 1
	 */
	public int getNotaTutor() {
		return this.notaTutor;
	}

	/**
	 * Retorna a quantia em dinheiro atual do Tutor.
	 * 
	 * @return a quantia em dinheiro atual do Tutor.
	 * @since Parte 1
	 */
	public int getDinheiro() {
		return this.dinheiro;
	}

	/**
	 * Adiciona a quantia especificada ao dinheiro total do Tutor.
	 * 
	 * @param quantia
	 *            a quantia a ser adicionada.
	 * @since Parte 1
	 */
	public void adicionarDinheiro(int quantia) {
		this.dinheiro += quantia;
	}

	/**
	 * Adiciona o local especificado ao conjunto de locais disponiveis.
	 * 
	 * @param local
	 *            o local a ser adicionado aos locais disponiveis.
	 * 
	 * @exception NullPointerException
	 *                se local for null.
	 * @exception IllegalArgumentException
	 *                se local for uma String vazia.
	 * @since Parte 1
	 */
	public void adicionarLocal(String local) {
		val.validaString(local, "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		this.locais.add(local);
	}

	/**
	 * Registra um dia e um horario para atendimento.
	 * 
	 * @param dia
	 *            o dia a ser disponibilizado.
	 * @param horario
	 *            o horario a ser disponibilizado para o dia especificado.
	 * 
	 * @exception NullPointerException
	 *                se dia ou horario for null.
	 * @exception IllegalArgumentException
	 *                se dia ou horario forem Strings vazias.
	 * @since Parte 1
	 */
	public void adicionarHorario(String dia, String horario) {
		val.validaString(dia, "Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		val.validaString(horario, "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		
		this.horario.put(dia, horario);
	}
	
	/**
	 * Metodo para adicionar mais uma disciplina para o tutor.
	 * 
	 * @param disciplina disciplina para ser adicionada.
	 * @param proficiencia proficiencia na disciplina que vai ser adicionada.
	 */
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		ehLegal(disciplina, proficiencia);
		this.disciplinas.put(disciplina, proficiencia);
	}

	/**
	 * Consulta se determinado local foi cadastrado.
	 * 
	 * @param local
	 *            o local a ser checado.
	 * @return true se o local estiver cadastrado, e false caso o contrario.
	 * @since Parte 1
	 */
	public boolean consultarLocal(String local) {
		val.validaString(local, "Erro na consulta de local: local nao pode ser vazio ou em branco");
		return this.locais.contains(local);
	}

	/**
	 * Consulta se determinados dia e horario foram disponibilizados.
	 * 
	 * @param dia
	 *            o dia a ser checado.
	 * @param horario
	 *            o horario a ser checado para o dia especificado.
	 * @return true se estes dia e horario estivererem cadastrados, e false caso o
	 *         contrario.
	 * @since Parte 1
	 */
	public boolean consultarHorario(String dia, String horario) {
		val.validaString(dia, "Erro na consulta de horario: dia nao pode ser vazio ou em branco");
		val.validaString(horario, "Erro na consulta de horario: horario nao pode ser vazio ou em branco");
		return (this.horario.containsKey(dia) && this.horario.containsValue(horario));
	}
	
	
	
	
	
	
}