package general;

import aluno.AlunoController;
import tutor.TutorController;

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
public class SistemaFacade {
	
	AlunoController alunoController;
	TutorController tutorController;
	
	public SistemaFacade() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
	}
	
	public void cadastrarAluno(String nome, String matricula, String email, int idCurso, String telefone) {
		this.alunoController.cadastrarAluno(nome, matricula, email, idCurso, telefone);
	}
	
	public String recuperarAluno(String matricula) {
		return this.alunoController.recuperarAluno(matricula);
	}
	
	public String listarAlunos() {
		return this.alunoController.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return this.alunoController.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.alunoController.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		return this.tutorController.recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return this.tutorController.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		this.tutorController.cadastraHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.tutorController.cadastraLocal(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.tutorController.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return this.tutorController.consultaLocal(email, local);
	}
	
}
