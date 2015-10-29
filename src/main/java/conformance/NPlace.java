package conformance;

/**
 * @(#) Place.java
 */

public class Place
{
    private String name;

    private int numberOfTokens = 0;

    private PetriNet petriNet;

    private Transition target;

    private Transition source;

    public Place(String name, int numberOfTokens) {
        this.name = name;
        this.numberOfTokens = numberOfTokens;
    }

    public String getName( ){
        return name;
    }

    public void setName()
    {

    }

    public int getNumberOfTokens( ){
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens){
        this.numberOfTokens = numberOfTokens;
    }

}
