package aluno;

import java.util.ArrayList;
import java.util.List;
import general.Validator;

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

    private List<Alunado> alunos;
    private Validator val;

    /**
     * Construtor do Controller de Aluno.
     */
    public AlunoController() {
        alunos = new ArrayList<>();
        val = new Validator();
    }

    /**
     * Método para cadastrar um novo aluno no sistema.
     *
     * @param nome nome do aluno.
     * @param matricula matricula do aluno.
     * @param email email do aluno.
     * @param idCurso id do curso no qual o aluno esta matriculado.
     * @param telefone telefone do aluno.
     */
    public void cadastrarAluno(String nome, String matricula, String email,
            int idCurso, String telefone) {
        val.validaString(nome, "Erro no cadastro de aluno");
        val.validaString(matricula, "Erro no cadastro de aluno");
        val.validaString(email, "Erro no cadastro de aluno");
        val.validaString(telefone, "Erro no cadastro de aluno");
        val.validaNumeroMenorIgualZero(idCurso, "Erro no cadastro de aluno");

        alunos.add(new Aluno(nome, matricula, email, idCurso, telefone));
    }

    /**
     * Método para recuperar os dados de um aluno.
     *
     * @param matricula matricula do aluno.
     * @return representaçao em string do aluno procurado.
     */
    public String recuperarAluno(String matricula) {
        return alunoExiste(matricula, "Erro na consulta de aluno");
    }

    /**
     * Método para listar todos os alunos cadastrados.
     *
     * @return representaçao em string dos alunos cadastrados no sistema.
     */
    public String listarAlunos() {
        String alns = "";

        for (Alunado a: alunos) {
            alns += a.toString() + System.lineSeparator();
        }

        return alns;
    }

    public String getInfoAluno(String matricula, String atributo) {
        return null;
        // fazer dps
    }

    /**
     * Método para verificar se um aluno esta cadastrado no sistema.
     * @param matricula matricula do aluno.
     * @param msg mensagem de erro.
     * @return representaçao em string do aluno, se ele existir no sistema.
     */
    private String alunoExiste(String matricula, String msg) {
        val.validaString(matricula, msg);

        for (Alunado a: alunos) {
            if (a.getMatricula().equals(matricula))
                return a.toString();
        }

        throw new IllegalArgumentException(msg + ": Aluno nao cadastrado.");
    }
}
