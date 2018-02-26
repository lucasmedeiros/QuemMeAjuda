package aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import general.Validator;
import tutor.TutorController;

/**
 * Representação da classe que controla a entidade Aluno.
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
public class AlunoController {

    private List<Aluno> alunos;
    private Validator val;
    private TutorController tutorController;

    /**
     * Construtor do Controller de Aluno.
     */
    public AlunoController() {
        alunos = new ArrayList<>();
        val = new Validator();
        this.tutorController = new TutorController();
    }

    /**
     * Método para cadastrar um novo aluno no sistema com telefone.
     *
     * @param nome nome do aluno.
     * @param matricula matricula do aluno.
     * @param email email do aluno.
     * @param idCurso id do curso no qual o aluno esta matriculado.
     * @param telefone telefone do aluno.
     */
    public void cadastrarAluno(String nome, String matricula, String email,
            int idCurso, String telefone) {
        alunos.add(new Aluno(nome, matricula, email, idCurso, telefone));
    }
    
    /**
     * Método para cadastrar um novo aluno no sistema sem telefone
     *
     * @param nome nome do aluno.
     * @param matricula matricula do aluno.
     * @param email email do aluno.
     * @param idCurso id do curso no qual o aluno esta matriculado.
     */
    public void cadastrarAluno(String nome, String matricula, String email,
            int idCurso) {
        cadastrarAluno(nome, matricula, email, idCurso, "");
    }

    /**
     * Método para recuperar os dados de um aluno.
     *
     * @param matricula matricula do aluno.
     * @return representaçao em string do aluno procurado.
     */
    public String recuperarAluno(String matricula) {
        return alunoExiste(matricula, "Erro na consulta de aluno").toString();
    }
    
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
    	val.validaString(disciplina, "Erro ao atribuir tarefa: disciplina nao pode estar vazia ou em branco");
    	val.validaProficiencia(proficiencia, "Erro ao atribuir tarefa: proficiencia invalida");
    	Aluno a = alunoExiste(matricula, "Erro ao atribuir tarefa:");
    	
    	this.tutorController.tornaTutor(a, disciplina, proficiencia);
    	// pensar numa soluçao melhor que nao tenha tanta ligacao entre as classes
    }

    /**
     * Método para listar todos os alunos cadastrados.
     *
     * @return representaçao em string dos alunos cadastrados no sistema.
     */
    public String listarAlunos() {
        String alns = "";
        
        Collections.sort(alunos);

        for (Aluno a: alunos) {
            alns += a.toString() + System.lineSeparator();
        }

        return alns;
    }

    public String getInfoAluno(String matricula, String atributo) {
    	val.validaString(atributo, "Erro ao consultar por atributo: "
    			+ "atributo nao pode ser vazio ou nulo");
    	Aluno a = alunoExiste(matricula, "Erro ao consultar por atributo");
    	
        return a.getInfo(atributo);
    }

    /**
     * Método para verificar se um aluno esta cadastrado no sistema.
     * 
     * @param matricula matricula do aluno.
     * @param msg mensagem de erro.
     * @return representaçao em string do aluno, se ele existir no sistema.
     */
    private Aluno alunoExiste(String matricula, String msg) {
        val.validaString(matricula, msg + ": matricula nao pode ser vazia ou em branco");

        for (Aluno a: alunos) {
            if (a.getMatricula().equals(matricula))
                return a;
        }

        throw new IllegalArgumentException(msg + ": aluno nao cadastrado.");
    }
}
