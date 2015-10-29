package conformance;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @(#) Event.java
 */

public class Event
{
    private String name;
    private Date timestamp;
    private String type;
    private Map<String, String> attributes = new HashMap<String, String>();

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

}
