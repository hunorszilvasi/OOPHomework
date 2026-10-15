package com.mycompany.oophomework.exercise3;

import com.mycompany.oophomework.exercise2.ContentItem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/** Exercise 3 (PDF p. 31): an event with a required future date and location. */
public final class Event extends ContentItem {

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

    private final LocalDateTime eventDateTime;
    private final String location;

    public Event(
            String title,
            String description,
            String language,
            LocalDateTime eventDateTime,
            String location) {
        super(title, description, language);
        this.eventDateTime = Objects.requireNonNull(eventDateTime, "Event date and time are required");
        if (!eventDateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Event date and time must be in the future");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Event location is required");
        }
        this.location = location.strip();
    }

    public Event(
            String title,
            String description,
            String language,
            String eventDateTime,
            String location) {
        this(title, description, language, parseDateTime(eventDateTime), location);
    }

    private static LocalDateTime parseDateTime(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Event date and time are required");
        }
        try {
            return LocalDateTime.parse(value.strip(), DATE_FORMAT);
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException(
                    "Event date and time must use the format yyyy-MM-dd HH:mm:ss", exception);
        }
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public String getLocation() {
        return location;
    }
}
