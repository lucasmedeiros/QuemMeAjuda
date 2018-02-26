package tutor;

import java.util.Map;

import aluno.Alunado;
import aluno.Aluno;

import java.util.HashMap;

/**
 * 
 * [DESCRIÃ‡ÃƒO DO QUE A CLASSE Ã‰, REPRESENTA E OUTRAS INFORMAÃ‡Ã•ES IMPORTANTES]
 * 
 * @authors 
 * <ol> 
 *  <i> Diego Gama </i>
 *  <i> JessÃ© Souza </i>
 *  <i> Lucas Medeiros </i>
 *  <i> Mikael Amaral </i>
 * </ol>
 * @since Parte 1
 */
public class TutorController {

	/*
	 * Representa uma lista de tutores.
	 */
	private Map<String, Aluno> tutores;
	
	/*
	 * Representa o construtor do Controller de Tutor.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Aluno>();
	}
	
	/*
	 * Metodo responsavel por assumir a função de Tutor para um aluno.
	 * 
	 * @param Aluno
	 * 			Aluno que assumirá a função de tutor.
	 * 
	 * @param disciplina
	 * 			A disciplina que o aluno virará um tutor.
	 * 
	 * @param proficiencia
	 * 			A proficiencia do aluno na disciplina.
	 */
	public void tornaTutor(Aluno aluno, String disciplina, int proficiencia) {
		tutores.put(aluno.getMatricula(), aluno);
		aluno.tornarTutor(disciplina, proficiencia);
	}
	
	/*
	 * Metodo responsavel por retornar a descricao textual de um Tutor.
	 * 
	 * A descrição segue o modelo:
	 * 
	 * @param matricula
	 * 			Matricula do tutor em questão.
	 * 
	 * @return String A descrição textual do tutor.
	 */
	public String recuperaTutor(String matricula) {
		return this.tutores.get(matricula).gerarDetalhes();
	}
	
	/*
	 * Método responsável por retornar uma lista de todos os tutores.
	 * 
	 * @return tutores
	 * 		Uma lista com todos os Tutores registrados.
	 */
	public String listarTutores() {
		String lista = "";
		
		for(Aluno aluno : tutores.values()) {
			lista += aluno.toString() + "\n";
		}
		
		return lista;
	}
	
	/*
	 * Método responsável por cadastrar um horário disponível do tutor.
	 * 
	 * @param email
	 * 		O email do tutor
	 * @param local
	 * 		O local de encontro com o tutor.
	 * @param dia
	 * 		O dia disponível do tutor.
	 * 
	 */
	public void cadastraHorario(String email, String local, String dia) {
		
	}
	
	/*
	 * Método responsável por cadastrar um local disponível do tutor.
	 * 
	 * @param email
	 * 		O email do tutor
	 * @param local
	 * 		O local de encontro com o tutor.
	 * 
	 */
	public void cadastraLocal(String email, String local) {
		
	}
	
	/*
	 * Método responsável por consultar um horário disponível do tutor.
	 * 
	 * @param email
	 * 		O email do tutor
	 * @param local
	 * 		O local de encontro com o tutor.
	 * @param dia
	 * 		O dia disponível do tutor.
	 * 
	 * @return boolean
	 * 		Retorna se o local está ou não disponível para o tutor.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		
	}

	/*
	 * Método responsável por consultar um local disponível do tutor.
	 * 
	 * @param email
	 * 		O email do tutor
	 * @param local
	 * 		O local de encontro com o tutor.
	 * @return boolean
	 * 		Retorna se o horário está ou não disponível para o tutor.
	 * 
	 * 
	 */
	public boolean consultaLocal(String email, String local) {
			
	}
	
	
}


