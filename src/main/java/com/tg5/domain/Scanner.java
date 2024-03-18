package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "scanners")
public class Scanner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String scannerCode;

    private String name;

    @ManyToOne
    private Location location;
}
