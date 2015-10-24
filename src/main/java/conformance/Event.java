package conformance;

import java.util.Date;
import java.util.List;

/**
 * @(#) Event.java
 */

public class Event
{
    private String name;

    private Date timestamp;

    private List<String> attributes;

    public Event(String name, Date timestamp, List<String> attributes,
            Transition transition) {
        this.name = name;
        this.timestamp = timestamp;
        this.attributes = attributes;
    }

    public String getName(){
        return name;
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public List<String> getAttributes(){
        return attributes;
    }


}
