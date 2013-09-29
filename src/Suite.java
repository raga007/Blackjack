import java.util.ArrayList;
import java.util.Arrays;


public class Suite {
	
    /** The suite of the card. */
    private final String suite;
    
    /** The valid suite list. */
    private final ArrayList<String> validSuiteList = new ArrayList<String>(Arrays.asList("clubs","diamonds","hearts","spades")); 
    
    // Representation invariant: 
    // suite != null
    // suite is present in validSuiteList
    
    
    /**
     * Instantiates a new suite.
     *
     * @param suite 
     * 			the suite for the card
     */
    public Suite(String suite) {
        this.suite = suite;
        checkRep();
    }
    

    /**
     * Gets the suite.
     *
     * @return the suite
     */
    public String getSuite() {
        return this.suite;
    }
    

    /**
     * Checks the representation
     * of the suite.
     */
    private void checkRep() {
        assert this.suite != null : "Suite of a card is null";
        assert this.validSuiteList.contains(this.suite) : "Invalid Suite. " + this.suite;
    }
    
    /**
     * returns the string
     * representation of Suite
     */
    public String toString() {
        return this.suite;
    }


}
