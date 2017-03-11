import java.util.Random;

public class Jar {
    private String jarItem;
    private int numberOfItems;
    private boolean numberFound = false;
    private int numberOfGuesses;
    private int maximumItems;
    private String hint;
    public Jar(String jarItem, int maxItemsAllowed){

        this.jarItem = jarItem;
        this.maximumItems = maxItemsAllowed;
        try{
            fillWithRandomNumberOfItems(maxItemsAllowed);
        }catch(IllegalArgumentException iae){
            System.out.println("You must initialize the jar with a positive number of items.");
        }
    }
    private void fillWithRandomNumberOfItems(int maxItemsAllowed){
            Random random = new Random();
            this.numberOfItems = random.nextInt(maxItemsAllowed) + 1;
    }

    private boolean stringToIntegerValidation(String string){
        boolean validGuess = true;
        for(char c : string.toCharArray()){
            if(! Character.isDigit(c)){
                validGuess = false;
            }
        }

        return validGuess;
    }

    public boolean applyGuess(String guess){
        if(!stringToIntegerValidation(guess)){
            throw new IllegalArgumentException("You must only use digits!");
        }

        int validGuess = Integer.parseInt(guess);
        if(validGuess > maximumItems || validGuess < 1){
            throw new IllegalArgumentException("Your guess must be between 1 and " + maximumItems + ".");
        }
        if (validGuess == numberOfItems) {
            numberFound = true;
        }
        setHint(validGuess);
        numberOfGuesses++;
        return numberFound;
    }

    private void setHint(int validGuess){
        if(validGuess > numberOfItems && validGuess != numberOfItems){
            hint = Integer.toString(validGuess) + " is too high.";
        }else{
            hint = Integer.toString(validGuess) + " is too low.";
        }
    }

    public boolean gameIsWon(){
        return numberFound;
    }
    public int getNumberOfAttempts(){
        return numberOfGuesses;
    }
    public int getNumberOfItems(){
        return numberOfItems;
    }
    public int getMaximumItems(){
        return maximumItems;
    }
    public String getItemName(){
        return jarItem;
    }
    public String getHint(){
        return hint;
    }
}