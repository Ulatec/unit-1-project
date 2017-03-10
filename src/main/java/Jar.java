import java.util.Random;

public class Jar {
    private String jarItem;
    private int numberOfItems;
    private boolean numberFound = false;
    private int numberOfGuesses;
    private int maxItems;
    String hint;
    public Jar(String jarItem, int maxItemsAllowed){
        Random random = new Random();
        this.jarItem = jarItem;
        if(maxItemsAllowed > 0) {
                this.numberOfItems = random.nextInt(maxItemsAllowed) + 1;
                this.maxItems = maxItemsAllowed;
        }else{
            throw new IllegalArgumentException("Number of items must be larger than 0.");
        }
        //System.out.println("Jar created!");
    }

    private boolean integerToStringCheck(String string){
        boolean validEntry = true;
        for(char c : string.toCharArray()){
            if(! Character.isDigit(c)){
                validEntry = false;
                throw new IllegalArgumentException("Must only use digits!");
            }
        }

//        try {
//        }catch(IllegalArgumentException iae){
//            System.out.println("All characters must be digits)");
//        }

        return validEntry;
    }

    public boolean applyGuess(String guess){
        //
//        System.out.println(maxItems);
//        System.out.println(guesses);
        if(!integerToStringCheck(guess)){
            throw new IllegalArgumentException("Must only use digits!");
        }

        int normalizedGuess = Integer.parseInt(guess);
        if(normalizedGuess > maxItems || normalizedGuess < 1){
            throw new IllegalArgumentException("between 1 and" + maxItems);
        }
        try {
            if (normalizedGuess == numberOfItems) {
                numberFound = true;
                numberOfGuesses++;
            } else {
                numberOfGuesses++;
            }
        }catch(IllegalArgumentException iae){

        }
        if(normalizedGuess > numberOfItems && normalizedGuess != numberOfItems){
            hint = "too high";
        }else{
            hint = "too low";
        }

        return numberFound;
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
        return maxItems;
    }
    public String getItemType(){
        return jarItem;
    }
    public String getHint(){return hint;}
}