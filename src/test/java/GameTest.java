import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game game;
	Game game2;
	
	@Before
	public void inicializa() {
		game = new Game("resposta");
		game2 = new Game("世界");
	}
	
	
	@Test
	public void case01_01() {	
		boolean resultado = game.guess("r");
		assertEquals(true, resultado);
	}
	
	@Test
	public void case01_02() {
		boolean resultado = game.guess("l");
		assertEquals(false, resultado);
		
		resultado = game2.guess("セ");
		assertEquals(false, resultado);
	}
	
	@Test()
	public void case01_03() {
		boolean resultado = game.guess("relevo");
		assertEquals(true, resultado);
		
		resultado = game2.guess("セ自分");
		assertEquals(false, resultado);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void case01_04() {
		game.guess("");
	}
	
	@Test(expected = NullPointerException.class)
	public void case01_05() {
		game.guess(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void case01_06() {
		game.guess("🤨️");
	}
	
	
	@Test
	public void case02_01() {
		boolean resultado = game.guess('r');
		assertEquals(true, resultado);
		
		resultado = game2.guess('界');
		assertEquals(true, resultado);
	}
	
	@Test
	public void case02_02() {
		boolean resultado = game.guess('l');
		assertEquals(false, resultado);
		
		resultado = game2.guess('セ');
		assertEquals(false, resultado);
	}
	
	@Test(expected = NullPointerException.class)
	public void case02_03() {
		game.guess(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void case02_04() {
		game.guess('l');
		game.guess('l');
	}

	@Test(expected = IllegalArgumentException.class)
	public void case02_05() {
		game.guess('1');
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void case02_06() {
		game.guess('r');
		game.guess('r');
	}
	
	@Test
	public void case03() {
		game.guess('r');
		game.guess('s');
		String resultado = game.getCurrentProgress(); 
		assertEquals("r-s--s--", resultado);
		
		game2.guess('世');
		resultado = game2.getCurrentProgress();
		assertEquals("世-", resultado);
	}
	
	@Test
	public void case04() {
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
	
	@Test
	public void case04_02() {
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
	public void case05() {
		String resultado = game.getAnswer();
		assertEquals("resposta", resultado);
		
		resultado = game2.getAnswer();
		assertEquals("世界", resultado);
	}
	
	// Análise de valor limite
	@Test
	public void case06_01() {
		game.guess('r');
		int resultado = game.getRemainingTries(); 
		assertEquals(6, resultado);
	}	

	@Test
	public void case06_02() {
		game.guess('l');
		int resultado = game.getRemainingTries(); 
		assertEquals(5, resultado);
	}	
	
	@Test
	public void case06_03() {
		game.guess('l');
		game.guess('h');
		game.guess('k');
		game.guess('w');
		game.guess('v');
		int resultado = game.getRemainingTries(); 
		assertEquals(1, resultado);
	}	
	
	@Test
	public void case06_04() {
		game.guess('l');
		game.guess('h');
		game.guess('k');
		game.guess('w');
		game.guess('v');
		game.guess('ç');
		int resultado = game.getRemainingTries(); 
		assertEquals(0, resultado);
	}	
}