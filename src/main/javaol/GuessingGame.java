import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        boolean validName = false;
        boolean validInt = false;
        Scanner scanner = new Scanner(System.in);
        String nameOfItems;
        String maximumItems;

        do{
            System.out.print("What type of item");
            nameOfItems = scanner.nextLine();
            if(nameOfItems.length() > 0){
                validName = true;
            }
        }while(!validName);
        do{
            System.out.printf("maximum amount of %s", nameOfItems);
            maximumItems = (scanner.nextLine());
            try{
                if( Integer.parseInt(maximumItems) <= 0){
                    throw new IllegalArgumentException("That was not a valid number! catch");
                }else {
                    validInt = true;
                }
            }catch(IllegalArgumentException iae){
                System.out.println("That was not a valid number! catch");
            }
        }while(!validInt);


        Jar jar = new Jar(nameOfItems, maximumItems);
        boolean didIWin = false;
        do{

            try{
                System.out.printf("Guess a number! You have attempted %d times: \r\n" , jar.getNumberOfAttempts());
                String entry = scanner.nextLine();
                int guess = Integer.parseInt(entry);
                didIWin = jar.applyGuess(guess);
            }catch(IllegalArgumentException iae){
                System.out.println("That was not a valid number!");
            }
        }while(!didIWin);
        //System.out.printf("Jar has %s %ss", jar.getNumberOfItems(), jar.getItemType());
    }
}
