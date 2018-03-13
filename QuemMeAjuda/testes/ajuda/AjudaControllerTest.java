package ajuda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ajuda.AjudaController;

public class AjudaControllerTest {
	
	private AjudaController controllerAjuda;
	
	public AjudaControllerTest() {}
	
	@Before
	public void setUp() {
		this.controllerAjuda = new AjudaController();
	}
	
	@Test(expected = NullPointerException.class)
	public void pedirAjudaOnlineDisciplinaNula() {
		this.controllerAjuda.pedirAjudaOnline("1", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaOnlineDisciplinaVazia1() {
		this.controllerAjuda.pedirAjudaOnline("1", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaOnlineDisciplinaVazia2() {
		this.controllerAjuda.pedirAjudaOnline("1", "      ");
	}
	
	@Test
	public void pedirAjudaOnlineCorreta() {
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		assertEquals(3, this.controllerAjuda.pedirAjudaOnline("1", "p2"));
	}
	
	@Test(expected = NullPointerException.class)
	public void pedirAjudaPresencialDisciplinaNula() {
		this.controllerAjuda.pedirAjudaPresencial("1", null, "15:00", "seg", "lcc3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialDisciplinaVazia1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "", "15:00", "seg", "lcc3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialDisciplinaVazia2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "    ", "15:00", "seg", "lcc3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialHorarioVazio1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "", "Quarta", "BG");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialHorarioVazio2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "   ", "Quarta", "BG");
	}
	
	@Test(expected = NullPointerException.class)
	public void pedirAjudaPresencialHorarioNulo() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", null, "Quarta", "BG");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialDiaVazio1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "", "BG");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialDiaVazio2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "    ", "BG");
	}
	
	@Test(expected = NullPointerException.class)
	public void pedirAjudaPresencialDiaNulo() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", null, "BG");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialLocalVazio1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pedirAjudaPresencialLocalVazio2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "   ");
	}
	
	@Test(expected = NullPointerException.class)
	public void pedirAjudaPresencialLocalNulo() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", null);
	}
	
	@Test
	public void pedirAjudaPresencialCorreta() {
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		assertEquals(2, this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testInfoAjudaAtributoNulo() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.getInfoAjuda(null, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInfoAjudaAtributoVazio1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.getInfoAjuda("", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInfoAjudaAtributoVazio2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.getInfoAjuda("    ", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInfoAjudaParametroInvalidoParaAjudaOnline1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.getInfoAjuda("horario", 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInfoAjudaParametroInvalidoParaAjudaOnline2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.getInfoAjuda("alalala", 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInfoAjudaParametroInvalidoParaAjudaPresencial1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.getInfoAjuda("uashaushaus", 1);
	}
	
	@Test
	public void testInfoAjuda1() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "IC");
		assertEquals("P2", this.controllerAjuda.getInfoAjuda("disciplina", 1));
	}
	
	@Test
	public void testInfoAjuda2() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "IC");
		assertEquals("IC", this.controllerAjuda.getInfoAjuda("disciplina", 2));
	}
	
	@Test
	public void testInfoAjuda3() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "IC");
		assertEquals("14:00", this.controllerAjuda.getInfoAjuda("horario", 1));
	}
	
	@Test
	public void testInfoAjuda4() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "IC");
		assertEquals("LCC3", this.controllerAjuda.getInfoAjuda("localinteresse", 1));
	}
	
	@Test
	public void testInfoAjuda5() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "IC");
		assertEquals("Quarta", this.controllerAjuda.getInfoAjuda("dia", 1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testPegarTutorApostaNaoCadastrada() {
		this.controllerAjuda.pedirAjudaPresencial("1", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("1", "p2");
		this.controllerAjuda.pegarInfoTutor(3);
	}
	
	@Test
	public void testPegarTutorAjudaOnline() {
		this.controllerAjuda.pedirAjudaPresencial("140", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("35", "P2");
		assertEquals("Tutor - 35, disciplina - P2", this.controllerAjuda.pegarInfoTutor(2));
	}
	
	@Test
	public void testPegarTutorAjudaPresencial() {
		this.controllerAjuda.pedirAjudaPresencial("140", "P2", "14:00", "Quarta", "LCC3");
		this.controllerAjuda.pedirAjudaOnline("35", "p2");
		assertEquals("Tutor - 140, horario - 14:00, dia - Quarta, local - LCC3, disciplina - P2", this.controllerAjuda.pegarInfoTutor(1));
	}
	
	@Test
	public void salvarTest() {
		this.controllerAjuda.salvar();
	}
	
	@Test
	public void carregarTest() {
		AjudaController controle = new AjudaController();
		controle.pedirAjudaOnline("35", "p2");
		controle.salvar();
		String disciplina = controle.getInfoAjuda("disciplina", 1);
		controle.carregar();
		assertEquals(controle.getInfoAjuda("disciplina", 1), disciplina);
	}
	
	@Test(expected = NullPointerException.class)
	public void limparTest() {
		this.controllerAjuda.salvar();
		this.controllerAjuda.limpar();
		this.controllerAjuda.getInfoAjuda("disciplina", 1);
	}
}