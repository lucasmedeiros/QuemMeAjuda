package tests;

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
	
	@Test
	public void testHashCode() {
		assertTrue(al1.hashCode() == al3.hashCode());
		assertTrue(al1.hashCode() != al2.hashCode());
	}

	@Test
	public void testGerarDetalhes() {
		String teste = "117110637 - matias - 270 - matias@mineiro";
		String teste2 = "117110640 - mikael - 271 - 99872450 - mikael@amaral";
		assertEquals(al3.gerarDetalhes(),teste);
		assertEquals(al2.gerarDetalhes(),teste2);
	}

	@Test
	public void testGetMatricula() {
		assertEquals(al1.getMatricula(),"117110637");
		assertEquals(al2.getMatricula(),"117110640");
		assertNotEquals(al3.getMatricula(),"117110638");
	}

	@Test
	public void testGetEmail() {
		assertEquals(al1.getEmail(),"joao@silva");
		assertNotEquals(al2.getEmail(),"mikael@brasileiro");
		assertEquals(al3.getEmail(),"matias@mineiro");
	}

	@Test
	public void testGetTelefone() {
		assertEquals(al1.getTelefone(), "");
		assertEquals(al2.getTelefone(),"99872450");
		assertNotEquals(al3.getTelefone(),"8746161616");
	}

	@Test
	public void testGetNome() {
		assertEquals(al1.getNome(),"joao");
		assertEquals(al2.getNome(),"mikael");
		assertNotEquals(al3.getNome(),"Matias");
	}

	@Test
	public void testGetNota() {
		assertTrue(al1.getNota() == 5);
	}

	@Test
	public void testGetCursoId() {
		assertTrue(al1.getCursoId() == 270);
		assertTrue(al2.getCursoId() == 271);
	}

	@Test
	public void testEqualsObject() {
		assertNotEquals(al1,al2);
		assertEquals(al1,al3);
	}

	@Test
	public void testCompareTo() {
		assertTrue(al1.compareTo(al3) < 0);
		assertTrue(al2.compareTo(al3) > 0);
	}

}
