package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Session session;

    @ManyToOne
    private Scanner scanner;
}
