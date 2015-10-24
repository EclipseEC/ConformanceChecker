package conformance;

import java.util.List;

/**
 * @(#) EventLog.java
 */

public class EventLog
{
    private String name;

    private List<Case> cases;

    public EventLog(String name, List<Case> cases) {
        this.name = name;
        this.cases = cases;
    }

    public String getName( ){
        return name;
    }

    public List<Case> getCases( ){
        return cases;
    }

}
