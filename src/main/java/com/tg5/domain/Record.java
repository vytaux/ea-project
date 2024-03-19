package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;
import com.tg5.domain.Record;
import java.io.Serializable;
import com.tg5.domain.Session;
@Entity
@Table(name="records")
@Data
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
