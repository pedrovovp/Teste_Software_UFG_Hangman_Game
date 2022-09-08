import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.*;

public class ValidaHangman {
	Game game;
	String lastLetter;

	@Given("o jogo recebe a palavra {string} para ser adivinhada")
	public void o_jogo_recebe_a_palavra_para_ser_adivinhada(String string) {
	    game = new Game(string);
	    
	}
	
	@When("o jogador insere a letra {string}")
	public void o_jogador_insere_a_letra(String letter) {
	    this.lastLetter = letter;
		try {
	    	game.guess(letter);
	    } catch(Exception e) { }
	}

	@Then("o jogo exibe seu estado: {int} tentativas restantes para resolver: {string}")
	public void o_jogo_exibe_seu_estado_tentativas_restantes_para_resolver(int remainingTries, String currentProgress) {
	    assertEquals(remainingTries, game.getRemainingTries());
	    assertEquals(currentProgress, game.getCurrentProgress());
	}
	
	@Then("o jogo informa que a letra ja foi adivinhada")
	public void o_jogo_informa_que_a_letra_ja_foi_adivinhada() {
	    try {
	    	game.guess(lastLetter);
	    } catch(Exception e) {
	    	assertEquals(e.getMessage(), lastLetter +" Already been Guessed!\n");
	    	assertEquals(e.getClass(), IllegalArgumentException.class);
	    }
	}
	
	@Then("o jogo pede para que o jogador envie uma letra")
	public void o_jogo_pede_para_que_o_jogador_envie_uma_letra() {
		try {
	    	game.guess(lastLetter);
	    } catch(Exception e) {
	    	assertEquals(e.getMessage(), "Input A Letter");
	    	assertEquals(e.getClass(), IllegalArgumentException.class);
	    }
	}
	
	@Then("o jogo informa que nenhuma letra foi enviada")
	public void o_jogo_informa_que_nenhuma_letra_foi_enviada() {
		try {
	    	game.guess(lastLetter);
	    } catch(Exception e) {
	    	assertEquals(e.getMessage(), "No Letter Found");
	    	assertEquals(e.getClass(), IllegalArgumentException.class);
	    }
	}


	@Then("O jogador vence o jogo, com {int} tentativas restantes")
	public void o_jogador_vence_o_jogo_com_tentativas_restantes(int remainingTries) {
		assertEquals(true, game.isSolved());
		assertEquals(remainingTries, game.getRemainingTries());
	}
	

	
	@Then("O jogador perde o jogo")
	public void o_jogador_perde_o_jogo() {
		assertEquals(false, game.isSolved());
		assertEquals(0, game.getRemainingTries());
	}
}
