import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        boolean validInt = false;
        String nameOfItems;
        System.out.println("ADMINISTRATOR SETUP");
        System.out.println("================");
        Scanner gameSetupScanner = new Scanner(System.in);
        System.out.print("What type of item is in the jar: ");
        String jarItem = gameSetupScanner.nextLine();
        System.out.printf("What is the maximum amount of %s in the jar:", jarItem);

        //initialize with a default value, and use a do/while loop to protect against initializing the Jar with zero or negative item values.
        int maximumItems = 1;
        do{
            String maxItemsString = gameSetupScanner.nextLine();
            if(!(Integer.parseInt(maxItemsString) <= 0)) {
                maximumItems = Integer.parseInt(maxItemsString);
                validInt = true;
            }else{
                System.out.printf("Please use a positive non-zero integer to fill the jar with %s.", jarItem);
            }
        }while(!validInt);
        gameSetupScanner.close();
        Jar jar = new Jar(jarItem, maximumItems);
        Prompter prompter = new Prompter(jar);
        prompter.displayStartingPrompt();
        while(!jar.gameIsWon()){
            prompter.promptForGuess();
            prompter.displayHint();
        }
        prompter.displayOutcome();
    }
}
