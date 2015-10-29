package conformance;

import java.util.ArrayList;
import java.util.List;

/**
 * @(#) PetriNet.java
 */

public class PetriNet
{
	private List<NPlace> places = new ArrayList<NPlace>();

	private List<NTransition> transitions = new ArrayList<NTransition>();

	public PetriNet() {}

    public List<NPlace> getPlaces(){
	    return places;
	}

    public void setPlaces(List<NPlace> list) {
        this.places = list;
    }

	public List<NTransition> getTransitions(){
	    return transitions;
	}

	public void setTransitions(List<NTransition> list) {
	    this.transitions = list;
	}
}
