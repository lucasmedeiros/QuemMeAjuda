package general;

import aluno.Aluno;
import aluno.AlunoController;
import tutor.TutorController;

public class GeneralController {
	
	private AlunoController alunoController;
	private TutorController tutorController;
	
	//private double caixa;
	
	public GeneralController() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
	}
	
	public void cadastrarAluno(String nome, String matricula, int idCurso, String telefone, String email) {
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
		Aluno aluno = this.alunoController.disponivelParaTutor(matricula);
		this.tutorController.tornaTutor(aluno, disciplina, proficiencia);
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
