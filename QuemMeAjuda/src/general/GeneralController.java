package general;

import ajuda.AjudaController;
import aluno.Aluno;
import aluno.AlunoController;
import tutor.TutorController;

public class GeneralController {

	private AlunoController alunoController;
	private TutorController tutorController;
	private AjudaController ajudaController;
	private Validator val;

	private Caixa caixa;

	public GeneralController() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
		this.ajudaController = new AjudaController();
		this.val = new Validator();
		this.caixa = new Caixa();
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

	public void doar(int doacao, String matriculaTutor) {
		caixa.doar(doacao, tutorController.getTutor(matriculaTutor).getNota());
	}

	public int totalDinheiroSistema() {
		return caixa.TotalDinheiroSistema();
	}

	public void pedirAjudaOnline(String matAluno, String disciplina) {
		val.validaObjetoNulo(this.alunoController.alunoExiste(matAluno), "ERRO AO PEDIR AJUDA ONLINE");
		String matTutor = tutorParaAjuda(disciplina, "ERRO AO PEDIR AJUDA ONLINE");
		this.ajudaController.pedirAjudaOnline(matAluno, matTutor, disciplina);
	}

	public void pedirAjudaPresencial(String matAluno, String disciplina, String horario, String dia, String local) {
		val.validaObjetoNulo(this.alunoController.alunoExiste(matAluno), "ERRO AO PEDIR AJUDA PRESENCIAL");
		String matTutor = tutorParaAjuda(disciplina, "ERRO AO PEDIR AJUDA PRESENCIAL");
		this.ajudaController.pedirAjudaPresencial(matAluno, matTutor, disciplina, horario, dia, local);
	}

	public String getInfoAjuda(String atributo, int idAjuda) {
		return this.ajudaController.getInfoAjuda(atributo, idAjuda);
	}

	public String pegarTutor(int idAjuda) {
		return this.ajudaController.pegarTutor(idAjuda);
	}
	
	private String tutorParaAjuda(String disciplina, String msg) {
		return this.tutorController.tutorParaAjuda(disciplina, msg);
	}
}
