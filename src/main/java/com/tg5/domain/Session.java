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
    @JoinColumn(name = "event_id")
    private Event event;



//    @OneToMany(mappedBy = "attendedSessions")
//    private Set<Member> attendees;
    public Session() {
    }

    private LocalDate dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public LocalDate getDayOfWeek() {
        return dayOfWeek;
    }

    public void startTime(LocalDateTime startTime) {

        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {

        return endTime;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

//    public Set<Member> getAttendees() {
//        return attendees;
//    }
//
//    public void setAttendees(Set<Member> attendees) {
//        this.attendees = attendees;
//    }

    public void setDayOfWeek(LocalDate dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

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
}
