package com.tg5.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sessions")
public class Session implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Event event;


    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Record> records;

    public Session() {
    }


    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }




    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}





//    public Set<Member> getAttendees() {
//        return attendees;
//    }
//
//    public void setAttendees(Set<Member> attendees) {
//        this.attendees = attendees;
//    }




