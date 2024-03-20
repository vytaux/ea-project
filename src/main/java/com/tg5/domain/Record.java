package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="records")
@Data
public class Record implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime scanDateTime;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Session session;

    @ManyToOne
    private Scanner scanner;
}
