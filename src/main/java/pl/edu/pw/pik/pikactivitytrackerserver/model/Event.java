package pl.edu.pw.pik.pikactivitytrackerserver.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Document
public class Event implements Comparable<Event> {

    @Id
    private String id;
    private String website_token;
    private String eventName;
    private String eventData;
    private LocalDateTime eventOccurrenceLocalDateTime;

    public Event()
    {
    }

    public Event(String id, String website_token, String eventName, String eventData, LocalDateTime eventOccurrenceLocalDateTime) {
        this.id = id;
        this.website_token = website_token;
        this.eventName = eventName;
        this.eventData = eventData;
        this.eventOccurrenceLocalDateTime = eventOccurrenceLocalDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsite_token() {
        return website_token;
    }

    public void setWebsite_token(String website_token) {
        this.website_token = website_token;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventOccurrenceLocalDateTime() {
        return eventOccurrenceLocalDateTime;
    }

    public void setEventOccurrenceLocalDateTime(LocalDateTime eventOccurrenceLocalDateTime) {
        this.eventOccurrenceLocalDateTime = eventOccurrenceLocalDateTime;
    }


    @Override
    public int compareTo(Event o) {
        return this.eventOccurrenceLocalDateTime.compareTo(o.eventOccurrenceLocalDateTime);
    }
}
