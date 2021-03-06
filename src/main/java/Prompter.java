import java.util.Scanner;

public class Prompter {
    private Jar jar;
    public Prompter(Jar jar){
        this.jar = jar;
    }
    public void promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        String newGuess = scanner.nextLine();
        try {
            jar.applyGuess(newGuess);
        }catch(IllegalArgumentException iae){
            System.out.printf(iae.getMessage() + "%n");
        }
    }
    public void displayStartingPrompt() {
        System.out.printf("PLAYER%n================%n" +
                "How many " +jar.getItemName() +" are in the jar. Your guess should be between 1 and " + jar.getMaximumItems() + ".%n");
    }
    public void displayHint(){
        /* display most recent hint if it exists. */
        if(jar.getNumberOfAttempts() > 0 && !jar.gameIsWon()) {
            System.out.println(jar.getHint());
        }
    }
    public void displayOutcome(){
        /* I admit that I am unsure of the best way to handle string plurality */
        if(jar.getNumberOfAttempts() > 1){
            System.out.printf("Congratulations. %d was the correct number. You guessed the correct number in %d attempts" + ".", jar.getNumberOfItems(), jar.getNumberOfAttempts() );
        }else{
            System.out.printf("Congratulations. %d was the correct number. You guessed the correct number in %d attempt" + ".", jar.getNumberOfItems(), jar.getNumberOfAttempts());
        }

    }
}
