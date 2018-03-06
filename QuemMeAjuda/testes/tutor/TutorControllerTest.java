package tutor;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import aluno.Aluno;
import tutor.TutorController;

public class TutorControllerTest {

	private TutorController tutorController;

	@Before
	public void setUp() throws Exception {
		tutorController = new TutorController();
		Aluno aluno = new Aluno("joao", "117110637", "joao@silva", 270, "999491615");
		Aluno other = new Aluno("mikael", "117110640", "mikael@amaral", 271, "99872450");
		this.tutorController.tornaTutor(aluno, "P2", 4);
		this.tutorController.tornaTutor(other, "Calculo", 3);
	}

	// Testes de Listar aluno.

	@Test
	public void listaAlunoTest() {
		String esperado = "117110637 - joao - 270 - 999491615 - joao@silva, 117110640 - mikael - 271 - 99872450 - mikael@amaral";
		assertEquals(this.tutorController.listarTutores(), esperado);
	}

	// Testes de retornar aluno

	@Test
	public void RecuperaTutor() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutorController.recuperaTutor("117110637"), saida);
	}

	@Test(expected = IllegalArgumentException.class)
	public void RecuperaTutorMatriculaVazia() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutorController.recuperaTutor(" "), saida);
	}

	@Test(expected = NullPointerException.class)
	public void RecuperaTutorMatriculaNula() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutorController.recuperaTutor(null), saida);
	}

	@Test(expected = NoSuchElementException.class)
	public void RecuperaTutorNaoCadastrado() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutorController.recuperaTutor("877251515"), saida);
	}

	// Testes com cadastramento de horarios

	@Test
	public void cadastraHorarioTest() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		tutorController.cadastraHorario("joao@silva", "12:00", "ter");
		assertTrue(tutorController.consultaHorario("joao@silva", "08:00", "seg"));
	}

	@Test
	public void cadastraHorarioTestEmailInvalido() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertFalse(tutorController.consultaHorario("joaosilva", "08:00", "seg"));
	}

	@Test
	public void cadastraHorarioTestEmailVazio() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertFalse(tutorController.consultaHorario(" ", "08:00", "seg"));
	}

	@Test
	public void cadastraHorarioTestEmailNulo() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertFalse(tutorController.consultaHorario(null, "08:00", "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestHorarioVazio() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutorController.consultaHorario("joao@silva", " ", "seg"));
	}

	@Test(expected = NullPointerException.class)
	public void cadastraHorarioTestHorarioNulo() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutorController.consultaHorario("joao@silva", null, "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestHorarioDiaVazio() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutorController.consultaHorario("joao@silva", "08:00", "    "));
	}

	@Test(expected = NullPointerException.class)
	public void cadastraHorarioTestHorarioDiaNulo() {
		tutorController.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutorController.consultaHorario("joao@silva", "08:00", null));
	}

	// Testes com cadastramento de locais

	@Test
	public void cadastraLocalTest() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutorController.consultaLocal("joao@silva", "UFCG"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestEmailInvalido() {
		tutorController.cadastraLocal("joao2silva", "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestEmailVazio() {
		tutorController.cadastraLocal("  ", "UFCG");
	}

	@Test(expected = NullPointerException.class)
	public void cadastraLocalTestEmailNulo() {
		tutorController.cadastraLocal(null, "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestLocalVazio() {
		tutorController.cadastraLocal("joao@silva", " ");
	}

	@Test(expected = NullPointerException.class)
	public void cadastraLocalTestLocalNulo() {
		tutorController.cadastraLocal("joao@silva", null);
	}

	// Testes para consultar horarios

	@Test
	public void consultaHorarioTestHorarioCadastrado() {
		tutorController.cadastraHorario("mikael@amaral", "10:00", "seg");
		assertTrue(tutorController.consultaHorario("mikael@amaral", "10:00", "seg"));
	}

	@Test()
	public void consultaHorarioTestHorarioNaoCadastrado() {
		tutorController.cadastraHorario("joao@silva", "10:00", "seg");
		tutorController.consultaHorario("joao@silva", "12:00", "seg");
	}

	@Test
	public void consultaHorarioTestEmailInvalido() {
		tutorController.cadastraHorario("mikael@amaral", "10:00", "seg");
		assertFalse(tutorController.consultaHorario("mikael#amaral", "10:00", "seg"));
	}

	@Test
	public void consultaHorarioTestEmailVazio() {
		tutorController.cadastraHorario("joao@silva", "10:00", "seg");
		tutorController.consultaHorario(" ", "10:00", "seg");
	}

	@Test
	public void consultaHorarioTestEmailNulo() {
		tutorController.cadastraHorario("joao@silva", "10:00", "seg");
		assertFalse(tutorController.consultaHorario(null, "10:00", "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestHorarioVazio() {
		tutorController.cadastraHorario("joao@silva", "10:00", "seg");
		tutorController.consultaHorario("joao@silva", " ", "seg");
	}

	@Test(expected = NullPointerException.class)
	public void consultaHorarioTestHorarioNulo() {
		tutorController.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutorController.consultaHorario("mikael@amaral", null, "seg");
	}

	@Test
	public void consultaHorarioTestDiaNaoCadastrado() {
		tutorController.cadastraHorario("mikael@amaral", "10:00", "terc");
		assertTrue(tutorController.consultaHorario("mikael@amaral", "10:00", "seg") == false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestDiaVazio() {
		tutorController.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutorController.consultaHorario("mikael@amaral", "10:00", " ");
	}

	@Test(expected = NullPointerException.class)
	public void consultaHorarioTestDiaNulo() {
		tutorController.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutorController.consultaHorario("mikael@amaral", "10:00", null);
	}

	// Testes para consultar locais

	@Test
	public void consultaLocalTest() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutorController.consultaLocal("joao@silva", "UFCG"));
	}

	@Test
	public void consultaLocalTestLocalNaoCadastrado() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutorController.consultaLocal("joao@silva", "UEPB") == false);
	}

	@Test
	public void consultaLocalTestTutorNaoCadastrado() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertFalse(tutorController.consultaLocal("jose@silva", "UFCG"));
	}

	@Test
	public void consultaLocalTestEmailInvalido() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertFalse(tutorController.consultaLocal("jose2silva", "UFCG"));
	}

	@Test
	public void consultaLocalTestEmailVazio() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertFalse(tutorController.consultaLocal("    ", "UFCG"));
	}

	@Test
	public void consultaLocalTestEmailNulo() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		assertFalse(tutorController.consultaLocal(null, "UFCG"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaLocalTestLocalVazio() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		tutorController.consultaLocal("joao@silva", "            ");
	}

	@Test(expected = NullPointerException.class)
	public void consultaLocalTestLocalNulo() {
		tutorController.cadastraLocal("joao@silva", "UFCG");
		tutorController.consultaLocal("joao@silva", null);
	}

}
