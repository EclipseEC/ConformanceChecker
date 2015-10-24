package conformance;

import java.util.List;

/**
 * @(#) PetriNet.java
 */

public class PetriNet
{
	private List<Place> places;

	private List<Transition> transitions;

	public PetriNet(List<Place> places, List<Transition> transitions) {
	    this.places = places;
	    this.transitions = transitions;
	}

	public List<Place> getPlaces(){
	    return places;
	}

	public List<Transition> getTransitions(){
	    return transitions;
	}
}
