import java.util.Random;

public class Jar {
    private String jarItem;
    private int numberOfItems;
    private boolean numberFound = false;
    private int numberOfGuesses;
    private int maxItems;
    private String guesses;
    public Jar(String jarItem, String maxItemsAllowed){
        Random random = new Random();
        this.guesses = "";
        this.jarItem = jarItem;

        try {
            int normalizedMaxItemsAllowed = convertNumber(maxItemsAllowed);
            this.numberOfItems = random.nextInt(normalizedMaxItemsAllowed);
            this.maxItems = normalizedMaxItemsAllowed;
        }catch(IllegalArgumentException iae){
            System.out.println("Error: " + iae.getMessage());
        }
        System.out.println("Jar created!");
    }
    public boolean applyGuess(String guess){
        int normalizedGuess = convertNumber(guess);
        System.out.println(maxItems);
        System.out.println(guesses);

        try {
            if (normalizedGuess == numberOfItems) {
                numberFound = true;
            } else {
                guesses += guess;
            }
        }catch(IllegalArgumentException iae){

        }
        numberOfGuesses++;
        return numberFound;
    }
    private int convertNumber(String string){
        int newint = Integer.parseInt(string);
        return newint;
    }
    public boolean gameIsWon(){
        return numberFound;
    }
    public int getNumberOfAttempts(){
        return numberOfGuesses;
    }
    public String getNumberOfItems(){
        return Integer.toString(numberOfItems);
    }
    public String getItemType(){
        return jarItem;
    }
}