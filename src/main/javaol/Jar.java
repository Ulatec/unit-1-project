import java.util.Random;

public class Jar {
    private String jarItem;
    private int numberOfItems;
    private boolean numberFound = false;
    private int numberOfGuesses;
    private int maxItems;
    private String guesses;
    public Jar(String jarItem, int maxItemsAllowed){
        Random random = new Random();
        this.jarItem = jarItem;
        this.maxItems = maxItemsAllowed;
        this.numberOfItems = random.nextInt(maxItemsAllowed);
        this.guesses = "";
        System.out.println("Jar created!");
    }
    public Jar(String jarItem, String maxItemsAllowed){
        Random random = new Random();
        this.guesses = "";
        this.jarItem = jarItem;

        try {
            int normalizedMaxItemsAllowed = Integer.parseInt(maxItemsAllowed);
            this.numberOfItems = random.nextInt(normalizedMaxItemsAllowed);
            this.maxItems = normalizedMaxItemsAllowed;
        }catch(IllegalArgumentException iae){
            System.out.println("Error: " + iae.getMessage());
        }
        //System.out.println("Jar created!");
    }
    public boolean applyGuess(int guess){
        System.out.println(maxItems);
        System.out.println(guesses);
        try {
            if(guess > maxItems){
                throw new IllegalArgumentException("Greater than maxItems! Try again");
            }
            if (guess == numberOfItems) {
                numberFound = true;
            } else {
                guesses += guess;
            }
        }catch(IllegalArgumentException iae){

        }
        numberOfGuesses++;
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