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

    public String getName( ){
        return name;
    }

    public List<Case> getCases( ){
        return cases;
    }

}
