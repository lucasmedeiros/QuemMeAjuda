package tutor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tutor.Tutor;

public class TutorTest {

	private Tutor tutor;

	@Before
	public void setUp() throws Exception {
		this.tutor = new Tutor("Programacao 2", 5);
		this.tutor.adicionarHorario("Quarta-Feira", "8:30 - 10:30");
	}

	// Testes de Construtor

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void proficienciaMaiorQueCinco() {
		Tutor tutorTeste = new Tutor("Laboratorio de Programacao 2", 6);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void proficienciaZero() {
		Tutor tutorTeste = new Tutor("Laboratorio de Programacao 2", 0);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void proficienciaNegativa() {
		Tutor tutorTeste = new Tutor("Laboratorio de Programacao 2", -1);
	}

	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void disciplinaNula() {
		Tutor tutorTeste = new Tutor(null, 5);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void disciplinaVazia() {
		Tutor tutorTeste = new Tutor("", 5);
	}

	@Test
	public void notaCorreta() {
		String mensagem = "Esperando que a nota padrao esteja correta";
		assertEquals(mensagem, 4, this.tutor.getNotaTutor());
	}

	@Test
	public void proficienciaCorreta() {
		String mensagem = "Esperando que a proficiencia cadastrada esteja correta";
		assertEquals(mensagem, 5, this.tutor.getProficiencia());
	}

	// Teste de Dinheiro

	@Test
	public void dinheiroAdicionado() {
		String mensagem = "Esperando que o dinheiro do tutor seja 5";
		this.tutor.adicionarDinheiro(5);
		assertEquals(mensagem, 5, tutor.getDinheiro());
	}

	// Testes de Horarios e Locais

	@Test
	public void localAdicionado() {
		String mensagem = "Esperando que o local conste na lista";
		String local = "CAA = 404";
		this.tutor.adicionarLocal(local);
		assertTrue(mensagem, this.tutor.consultarLocal(local));
	}

	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void localNulo() {
		String mensagem = "Esperando que seja lancada uma NullPointerException";
		this.tutor.adicionarLocal(null);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void localVazio() {
		String mensagem = "Esperando que seja lancada uma IllegalArgumentException";
		this.tutor.adicionarLocal("");
	}

	@Test
	public void localNaoAdicionado() {
		String mensagem = "Esperando que o local nao conste na lista";
		assertFalse(mensagem, this.tutor.consultarLocal("RE - LCC1"));
	}

	@Test
	public void horarioAdicionado() {
		String mensagem = "Esperando que o horario conste no mapa";
		String dia = "Segunda-Feira";
		String horario = "13:00 - 14:00";
		this.tutor.adicionarHorario(dia, horario);
		assertTrue(mensagem, this.tutor.consultarHorario(dia, horario));
	}

	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void horarioNulo() {
		String mensagem = "Esperando que seja lancada uma NullPointerException";
		String dia = "Segunda-Feira";
		this.tutor.adicionarHorario(dia, null);
	}

	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void diaNulo() {
		String mensagem = "Esperando que seja lancada uma NullPointerException";
		String horario = "15:00 - 18:00";
		this.tutor.adicionarHorario(null, horario);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void horarioVazio() {
		String mensagem = "Esperando que seja lancada uma IllegalArgumentException";
		String dia = "Segunda-Feira";
		this.tutor.adicionarHorario(dia, "");
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void diaVazio() {
		String mensagem = "Esperando que seja lancada uma IllegalArgumentException";
		String horario = "14:00 - 18:00";
		this.tutor.adicionarHorario("", horario);
	}

	@Test
	public void diaNaoAdicionado() {
		String mensagem = "Esperando que o dia nao conste no mapa";
		String dia = "Terca-Feira";
		String horario = "15:30 - 16:30";
		assertFalse(mensagem, this.tutor.consultarHorario(dia, horario));
	}

	@Test
	public void horarioNaoAdicionado() {
		String mensagem = "Esperando que a hora para este dia nao conste no mapa";
		String dia = "Quarta-Feira";
		String horario = "15:30 - 16:30";
		assertFalse(mensagem, this.tutor.consultarHorario(dia, horario));
	}

}
