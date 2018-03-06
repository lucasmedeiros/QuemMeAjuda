package ajuda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AjudaPresencialTest {

	private AjudaPresencial ajuda;
	
	@Before
	public void setUp(){
		this.ajuda = new AjudaPresencial(1, "123", "Laboratorio de Programacao 2", "14:00", "Segunda", "CAA");
	}

	// Testes de Construtor
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void disciplinaVazia() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", " ", "14:00", "Quarta", "BG");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void disciplinaNula() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", null, "14:00", "Quarta", "BG");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void horarioVazio() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", "P2", "  ", "Quarta", "BG");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void horarioNulo() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", "P2", null, "Quarta", "BG");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void DiaVazio() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", "P2", "14:00", "  ", "BG");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void DiaNulo() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", "P2", "14:00", null, "BG");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void localVazio() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", "P2", "14:00", "Quarta", "   ");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void localNulo() {
		AjudaPresencial ajuda = new AjudaPresencial(1,"1", "P2", "14:00", "Quarta", null);
	}
	
	// Testes de Consulta
	
	@Test
	public void matriculaCorreta() {
		String mensagem = "Esperando que as matriculas sejam iguais";
		assertEquals(mensagem, "123", this.ajuda.getTutor());
	}
	
	@Test
	public void disciplinaCorreta() {
		String mensagem = "Esperando que as disciplinas sejam iguais";
		assertEquals(mensagem, "Laboratorio de Programacao 2", this.ajuda.getInfo("disciplina"));
	}
	
	@Test
	public void diaCorreto() {
		String mensagem = "Esperando que os dias sejam iguais";
		assertEquals(mensagem, "Segunda", this.ajuda.getInfo("dia"));
	}
	
	@Test
	public void horarioCorreto() {
		String mensagem = "Esperando que os horarios sejam iguais";
		assertEquals(mensagem, "14:00", this.ajuda.getInfo("horario"));
	}
	
	@Test
	public void localCorreto() {
		String mensagem = "Esperando que os locais sejam iguais";
		assertEquals(mensagem, "CAA", this.ajuda.getInfo("localinteresse"));
	}
	
	@Test(expected = NullPointerException.class)
	public void atributoNulo() {
		this.ajuda.getInfo(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void atributoVazio() {
		this.ajuda.getInfo("   ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void atributoNaoEncontrado() {
		this.ajuda.getInfo("dinheiro");
	}

}
