package conformance;

/**
 * @(#) Transition.java
 */

public class Transition
{
    private String label;

    private PetriNet petriNet;

    public void fire( Place inputPlaces ){

    }

    public String getLabel( ){
        return label;
    }

    public Place getInputPlaces( ){
        return null;
    }

    public Place getOutputPlaces( ){
        return null;
    }

}
