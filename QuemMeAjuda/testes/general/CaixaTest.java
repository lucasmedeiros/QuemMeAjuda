package general;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaixaTest {
	Caixa c1 = new Caixa();

	@Test
	public void testTotalDinheiroSistema() {
		c1.doar(1000, 4.6);
		assertTrue(c1.TotalDinheiroSistema() == 90);
	}

	@Test
	public void testDoarTutor() {
		c1.doar(1000, 3.5);
		assertTrue(c1.TotalDinheiroSistema() == 199);
	}
	
	@Test
	public void testDoarTop() {
		c1.doar(1000, 4.7);
		assertTrue(c1.TotalDinheiroSistema() == 80);
	}
	
	@Test
	public void testDoarAprendiz() {
		c1.doar(1000, 2.4);
		assertTrue(c1.TotalDinheiroSistema() == 660);
	}
	
	@Test
	public void DoarEasyTest() {
		c1.doar(500, 4.52);
		System.out.println(c1.TotalDinheiroSistema());
	}

}
