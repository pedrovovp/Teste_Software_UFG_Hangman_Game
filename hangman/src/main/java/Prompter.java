import java.io.Console;

public class Prompter {
	private Game mGame;

	public Prompter(Game g){
		mGame = g;
	}

	public void play(){
		while(mGame.getRemainingTries() >0 && !mGame.isSolved()){
			displayProgress();
			promptForGuess();
		}

		if(mGame.isSolved()){
			System.out.printf(mGame.getAnswer() + "\nCongralutions you have won with %d tries left\n",
			mGame.getRemainingTries() );
		} else {
			System.out.printf("Bummer the word was %s :(\n",mGame.getAnswer() );
		}
	}

	public boolean promptForGuess() {
		Console console = System.console();
		boolean isHit= false;
		boolean validateGuess= false;

		while(!validateGuess){
			String guessString=console.readLine("Enter a character: ");
					
			try{
				isHit=mGame.guess(guessString);
				validateGuess=true;
			} catch(IllegalArgumentException e){
				console.printf("%s Pls try again\n", e.getMessage());

			}

		}
		

		return isHit;
	}
	

	public void displayProgress(){
		System.out.printf("You have %d Tries to solve this: %s\n",
			mGame.getRemainingTries(),
			mGame.getCurrentProgress());
	}
}