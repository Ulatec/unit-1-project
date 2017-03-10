import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        boolean validName = false;
        boolean validInt = false;
        boolean gameStarted = false;
        //String maxItems;
        String nameOfItems;
        String maximumItems;

        Scanner SetupScanner = new Scanner(System.in);
        System.out.print("What type of item");
        String jarItem = SetupScanner.nextLine();
        System.out.printf("maximum amount of %s", jarItem);
        int maxItems;
        maxItems = SetupScanner.nextInt();
        Jar jar = new Jar(jarItem, maxItems);

        //System.out.printf("Jar has %s %ss %n", jar.getNumberOfItems(), jar.getItemType());
        Prompter prompter = new Prompter(jar);
        prompter.displayPrompt();
        while(!jar.gameIsWon()){

            prompter.promptForGuess();
            prompter.displayHint();
        }
        prompter.displayOutcome();
    }
}
