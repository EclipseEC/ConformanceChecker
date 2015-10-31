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

    public List<NTransition> getStart() {
        List<NTransition> trList = new ArrayList<NTransition>();
        for (NTransition transition : transitions) {
            if (transition.getVisiblePredecessors().isEmpty()) {
                trList.add(transition);
            }
        }
        return trList;
    }

    public List<NTransition> getEnd() {
        List<NTransition> trList = new ArrayList<NTransition>();
        for (NTransition transition : transitions) {
            if (transition.getVisibleSuccessors().isEmpty()) {
                trList.add(transition);
            }
        }
        return trList;
    }

    public NTransition getTransitionWithLabel(String label) {
        for (NTransition tr : transitions) {
            if (tr.getLabel().equals(label)) {
                return tr;
            }
        }
        return null;
    }
}
