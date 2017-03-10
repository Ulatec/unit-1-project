/**
 * Created by mark on 3/8/2017.
 */
import java.util.Scanner;

public class Prompter {
    private Jar jar;
    public Prompter(Jar jar){
        this.jar = jar;
    }


    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        String newGuess = scanner.nextLine();
        boolean guessResult = false;
        try {
            guessResult = jar.applyGuess(newGuess);
        }catch(IllegalArgumentException iae){
            System.out.printf(iae.getMessage());
        }
        return guessResult;
    }
    public void displayPrompt() {
            String progress = "How many " +jar.getItemType() +"%n" + " 1 and " + jar.getMaximumItems() + "%n";
        System.out.printf(progress);
    }
    public void displayHint(){
        if(jar.getNumberOfAttempts() > 0) {
            System.out.println(jar.getHint());
        }
    }
    public void displayOutcome(){
        if(jar.getNumberOfAttempts() > 1){
            System.out.printf("%d attempts %n", jar.getNumberOfAttempts());
        }else{
            System.out.printf("%d attempt %n", jar.getNumberOfAttempts());
        }

    }
}
