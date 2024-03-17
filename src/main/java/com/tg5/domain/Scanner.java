package com.tg5.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "scanners")
public class Scanner {

    @Id
    @GeneratedValue
    private Long id;

    private String scannerCode;

    private String name;
}
