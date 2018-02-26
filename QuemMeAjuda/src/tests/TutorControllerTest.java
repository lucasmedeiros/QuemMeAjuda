package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aluno.Aluno;
import tutor.TutorController;

public class TutorControllerTest {

	private TutorController tutores;

	@Before
	public void setUp() throws Exception {
		
		Aluno aluno = new Aluno("joao", "117110637", "joao@silva", 270, "999491615");
		Aluno other = new Aluno("mikael", "117110640", "mikael@amaral", 271, "99872450");
		
		this.tutores.tornaTutor(aluno,"P2", 4);
		this.tutores.tornaTutor(other, "Calculo", 3);
	}
	
	//Testes de Listar aluno.
	@Test
	public void listaAlunoTest() {
		assertEquals(this.tutores.listarTutores(), "");
	}
	
	@Test
	public void 

}
