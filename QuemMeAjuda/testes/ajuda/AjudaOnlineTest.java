package ajuda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AjudaOnlineTest {

	private AjudaOnline ajuda;
	
	@Before
	public void setUp() {
		this.ajuda = new AjudaOnline("11111", "Progamacao 2");
	}

	// Testes de Construtor
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void disciplinaVazia() {
		AjudaOnline ajuda = new AjudaOnline("1112", "   ");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void disciplinaNula() {
		AjudaOnline ajuda = new AjudaOnline("1112", null);
	}
	
	// Testes de Consulta
	
	@Test
	public void disciplinaCorreta() {
		String mensagem = "Esperando que as disciplinas sejam iguais";
		assertEquals(mensagem, "Programacao 2", this.ajuda.getInfoAjuda("disciplina"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void atributoNaoEncontrado() {
		this.ajuda.getInfoAjuda("dinheiro");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void atributoVazio() {
		this.ajuda.getInfoAjuda("   ");
	}
	
	@Test(expected = NullPointerException.class)
	public void atributoNulo() {
		this.ajuda.getInfoAjuda(null);
	}
	
	@Test
	public void matriculaCorreta() {
		String mensagem = "Esperando que as matriculas sejam iguais";
		assertEquals(mensagem, "11111", this.ajuda.pegarTutor());
	}

}
