package general;

/**
 * 
 * Classe SistemaFacade que representa a classe mais proxima ao usuario, a porta
 * de entrada do sistema, possuindo meto dos para cadastrar aluno, recuperar
 * aluno, listar alunos, tornar um aluno tutor, listar alunos que sao tutores,
 * cadas trar horarios e locais de atendimento dos tutores, alem de poder
 * consultar posteriormente tais horarios e locais
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
public class SistemaFacade {	
	private GeneralController generalController;

	public SistemaFacade() {
		this.generalController = new GeneralController();
	}

	public void cadastrarAluno(String nome, String matricula, int idCurso, String telefone, String email) {
		this.generalController.cadastrarAluno(nome, matricula, idCurso, telefone, email);
	}

	public String recuperaAluno(String matricula) {
		return this.generalController.recuperarAluno(matricula);
	}
    /**
	public String listarAlunos() {
		return this.generalController.listarAlunos();
	}
     **/
	public String getInfoAluno(String matricula, String atributo) {
		return this.generalController.getInfoAluno(matricula, atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.generalController.tornarTutor(matricula, disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) {
		return this.generalController.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return this.generalController.listarTutores();
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		this.generalController.cadastrarHorario(email, horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.generalController.cadastrarLocalDeAtendimento(email, local);
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return this.generalController.consultaHorario(email, horario, dia);
	}

	public boolean consultaLocal(String email, String local) {
		return this.generalController.consultaLocal(email, local);
	}
	
	public void doar(String matriculaTutor, int totalCentavos) {
		this.generalController.doar(totalCentavos, matriculaTutor);
	}
	
	public int totalDinheiroSistema() {
		return this.generalController.totalDinheiroSistema();
	}
	
	public int pedirAjudaOnline(String matAluno, String disciplina) {
		return this.generalController.pedirAjudaOnline(matAluno, disciplina);
	}
	
	public int pedirAjudaPresencial(String matAluno, String disciplina, String horario, String dia, String local) {
		return this.generalController.pedirAjudaPresencial(matAluno, disciplina, horario, dia, local);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.generalController.getInfoAjuda(atributo, idAjuda);
	}
	
	public void avaliarTutor(int idAjuda, int nota) {
		this.generalController.avaliarTutor(idAjuda, nota);
	}
	
	public String pegarTutor(int idAjuda) {
		return this.generalController.pegarTutor(idAjuda);
	}
	
	public String pegarNivel(String matriculaTutor) {
		return this.generalController.pegarNivel(matriculaTutor);
	}
	
	public String pegarNota(String matriculaTutor) {
		return this.generalController.pegarNota(matriculaTutor);
	}
	
	public int totalDinheiroTutor(String email) {
		return this.generalController.totalDinheiroTutor(email);
	}
}
