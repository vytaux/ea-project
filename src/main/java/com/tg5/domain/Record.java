package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;
import com.tg5.domain.Record;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalTime;

import com.tg5.domain.Session;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="records")
@Data
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant scanTime;

    @ManyToOne
    private Member member;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
