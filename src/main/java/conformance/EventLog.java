package conformance;

import java.util.ArrayList;
import java.util.List;

/**
 * @(#) EventLog.java
 */

public class EventLog
{
    private String name;
    private List<Case> cases = new ArrayList<Case>();

    public EventLog(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> list) {
        this.cases = list;
    }

    public List<Case> getUniqueCases() {
        List<Case> uniqueCases = new ArrayList<Case>();
        List<String> traces = new ArrayList<String>();
        for (Case cs : cases) {
            if (uniqueCases.isEmpty() || !traces.contains(cs.getEventSequenceString())) {
                uniqueCases.add(cs);
                traces.add(cs.getEventSequenceString());
            }
        }
        return uniqueCases;
    }

    public int getInstanceCount(String eventString) {
        int result = 0;
        for (Case cs : cases) {
            if (cs.getEventSequenceString().equals(eventString)) {
                result += 1;
            }
        }
        return result;
    }

}
