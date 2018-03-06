package aluno;

import org.junit.Test;
import static org.junit.Assert.*;

import aluno.AlunoController;

public class AlunoControllerTest {

    public AlunoControllerTest() {}

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoNomeInvalido1() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("", "1010", "lucas@gmail.com", 1, "9999-9999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoNomeInvalido2() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("     ", "1010", "lucas@gmail.com", 1, "9999-9999");
    }

    @Test(expected = NullPointerException.class)
    public void testCadastrarAlunoNomeInvalido3() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno(null, "1010", "lucas@gmail.com", 1, "9999-9999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoMatriculaInvalida1() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "", "lucas@gmail.com", 1, "9999-9999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoMatriculaInvalida2() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "    ", "lucas@gmail.com", 1, "9999-9999");
    }

    @Test(expected = NullPointerException.class)
    public void testCadastrarAlunoMatriculaInvalida3() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", null, "lucas@gmail.com", 1, "9999-9999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoEmailInvalido1() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "", 1, "9999-9999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoEmailInvalido2() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "     ", 1, "9999-9999");
    }

    @Test(expected = NullPointerException.class)
    public void testCadastrarAlunoEmailInvalido3() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", null, 1, "9999-9999");
    }

    @Test(expected = NullPointerException.class)
    public void testCadastrarAlunoTelefoneInvalido3() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", 1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoCursoInvalido1() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", 0, "9999-9999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAlunoCursoInvalido2() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", -1, "9999-9999");
    }

    @Test
    public void testCadastrarAluno() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", 1, "9999-9999");
    }

    @Test
    public void testRecuperarAluno1() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", 1, "9999-9999");
        String result = controller.recuperarAluno("1010");
        assertEquals("1010 - Lucas - 1 - 9999-9999 - lucas@gmail.com", result);
    }

    @Test(expected = NullPointerException.class)
    public void testRecuperarAluno2() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", 1, "9999-9999");
        controller.recuperarAluno("1011");
    }

    @Test(expected = NullPointerException.class)
    public void testRecuperarAluno3() {
        AlunoController controller = new AlunoController();
        controller.cadastrarAluno("Lucas", "1010", "lucas@gmail.com", 1, "9999-9999");
        controller.recuperarAluno("1009");
    }
}
