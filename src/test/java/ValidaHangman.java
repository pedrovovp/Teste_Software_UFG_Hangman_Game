import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.*;

public class ValidaHangman {
	Game game;
	String palavra;
	String tentativas;

	@Given("eu insiro uma palavra {string} para o outro jogador adivinhar")
	public void eu_insiro_uma_palavra_para_o_outro_jogador_adivinhar(String string) {
		game = new Game(string);
		palavra = string;
	}
	
	@When("ele insere varias letras {string},")
	public void ele_insere_varias_letras(String string) {
		tentativas = string;
	    for (char c : string.toCharArray()) {
	    	Boolean temLetra = palavra.indexOf((int) c) >= 0;
	    	assertEquals(temLetra, game.guess(c));
	    }
	}
	
	@Then("recebemos um retorno true {int}")
	public void recebemos_um_retorno_true(Integer int1) {
	    assertEquals(game.isSolved() && game.getRemainingTries() > 0, true);
	    assertEquals(palavra, game.getAnswer());
	    assertEquals(game.getRemainingTries() == int1, true);
	}

	@Then("recebemos um retorno false {int}")
	public void recebemos_um_retorno_false(Integer int1) {
	    assertEquals(game.isSolved(), false);
	    assertEquals(palavra, game.getAnswer());
	    assertEquals(game.getRemainingTries() == int1, true);
	}
}
