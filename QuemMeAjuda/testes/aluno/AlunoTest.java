package aluno;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aluno.Aluno;


public class AlunoTest {
	Aluno al1,al2,al3;

	@Before
	public void setUp() throws Exception{
		al1 = new Aluno("joao", "117110637", "joao@silva", 270, "");
		al2 = new Aluno("mikael", "117110640", "mikael@amaral", 271, "99872450");
		al3 = new Aluno("matias", "117110637", "matias@mineiro", 270, "");
	}

	// testes do construtor
	
	@Test(expected= IllegalArgumentException.class)
	public void AlunoTestNomeVazio() {
		al1 = new Aluno(" ", "117110637", "jonas@mikeias", 870,"99872450");
	}
	
	@Test(expected= NullPointerException.class)
	public void AlunoTestNomeNulo() {
		al1 = new Aluno(null, "117110637", "jonas@mikeias", 870,"99872450");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void AlunoTestMatriculaVazia() {
		al1 = new Aluno("jonas", "  ", "jonas@mikeias", 870,"99872450");
	}
	
	@Test(expected= NullPointerException.class)
	public void AlunoTestMatriculaNula() {
		al1 = new Aluno("jonas", null, "jonas@mikeias", 870,"99872450");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void AlunoTestEmailInvalido() {
		al1 = new Aluno("jonas", "117110637", "jonas2mikeias", 870,"99872450");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void AlunoTestEmailVazio() {
		al1 = new Aluno("jonas", "117110637", "  ", 870,"99872450");
	}
	
	@Test(expected= NullPointerException.class)
	public void AlunoTestEmailNulo() {
		al1 = new Aluno("jonas", "117110637", null, 870,"99872450");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void AlunoTestCursoIdNegativo() {
		al1 = new Aluno("jonas", "117110637", "jonas@mikeias", -10,"99872450");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void AlunoTestCursoIdZerado() {
		al1 = new Aluno("jonas", "117110637", "jonas@mikeias", 0,"99872450");
	}
	
	// Testes Gerais 
	
	@Test
	public void HashCodeTest() {
		assertTrue(al1.hashCode() == al3.hashCode());
		assertTrue(al1.hashCode() != al2.hashCode());
	}

	@Test
	public void toStringTest() {
		String teste = "117110637 - matias - 270 - matias@mineiro";
		String teste2 = "117110640 - mikael - 271 - 99872450 - mikael@amaral";
		assertEquals(al3.toString(),teste);
		assertEquals(al2.toString(),teste2);
	}

	@Test
	public void getMatriculaTest() {
		assertEquals(al1.getMatricula(),"117110637");
		assertEquals(al2.getMatricula(),"117110640");
		assertNotEquals(al3.getMatricula(),"117110638");
	}

	@Test
	public void getEmailTest() {
		assertEquals(al1.getEmail(),"joao@silva");
		assertNotEquals(al2.getEmail(),"mikael@brasileiro");
		assertEquals(al3.getEmail(),"matias@mineiro");
	}

	@Test
	public void getTelefoneTest() {
		assertEquals(al1.getTelefone(), "");
		assertEquals(al2.getTelefone(),"99872450");
		assertNotEquals(al3.getTelefone(),"8746161616");
	}

	@Test
	public void getNomeTest() {
		assertEquals(al1.getNome(),"joao");
		assertEquals(al2.getNome(),"mikael");
		assertNotEquals(al3.getNome(),"Matias");
	}

	@Test
	public void getNotaTest() {
		assertTrue(al1.getNota() == 5);
	}

	@Test
	public void getCursoIdTest() {
		assertTrue(al1.getCursoId() == 270);
		assertTrue(al2.getCursoId() == 271);
	}

	@Test
	public void equalsObjectTest() {
		assertNotEquals(al1,al2);
		assertEquals(al1,al3);
	}

	@Test
	public void compareToTest() {
		assertTrue(al1.compareTo(al2) < 0);
		assertTrue(al2.compareTo(al3) > 0);
	}

}
