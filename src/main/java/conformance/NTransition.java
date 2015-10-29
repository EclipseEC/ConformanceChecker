package conformance;

import java.util.ArrayList;
import java.util.List;

/**
 * @(#) Transition.java
 */

public class NTransition {
    private String label;
    private List<NTransition> visiblePredecessors = new ArrayList<NTransition>();
    private List<NTransition> visibleSuccessors = new ArrayList<NTransition>();

    public void fire( NPlace inputPlaces ){
        //TODO WTF DOES IT HAVE TO DO???
    }

    public String getLabel( ){
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public NPlace getInputPlaces( ){
        return null;
    }

    public NPlace getOutputPlaces( ){
        return null;
    }

    public List<NTransition> getVisiblePredecessors() {
        return visiblePredecessors;
    }

    public void setVisiblePredecessors(List<NTransition> list) {
        this.visiblePredecessors = list;
    }

    public List<NTransition> getVisibleSuccessors() {
        return visibleSuccessors;
    }

    public void setVisibleSuccessors(List<NTransition> list) {
        this.visibleSuccessors = list;
    }}
