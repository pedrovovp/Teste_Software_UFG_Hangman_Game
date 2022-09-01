import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// Mutation Test and All Branches Criteria
public class GameTest {
	
	Game game;
	Game game2;
	
	@Before
	public void inicializa() {
		game = new Game("resposta");
		game2 = new Game("世界");
	}
	
	@Test
	public void test01() {
		boolean resultado = game.guess('r');
		assertEquals(true, resultado);
		
		resultado = game2.guess('界');
		assertEquals(true, resultado);
	}
	
	@Test
	public void test02() {
		boolean resultado = game.guess('l');
		assertEquals(false, resultado);
		
		resultado = game2.guess('セ');
		assertEquals(false, resultado);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test03() {
		game.guess("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test03_2() {
		game.guess(null);
	}

	@Test
	public void test04() {
		boolean resultado = game.guess("l");
		assertEquals(false, resultado);
		
		resultado = game2.guess("セ");
		assertEquals(false, resultado);
	}
	
	@Test
	public void test05() {
		game.guess('s');
		String resultado = game.getCurrentProgress(); 
		assertEquals("--s--s--", resultado);
		
		game2.guess('世');
		resultado = game2.getCurrentProgress();
		assertEquals("世-", resultado);
	}
	
	@Test
	public void test06() {
		game.guess('l');
		int resultado = game.getRemainingTries(); 
		assertEquals(5, resultado);
	}

	@Test
	public void test07() {
		game.guess('r');
		game.guess('e');
		game.guess('s');
		game.guess('p');
		game.guess('o');
		game.guess('t');
		game.guess('a');
		boolean resultado = game.isSolved(); 
		assertEquals(true, resultado);
		
		game2.guess('界');
		game2.guess('世');
		resultado = game2.isSolved();
		assertEquals(true, resultado);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		game.guess('1');
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test09() {
		game.guess('r');
		game.guess('r');
	}
	
	@Test
	public void test10() {
		boolean resultado = game.guess("r");
		assertEquals(true, resultado);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test11() {
		game.guess('l');
		game.guess('l');
	}
	
	@Test
	public void test12() {
		game.guess('r');
		game.guess('e');
		game.guess('s');
		game.guess('p');
		game.guess('o');
		game.guess('t');
		boolean resultado = game.isSolved(); 
		assertEquals(false, resultado);
		
		game2.guess('世');
		resultado = game2.isSolved();
		assertEquals(false, resultado);
	}
	
	@Test
	public void test13() {
		String resultado = game.getAnswer();
		assertEquals("resposta", resultado);
		
		resultado = game2.getAnswer();
		assertEquals("世界", resultado);
	}
}