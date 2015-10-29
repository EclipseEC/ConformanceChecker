package conformance;

/**
 * @(#) Place.java
 */

public class NPlace
{
    private String label;
    private int numberOfTokens = 0;
    private PetriNet petriNet;
    private NTransition target;
    private NTransition source;

    public NPlace() {}

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

}
