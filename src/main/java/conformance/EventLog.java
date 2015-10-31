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

    public EventLog(String name, List<Case> cases) {
        this.name = name;
        this.cases = cases;
    }

    public EventLog(){}

    public String getName() {
        return name;
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
            if (uniqueCases.isEmpty() || !traces.contains(cs.getEventString())) {
                uniqueCases.add(cs);
                traces.add(cs.getEventString());
            }
        }
        return uniqueCases;
    }

    public int getInstanceCount(String eventString) {
        int result = 0;
        for (Case cs : cases) {
            if (cs.getEventString().equals(eventString)) {
                result += 1;
            }
        }
        return result;
    }

}
