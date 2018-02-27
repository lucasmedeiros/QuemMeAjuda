package tutor;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import aluno.Aluno;
import tutor.TutorController;

public class TutorControllerTest {

	private TutorController tutores;

	@Before
	public void setUp() throws Exception {
		tutores = new TutorController();
		Aluno aluno = new Aluno("joao", "117110637", "joao@silva", 270, "999491615");
		Aluno other = new Aluno("mikael", "117110640", "mikael@amaral", 271, "99872450");
		this.tutores.tornaTutor(aluno, "P2", 4);
		this.tutores.tornaTutor(other, "Calculo", 3);
	}

	// Testes de Listar aluno.

	@Test
	public void listaAlunoTest() {
		String esperado = "117110637 - joao - 270 - 999491615 - joao@silva\n117110640 - mikael - 271 - 99872450 - mikael@amaral\n";
		assertEquals(this.tutores.listarTutores(), esperado);
	}

	// Testes de retornar aluno

	@Test
	public void RecuperaTutor() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutores.recuperaTutor("117110637"), saida);
	}

	@Test(expected = IllegalArgumentException.class)
	public void RecuperaTutorMatriculaVazia() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutores.recuperaTutor(" "), saida);
	}

	@Test(expected = NullPointerException.class)
	public void RecuperaTutorMatriculaNula() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutores.recuperaTutor(null), saida);
	}

	@Test(expected = NoSuchElementException.class)
	public void RecuperaTutorNaoCadastrado() {
		String saida = "117110637 - joao - 270 - 999491615 - joao@silva";
		assertEquals(tutores.recuperaTutor("877251515"), saida);
	}

	// Testes com cadastramento de horarios

	@Test
	public void cadastraHorarioTest() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		tutores.cadastraHorario("joao@silva", "12:00", "ter");
		assertTrue(tutores.consultaHorario("joao@silva", "08:00", "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestEmailInvalido() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario("joaosilva", "08:00", "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestEmailVazio() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario(" ", "08:00", "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestEmailNulo() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario(null, "08:00", "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestHorarioVazio() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario("joao@silva", " ", "seg"));
	}

	@Test(expected = NullPointerException.class)
	public void cadastraHorarioTestHorarioNulo() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario("joao@silva", null, "seg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraHorarioTestHorarioDiaVazio() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario("joao@silva", "08:00", "    "));
	}

	@Test(expected = NullPointerException.class)
	public void cadastraHorarioTestHorarioDiaNulo() {
		tutores.cadastraHorario("joao@silva", "08:00", "seg");
		assertTrue(tutores.consultaHorario("joao@silva", "08:00", null));
	}

	// Testes com cadastramento de locais

	@Test
	public void cadastraLocalTest() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutores.consultaLocal("joao@silva", "UFCG"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestEmailInvalido() {
		tutores.cadastraLocal("joao2silva", "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestEmailVazio() {
		tutores.cadastraLocal("  ", "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestEmailNulo() {
		tutores.cadastraLocal(null, "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraLocalTestLocalVazio() {
		tutores.cadastraLocal("joao@silva", " ");
	}

	@Test(expected = NullPointerException.class)
	public void cadastraLocalTestLocalNulo() {
		tutores.cadastraLocal("joao@silva", null);
	}

	// Testes para consultar horarios

	@Test
	public void consultaHorarioTestHorarioCadastrado() {
		tutores.cadastraHorario("mikael@amaral", "10:00", "seg");
		assertTrue(tutores.consultaHorario("mikael@amaral", "10:00", "seg"));
	}

	@Test()
	public void consultaHorarioTestHorarioNaoCadastrado() {
		tutores.cadastraHorario("joao@silva", "10:00", "seg");
		tutores.consultaHorario("joao@silva", "12:00", "seg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestEmailInvalido() {
		tutores.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutores.consultaHorario("mikael#amaral", "10:00", "seg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestEmailVazio() {
		tutores.cadastraHorario("joao@silva", "10:00", "seg");
		tutores.consultaHorario(" ", "10:00", "seg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestEmailNulo() {
		tutores.cadastraHorario("joao@silva", "10:00", "seg");
		tutores.consultaHorario(null, "10:00", "seg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestHorarioVazio() {
		tutores.cadastraHorario("joao@silva", "10:00", "seg");
		tutores.consultaHorario("joao@silva", " ", "seg");
	}

	@Test(expected = NullPointerException.class)
	public void consultaHorarioTestHorarioNulo() {
		tutores.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutores.consultaHorario("mikael@amaral", null, "seg");
	}

	@Test
	public void consultaHorarioTestDiaNaoCadastrado() {
		tutores.cadastraHorario("mikael@amaral", "10:00", "terc");
		assertTrue(tutores.consultaHorario("mikael@amaral", "10:00", "seg") == false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaHorarioTestDiaVazio() {
		tutores.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutores.consultaHorario("mikael@amaral", "10:00", " ");
	}

	@Test(expected = NullPointerException.class)
	public void consultaHorarioTestDiaNulo() {
		tutores.cadastraHorario("mikael@amaral", "10:00", "seg");
		tutores.consultaHorario("mikael@amaral", "10:00", null);
	}

	// Testes para consultar locais

	@Test
	public void consultaLocalTest() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutores.consultaLocal("joao@silva", "UFCG"));
	}

	@Test
	public void consultaLocalTestLocalNaoCadastrado() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutores.consultaLocal("joao@silva", "UEPB") == false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaLocalTestTutorNaoCadastrado() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		tutores.consultaLocal("jose@silva", "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaLocalTestEmailInvalido() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		tutores.consultaLocal("jose2silva", "UFCG");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaLocalTestEmailVazio() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutores.consultaLocal("    ", "UFCG"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaLocalTestEmailNulo() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		assertTrue(tutores.consultaLocal(null, "UFCG"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaLocalTestLocalVazio() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		tutores.consultaLocal("joao@silva", "            ");
	}

	@Test(expected = NullPointerException.class)
	public void consultaLocalTestLocalNulo() {
		tutores.cadastraLocal("joao@silva", "UFCG");
		tutores.consultaLocal("joao@silva", null);
	}

}
