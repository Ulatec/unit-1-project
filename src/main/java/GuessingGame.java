import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        boolean validName = false;
        boolean validInt = false;
        Scanner scanner = new Scanner(System.in);
        String nameOfItems;
        String maximumItems;

        Jar jar = new Jar("dick", "8");
        System.out.printf("Jar has %s %s", jar.getNumberOfItems(), jar.getItemType());
        boolean didIWin = false;
        boolean isValid = false;
        while(!jar.gameIsWon()){
            do{

            }while();
            try{
                String newGuess = scanner.nextLine();
                didIWin = jar.applyGuess(newGuess);
            }catch(){

            }
            if(normalizedGuess > maxItems){
                throw new IllegalArgumentException("Greater than maxItems! Try again");
            }

        }
        System.out.println("U WIN");
    }
}
