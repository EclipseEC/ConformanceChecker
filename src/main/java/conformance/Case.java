package conformance;

import java.util.List;

/**
 * @(#) Case.java
 */

public class Case {
    @SuppressWarnings("unused")
    private long id;

    private List<String> attributes;

    private List<Event> events;

    public Case(long id, List<String> attributes, EventLog eventLog, List<Event> events) {
        this.id = id;
        this.attributes = attributes;
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<String> getAttributes() {
        return attributes;
    }
}
