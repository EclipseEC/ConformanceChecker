package conformance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @(#) Case.java
 */

public class Case {

    private String name;
    private Map<String, String> attributes = new HashMap<String, String>();
    private List<Event> events = new ArrayList<Event>();

    public Case() {}

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
