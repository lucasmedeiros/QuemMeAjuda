package general;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaixaTest {
	Caixa c1 = new Caixa();

	@Test
	public void testTotalDinheiroSistema() {
		c1.doar(1000, 4.6);
		assertTrue(c1.TotalDinheiroSistema() == 91);
	}

	@Test
	public void testDoarTutor() {
		c1.doar(1000, 3.5);
		assertTrue(c1.TotalDinheiroSistema() == 200);
	}
	
	@Test
	public void testDoarTop() {
		c1.doar(1000, 4.7);
		assertTrue(c1.TotalDinheiroSistema() == 81);
	}
	
	@Test
	public void testDoarAprendiz() {
		c1.doar(1000, 2.4);
		assertTrue(c1.TotalDinheiroSistema() == 660);
	}
	

}
